package dao;

import models.Contact;
import utils.databases.DataSource;
import utils.databases.Database;
import utils.databases.MySQLDatabase;

import java.util.List;

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

	@Override
	public boolean insert(Contact model) {
		return false;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}

	@Override
	public boolean update(int id, Contact model) {
		return false;
	}

	public List<Contact> liste() {
		return null;
	}

	
}
