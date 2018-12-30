package services;

import java.util.List;

import dao.PrayerDao;
import dao.PrayerDaoImpl;
import models.Prayer;

public class PrayerService {

	private PrayerDao prayerDao;

	public PrayerService() {
		prayerDao = new PrayerDaoImpl();
	}

	public boolean addPrayer(Prayer prayer) {
		return prayerDao.insert(prayer);
	}

	public Prayer findById(int id) {
		return prayerDao.select(id);
	}

	public boolean delete(int id) {
		return prayerDao.delete(id);
	}

	public List<Prayer> findAll() {
		return prayerDao.liste();
	}

	public boolean update(int id, Prayer model) {
		return prayerDao.update(id, model);
	}

	public boolean updateTime(int id, String group) {
		return prayerDao.updateTime(id, group);
	}
}
