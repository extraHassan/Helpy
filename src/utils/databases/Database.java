package utils.databases;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

public class Database {
	private DataSource dataSource;
	private Connection db;
	private DatabaseMetaData dbm;

	public Database(DataSource dataSource) {
		setDataSource(dataSource);
	}

	public DataSource getDataSource() {
		return dataSource;

	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		db = dataSource.getConnection();
		try {
			dbm = db.getMetaData();
		} catch (Exception e) {
			System.out.println("erreur : " + e.getMessage());
		}

	}

	public String[][] select(String tableName) {
		return executeQuery("select * from " + delimit(tableName));
	}

	public String[][] select(String tableName, String key, Object value) {
		return executeQuery("select * from " + delimit(tableName) + " where " + delimit(key) + " = '" + value + " '");
	}

	public String[][] select(String tableName, Map<String, Object> keyValue) {
		String query = "select * from " + tableName + " where ";
		Set set = keyValue.entrySet();
		Iterator i = set.iterator();

		while (i.hasNext()) {
			Map.Entry me = (Entry) i.next();
			query = query + me.getKey() + " = '" + me.getValue() + " '";
			if (i.hasNext()) {
				query = query + " AND ";
			}
		}
		return executeQuery(query);

	}

	public String[][] executeQuery(String query) {
		try {
			Statement sql = db.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = sql.executeQuery(query);

			ResultSetMetaData rsm = rs.getMetaData();
			int cols = rsm.getColumnCount();

			rs.last();

			int rows = rs.getRow();

			String data[][] = new String[rows + 1][cols];

			for (int i = 0; i < cols; i++) {
				data[0][i] = rsm.getColumnName(i + 1);

			}

			rs.beforeFirst();
			int row = 1;
			while (rs.next()) {

				for (int i = 0; i < cols; i++) {
					data[row][i] = rs.getString(i + 1);

				}

				row++;
			}

			return data;
		} catch (Exception e) {
			System.out.println("erreur  : >" + e.getMessage());
			return null;
		}
	}

	public int insert(String tableName, Object... row) {
		StringBuffer sb = new StringBuffer("INSERT INTO " + delimit(tableName) + " VALUES('" + row[0] + "'");

		for (int i = 1; i < row.length; i++) {
			if (row[i].equals(true) || row[i].equals(false)) {
				sb.append(", " + row[i] + "");
			} else {
				sb.append(", '" + row[i] + "'");
			}
		}
		sb.append(")");

		try {

			Statement sql = db.createStatement();
			return sql.executeUpdate(sb.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}

	}

	/*
	 * suppose que le nom de la table est = au nom simple de la classe ou bien la
	 * class est annote par @Table a fin de sp�sifier le nom du la table
	 */
	public int insert(Object object) {
		String tableName = object.getClass().getSimpleName();
		Field f[] = object.getClass().getDeclaredFields();

		Object row[] = new Object[f.length];
		try {
			for (int i = 0; i < row.length; i++) {
				f[i].setAccessible(true);
				row[i] = f[i].get(object);
				f[i].setAccessible(false);
			}

			return insert(tableName, row);

		} catch (Exception e) {
			System.out.println("erreur : " + e.getMessage());
			return 0;
		}
	}

	public String delimit(String name) {
		if (name.contains(" ")) {
			return getDataSource().startDelimiter() + "" + name + "" + getDataSource().endDelimiter();
		}

		return name;
	}

	public int update(String tableName, Object... row) {
		StringBuffer sb = new StringBuffer("UPDATE " + delimit(tableName));
		String f[] = fieldNames(tableName);
		if (row[1].equals(true) || row[1].equals(false)) {
			sb.append(" SET " + delimit(f[1]) + " = " + row[1] + " ");
		} else {
			sb.append(" SET " + delimit(f[1]) + " = '" + row[1] + "'");
		}

		for (int i = 2; i < row.length; i++) {
			if (row[i].equals(true) || row[i].equals(false)) {
				sb.append(", " + delimit(f[i]) + " = " + row[i] + " ");
			} else {
				sb.append(", " + delimit(f[i]) + " = '" + row[i] + "'");
			}

		}

		sb.append("where " + delimit(f[0]) + " = " + row[0]);

		try {
			Statement sql = db.createStatement();
			return sql.executeUpdate(sb.toString());
		} catch (Exception e) {
			System.out.println("erreur + " + e.getMessage());
			return 0;
		}

	}

	public int delete(String tableName, String columnName, Object value) {
		try {
			Statement sql = db.createStatement();
			return sql.executeUpdate("DELETE FROM " + tableName + " WHERE " + columnName + " = '" + value + "'");
		} catch (SQLException e) {
			System.out.println("erreur + " + e.getMessage());
			return 0;
		}
	}

	public String[] fieldNames(String tableName) {
		try {
			ResultSet rs = dbm.getColumns(null, null, tableName, null);
			/*
			 * ResultSetMetaData rsm = rs.getMetaData();
			 * 
			 * for (int i = 1; i < rsm.getColumnCount(); i++) {
			 * System.out.println(rsm.getColumnName(i)); }
			 * 
			 */
			Vector<String> fields = new Vector<>();
			while (rs.next()) {
				fields.add(rs.getString(4));
			}

			String t[] = new String[fields.size()];
			fields.toArray(t);
			return t;

		} catch (Exception e) {
			System.out.println("erreur + " + e.getMessage());
		}
		return null;
	}

	public String[] tableNames() {
		try {
			ResultSet rs = dbm.getTables(null, null, null, new String[] { "Table"/* ,"View","SYSTEM TABLE" */ });
			/*
			 * ResultSetMetaData rsm = rs.getMetaData();
			 * 
			 * for (int i = 1; i < rsm.getColumnCount(); i++) {
			 * System.out.println(rsm.getColumnName(i)); }
			 * 
			 */
			Vector<String> tables = new Vector<>();
			while (rs.next()) {
				tables.add(rs.getString(3));
			}

			String t[] = new String[tables.size()];
			tables.toArray(t);
			return t;

		} catch (Exception e) {
			System.out.println("erreur + " + e.getMessage());
		}
		return null;
	}

}

/*
 * public void testSelect() { try { //moteur d'execution de requete "statement"
 * Statement sql = db.createStatement(); ResultSet rs =
 * sql.executeQuery("select * from authors"); while (rs.next()) {
 * System.out.println(rs.getString(2));
 * 
 * 
 * } } catch (Exception e) { System.out.println("erreur  : "+e.getMessage()); }
 * }
 */