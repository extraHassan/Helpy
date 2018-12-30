package dao;

import models.Agenda;
import utils.databases.DataSource;
import utils.databases.Database;
import utils.databases.MySQLDatabase;

import java.util.List;

public class AgendaMapper implements Mapper<Agenda> {
	
	private DataSource ds;
	private Database db;
	
	public AgendaMapper() {
		ds=new MySQLDatabase("forever");
		ds.setUser("root");
		ds.setPassword("root");
		db=new Database(ds); 
	}
	
	public Agenda select(int id) {
		return null;
	}

	@Override
	public boolean insert(Agenda model) {
		return false;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}

	@Override
	public boolean update(int id, Agenda model) {
		return false;
	}

	public List<Agenda> liste() {
		return null;
	}
	

}
