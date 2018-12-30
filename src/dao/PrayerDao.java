package dao;

import models.Prayer;

public interface PrayerDao extends Mapper<Prayer> {
	public boolean updateTime(int id, String name);

}
