package dao;

import java.util.List;

import models.Agenda;
import utils.databases.DataSource;
import utils.databases.Database;
import utils.databases.MySQLDatabase;

public class AgendaDaoImpl implements AgendaDao {

	private DataSource ds;
	private Database db;

	public AgendaDaoImpl() {
		ds = new MySQLDatabase("forever");
		ds.setUser("root");
		ds.setPassword("root");
		db = new Database(ds);
	}

	public Agenda select(int id) {
		Agenda agenda = new Agenda();
		String[][] data = db.select("Agenda", "id", id);
		for (int i = 1; i < data.length; i++) {
			for (int j = 0; j < data[i].length; i++) {
				agenda.setId(Integer.parseInt(data[i][j]));

			}
		}
		return agenda;
	}

	@Override
	public boolean insert(Agenda model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(int id, Agenda model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Agenda> liste() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agenda selectByEvent(String event) {
		// TODO Auto-generated method stub
		return null;
	}


}
