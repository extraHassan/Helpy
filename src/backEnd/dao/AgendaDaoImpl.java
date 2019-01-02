package backEnd.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Vector;

import backEnd.dao.consts.DatabaseInfos;
import backEnd.models.Agenda;
import backEnd.utils.database.DataSource;
import backEnd.utils.database.Database;
import backEnd.utils.database.MySQLDatabase;

public class AgendaDaoImpl implements AgendaDao {

	private DataSource ds;
	private Database db;

	public AgendaDaoImpl() {
		ds = new MySQLDatabase(DatabaseInfos.DATABASE);
		ds.setUser(DatabaseInfos.USER);
		ds.setPassword(DatabaseInfos.PASSWORD);
		db = Database.getDatabase();
	}

	public Agenda select(int id) {
		Agenda agenda = new Agenda();
		String[][] data = db.select(DatabaseInfos.AGENDA, "id", id);
		for (int i = 1; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				// System.out.println(data[i][j]);
				agenda.setId(Integer.parseInt(data[i][j]));
				agenda.setEvent(data[i][++j]);
				agenda.setDescription(data[i][++j]);
				agenda.setNotificationMessage(data[i][++j]);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate dateTime = LocalDate.parse(data[i][++j], formatter);
				agenda.setDate(dateTime);
				formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
				LocalTime time = LocalTime.parse(data[i][++j], formatter);
				agenda.setTime(time);

			}
		}
		return agenda;
	}

	@Override
	public boolean insert(Agenda model) {
		int a = db.insert(model);
		if (a != 0)
			return true;
		return false;
	}

	@Override
	public boolean delete(int id) {
		int a = db.delete(DatabaseInfos.AGENDA, "id", id);
		if (a != 0)
			return true;
		return false;
	}

	@Override
	public boolean update(int id, Agenda model) {
		int a = db.update(DatabaseInfos.CONTACT, model.getId(), model.getEvent(), model.getDescription(),
				model.getNotificationMessage(), model.getDate(), model.getTime());
		if (a != 0)
			return true;
		return false;
	}

	@Override
	public List<Agenda> liste() {
		String[][] data = db.select(DatabaseInfos.CONTACT);
		List<Agenda> agendas = new Vector<>();
		Agenda agenda = new Agenda();
		for (int i = 1; i < data.length; i++) {
			for (int j = 0; j < data[i].length;) {
				agenda.setId(Integer.parseInt(data[i][j]));
				agenda.setEvent(data[i][++j]);
				agenda.setDescription(data[i][++j]);
				agenda.setNotificationMessage(data[i][++j]);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate dateTime = LocalDate.parse(data[i][++j], formatter);
				agenda.setDate(dateTime);
				formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
				LocalTime time = LocalTime.parse(data[i][++j], formatter);
				agenda.setTime(time);
				agendas.add(agenda);
			}
		}
		return agendas;

	}

	@Override
	public Agenda selectByEvent(String event) {
		Agenda agenda = new Agenda();
		String[][] data = db.select(DatabaseInfos.AGENDA, "event", event);
		for (int i = 1; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				// System.out.println(data[i][j]);
				agenda.setId(Integer.parseInt(data[i][j]));
				agenda.setEvent(data[i][++j]);
				agenda.setDescription(data[i][++j]);
				agenda.setNotificationMessage(data[i][++j]);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate dateTime = LocalDate.parse(data[i][++j], formatter);
				agenda.setDate(dateTime);
				formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
				LocalTime time = LocalTime.parse(data[i][++j], formatter);
				agenda.setTime(time);

			}
		}
		return agenda;

	}

}
