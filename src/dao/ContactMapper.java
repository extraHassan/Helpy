package dao;

import java.util.List;

import models.Contact;
import utils.databases.DataSource;
import utils.databases.Database;
import utils.databases.MySQLDatabase;

public class ContactMapper implements Mapper<Contact> {
	
	private DataSource ds;
	private Database db;
	
	public ContactMapper() {
		ds=new MySQLDatabase("forever");
		ds.setUser("root");
		ds.setPassword("root");
		db=new Database(ds); 
	}

	public Contact select(int id) {
		return null;
	}

	public void insert(Contact model) {
		if(model!=null) {
			db.insert(model);
		}
	}

	public void delete(int id) {
	}

	public void update(int id, Contact model) {
	}

	public List<Contact> liste() {
		return null;
	}

	
}
