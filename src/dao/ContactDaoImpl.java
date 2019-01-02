package dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Vector;

import dao.consts.DatabaseInfos;
import models.Contact;
import utils.databases.DataSource;
import utils.databases.Database;
import utils.databases.MySQLDatabase;

public class ContactDaoImpl implements ContactDao {

	private DataSource ds;
	private Database db;

	public ContactDaoImpl() {
		ds = new MySQLDatabase(DatabaseInfos.DATABASE);
		ds.setUser(DatabaseInfos.USER);
		ds.setPassword(DatabaseInfos.PASSWORD);
		db = new Database(ds);
	}

	@Override
	public Contact select(int id) {
		Contact contact = new Contact();
		String[][] data = db.select(DatabaseInfos.CONTACT, "id", id);
		for (int i = 1; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				// System.out.println(data[i][j]);
				contact.setId(Integer.parseInt(data[i][j]));
				contact.setName(data[i][++j]);
				contact.setGroup(data[i][++j]);
				contact.setNumber(data[i][++j]);
				contact.setImage(data[i][++j]);
				
				if(data[i][++j].equals("1")) {
					contact.setFavorite(true);
				}
				
				else if(data[i][j].equals("0")){
					contact.setFavorite(false);
				}
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate dateTime = LocalDate.parse(data[i][++j], formatter);
				contact.setDateAdded(dateTime);

			}
		}
		return contact;
	}

	@Override
	public boolean insert(Contact model) {
	
		int a = db.insert(model);
		if (a != 0)
			return true;
		return false;
	}

	@Override
	public boolean delete(int id) {
		int a = db.delete(DatabaseInfos.CONTACT, "id", id);
		if (a != 0)
			return true;
		return false;
	}

	@Override
	public boolean update(int id, Contact contact) {
		int a = db.update(DatabaseInfos.CONTACT, contact.getId(), contact.getName(), contact.getGroup(), contact.getNumber(),
				contact.getImage(), contact.isFavorite());
		if (a != 0)
			return true;
		return false;
	}

	@Override
	public List<Contact> liste() {
		String[][] data = db.select(DatabaseInfos.CONTACT);
		List<Contact> contacts = new Vector<>();
		Contact contact = null;
		for (int i = 1; i < data.length; i++) {
			for (int j = 0; j < data[i].length;j++) {
				contact = new Contact();
				contact.setId(Integer.parseInt(data[i][j]));
				contact.setName(data[i][++j]);
				contact.setGroup(data[i][++j]);
				contact.setNumber(data[i][++j]);
				contact.setImage(data[i][++j]);
				
				if(data[i][++j].equals("1")) {
					contact.setFavorite(true);
				}
				
				else if(data[i][j].equals("0")){
					contact.setFavorite(false);
				}
		
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate dateTime = LocalDate.parse(data[i][++j], formatter);
				contact.setDateAdded(dateTime);
				
			}
			contacts.add(contact);
		}
		return contacts;

	}

	@Override
	public boolean updateName(int id, String name) {

		int a = db.update(DatabaseInfos.CONTACT, id, name);
		if (a != 0)
			return true;
		return false;
	}

	@Override
	public boolean updateGroup(int id, String group) {
		Contact contact = select(id);
		int a = db.update(DatabaseInfos.CONTACT, id, contact.getName(), group);
		if (a != 0)
			return true;
		return false;
	}

	@Override
	public boolean updateNumber(int id, String number) {
		Contact contact = select(id);
		int a = db.update(DatabaseInfos.CONTACT, id, contact.getName(), contact.getGroup(), number);
		if (a != 0)
			return true;
		return false;
	}

	@Override
	public boolean updateImage(int id, String image) {
		Contact contact = select(id);
		int a = db.update(DatabaseInfos.CONTACT, id, contact.getName(), contact.getGroup(), contact.getNumber(), image);
		if (a != 0)
			return true;
		return false;
	}

	@Override
	public boolean updateFavorite(int id, boolean favorite) {
		Contact contact = select(id);
		int a = db.update(DatabaseInfos.CONTACT, id, contact.getName(), contact.getGroup(), contact.getNumber(), contact.getImage(),
				favorite);
		if (a != 0)
			return true;
		return false;
	}

}
