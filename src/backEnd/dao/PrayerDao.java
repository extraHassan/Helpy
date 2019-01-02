package backEnd.dao;

import backEnd.models.Prayer;

public interface PrayerDao extends Mapper<Prayer> {
	public boolean updateTime(int id, String name);

}
