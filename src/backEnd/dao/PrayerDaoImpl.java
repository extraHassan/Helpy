package backEnd.dao;

import backEnd.dao.consts.DatabaseInfos;
import backEnd.models.Prayer;
import backEnd.utils.database.DataSource;
import backEnd.utils.database.Database;
import backEnd.utils.database.MySQLDatabase;

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
		db = Database.getDatabase();
	}

	@Override
	public Prayer select(int id) {
		Prayer prayer = new Prayer();
		String[][] data = db.select(DatabaseInfos.PRAYER, "id", id);
		for (int i = 1; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				prayer.setId(Integer.parseInt(data[i][j]));
				prayer.setFrenchName(data[i][++j]);
                prayer.setArabicName(data[i][++j]);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
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
				prayers.add(prayer);
			}
		}
		return prayers;
	}

	@Override
	public boolean updateTime(int id, String time) {
		Prayer prayer = select(id);
		int a = db.update(DatabaseInfos.PRAYER, id,prayer.getFrenchName(), prayer.getArabicName(), time, prayer.getNotificationMessage());
		if (a != 0)
			return true;
		return false;
	}

}
