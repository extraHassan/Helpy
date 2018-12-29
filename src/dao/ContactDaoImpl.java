package dao;

import java.util.List;

import models.Contact;
import utils.databases.DataSource;
import utils.databases.Database;
import utils.databases.MySQLDatabase;

public class ContactDaoImpl implements ContactDao {
	
	private DataSource ds;
	private Database db;
	
	public ContactDaoImpl() {
		ds=new MySQLDatabase("forever");
		ds.setUser("root");
		ds.setPassword("root");
		db=new Database(ds); 
	}

	@Override
	public Contact select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Contact model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(int id, Contact model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Contact> liste() {
		// TODO Auto-generated method stub
		return null;
	}



	
}
