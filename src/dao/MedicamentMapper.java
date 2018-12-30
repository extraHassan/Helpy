package dao;

import java.util.List;

import models.Medicament;
import utils.databases.DataSource;
import utils.databases.Database;
import utils.databases.MySQLDatabase;

public class MedicamentMapper implements Mapper<Medicament> {

	private DataSource ds;
	private Database db;
	
	public MedicamentMapper() {
		ds=new MySQLDatabase("forever");
		ds.setUser("root");
		ds.setPassword("root");
		db=new Database(ds); 
	}
	
	public Medicament select(int id) {
		return null;
	}

	public void insert(Medicament model) {
		
	}

	public void delete(int id) {
	}

	public void update(int id, Medicament model) {
	}

	public List<Medicament> liste() {
		return null;
	}
	
}
