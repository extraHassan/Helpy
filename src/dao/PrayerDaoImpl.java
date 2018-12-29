package dao;

import java.util.List;

import models.Prayer;
import utils.databases.DataSource;
import utils.databases.Database;
import utils.databases.MySQLDatabase;

public class PrayerDaoImpl implements PrayerDao {

	private DataSource ds;
	private Database db;

	public PrayerDaoImpl() {
		ds = new MySQLDatabase("forever");
		ds.setUser("root");
		ds.setPassword("root");
		db = new Database(ds);
	}

	@Override
	public Prayer select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Prayer model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(int id, Prayer model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Prayer> liste() {
		// TODO Auto-generated method stub
		return null;
	}



}
