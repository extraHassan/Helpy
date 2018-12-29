package dao;

import java.util.List;

import models.Medicament;
import utils.databases.DataSource;
import utils.databases.Database;
import utils.databases.MySQLDatabase;

public class MedicamentDaoImpl implements MedicamentDao {

	private DataSource ds;
	private Database db;
	
	public MedicamentDaoImpl() {
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(int id, Medicament model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Medicament> liste() {
		// TODO Auto-generated method stub
		return null;
	}

}
