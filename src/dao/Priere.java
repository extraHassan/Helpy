package dao;

import utils.databases.DataSource;
import utils.databases.Database;
import utils.databases.MySQLDatabase;

import java.util.List;

public class Priere implements Mapper<Priere>{
	
	private DataSource ds;
	private Database db;
	
	public Priere() {
		ds=new MySQLDatabase("forever");
		ds.setUser("root");
		ds.setPassword("root");
		db=new Database(ds); 
	}
	
	public Priere select(int id) {
		return null;
	}

	@Override
	public boolean insert(Priere model) {
		return false;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}

	@Override
	public boolean update(int id, Priere model) {
		return false;
	}


	public List<Priere> liste() {
		return null;
	}

	

}
