package dao;

import java.util.List;

import models.Agenda;
import utils.databases.DataSource;
import utils.databases.Database;
import utils.databases.MySQLDatabase;

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

	public void insert(Agenda model) {
	}

	public void delete(int id) {
	}

	public void update(int id, Agenda model) {
	}

	public List<Agenda> liste() {
		return null;
	}
	

}
