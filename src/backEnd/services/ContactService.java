package backEnd.services;

import java.util.List;

import backEnd.dao.ContactDao;
import backEnd.dao.ContactDaoImpl;
import backEnd.models.Contact;

public class ContactService {
	private ContactDao contactDao;

	public ContactService() {
		contactDao = new ContactDaoImpl();
	}

	public boolean addContact(Contact contact) {
		return contactDao.insert(contact);
	}

	public Contact findById(int id) {
		return contactDao.select(id);
	}

	public boolean delete(int id) {
		return contactDao.delete(id);
	}

	public List<Contact> findAll() {
		return contactDao.liste();
	}

	public boolean updateName(int id, String name) {
		return contactDao.updateName(id, name);
	}

	public boolean updateGroup(int id, String group) {
		return contactDao.updateGroup(id, group);
	}

	public boolean updateNumber(int id, String number) {
		return contactDao.updateNumber(id, number);
	}

	public boolean updateImage(int id, String image) {
		return contactDao.updateImage(id, image);
	}

	public boolean updateFavorite(int id, boolean favorite) {
		return contactDao.updateFavorite(id, favorite);
	}
}
