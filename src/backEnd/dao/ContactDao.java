package backEnd.dao;

import backEnd.models.Contact;

public interface ContactDao extends Mapper<Contact>{
	public boolean updateName(int id, String name);
	public boolean updateGroup(int id, String group);
	public boolean updateNumber(int id, String number);
	public boolean updateImage(int id, String image);
	public boolean updateFavorite(int id, boolean favorite);
}
