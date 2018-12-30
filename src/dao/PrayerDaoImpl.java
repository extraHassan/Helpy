package dao;

import dao.consts.DatabaseInfos;
import models.Prayer;
import utils.databases.DataSource;
import utils.databases.Database;
import utils.databases.MySQLDatabase;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Vector;

public class PrayerDaoImpl implements PrayerDao {

	private DataSource ds;
	private Database db;

	public PrayerDaoImpl() {
		ds = new MySQLDatabase(DatabaseInfos.DATABASE);
		ds.setUser(DatabaseInfos.USER);
		ds.setPassword(DatabaseInfos.PASSWORD);
		db = new Database(ds);
	}

	@Override
	public Prayer select(int id) {
		Prayer prayer = new Prayer();
		String[][] data = db.select(DatabaseInfos.PRAYER, "id", id);
		for (int i = 1; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				// System.out.println(data[i][j]);
				prayer.setId(Integer.parseInt(data[i][j]));
				prayer.setArabicName(data[i][++j]);
				prayer.setFrenchName(data[i][++j]);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
				LocalTime dateTime = LocalTime.parse(data[i][++j], formatter);
				prayer.setTime(dateTime);
				prayer.setNotificationMessage(data[i][++j]);

			}
		}
		return prayer;
	}

	@Override
	public boolean insert(Prayer model) {
		int a = db.insert(model);
		if (a != 0)
			return true;
		return false;
	}

	@Override
	public boolean delete(int id) {
		int a = db.delete(DatabaseInfos.PRAYER, "id", id);
		if (a != 0)
			return true;
		return false;
	}

	@Override
	public boolean update(int id, Prayer model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Prayer> liste() {
		List<Prayer> prayers = new Vector<>();
		String[][] data = db.select(DatabaseInfos.PRAYER);
		for (int i = 1; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
                Prayer prayer = new Prayer();
				prayer.setId(Integer.parseInt(data[i][j]));
                prayer.setFrenchName(data[i][++j]);
                prayer.setArabicName(data[i][++j]);

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
				LocalTime dateTime = LocalTime.parse(data[i][++j], formatter);
				prayer.setTime(dateTime);
				prayer.setNotificationMessage(data[i][++j]);
                System.out.println("arabic name for prayer " + prayer.getArabicName());
				prayers.add(prayer);
			}
		}
		return prayers;
	}

	@Override
	public boolean updateTime(int id, String name) {
		int a = db.update(DatabaseInfos.PRAYER, id, name);
		if (a != 0)
			return true;
		return false;
	}

}
