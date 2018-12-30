package dao;

import models.Medicament;
import utils.databases.DataSource;
import utils.databases.Database;
import utils.databases.MySQLDatabase;

import java.util.List;

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

	@Override
	public boolean insert(Medicament model) {
		return false;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}

	@Override
	public boolean update(int id, Medicament model) {
		return false;
	}


	public List<Medicament> liste() {
		return null;
	}
	
}
