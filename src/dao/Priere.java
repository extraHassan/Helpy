package dao;

import java.util.List;

import utils.databases.DataSource;
import utils.databases.Database;
import utils.databases.MySQLDatabase;

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

	public void insert(Priere model) {
	}

	public void delete(int id) {
	}

	public void update(int id, Priere model) {
	}

	public List<Priere> liste() {
		return null;
	}

	

}
