package dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Vector;
import dao.consts.DatabaseInfos;
import models.Medicament;
import utils.databases.DataSource;
import utils.databases.Database;
import utils.databases.MySQLDatabase;

public class MedicamentDaoImpl implements MedicamentDao {

	private DataSource ds;
	private Database db;

	public MedicamentDaoImpl() {
		ds = new MySQLDatabase(DatabaseInfos.DATABASE);
		ds.setUser(DatabaseInfos.USER);
		ds.setPassword(DatabaseInfos.PASSWORD);
		db = new Database(ds);
	}

	public Medicament select(int id) {
		Medicament medicament = new Medicament();
		String[][] data = db.select(DatabaseInfos.MEDICAMENT, "id", id);
		for (int i = 1; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				// System.out.println(data[i][j]);
				medicament.setId(Integer.parseInt(data[i][j]));
				medicament.setName(data[i][++j]);

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate dateTime = LocalDate.parse(data[i][++j], formatter);
				medicament.setEnd(dateTime);
				medicament.setWhen(data[i][++j]);

				formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
				LocalTime time = LocalTime.parse(data[i][++j], formatter);
				medicament.setTime(time);
				medicament.setUseCase(data[i][++j]);
				medicament.setPrice(Double.parseDouble(data[i][++j]));
				medicament.setNotificationMessage(data[i][++j]);
			}
		}
		return medicament;
	}

	@Override
	public boolean insert(Medicament model) {
		int a = db.insert(model);
		if (a != 0)
			return true;
		return false;
	}

	@Override
	public boolean delete(int id) {
		int a = db.delete(DatabaseInfos.MEDICAMENT, "id", id);
		if (a != 0)
			return true;
		return false;
	}

	@Override
	public boolean update(int id, Medicament medicament) {
		int a = db.update(DatabaseInfos.MEDICAMENT, medicament.getId(), medicament.getName(), medicament.getEnd(),
				medicament.getWhen(), medicament.getTime(), medicament.getUseCase(), medicament.getPrice());
		if (a != 0)
			return true;
		return false;
	}

	@Override
	public List<Medicament> liste() {
		
		List<Medicament> medicaments = new Vector<>();
		String[][] data = db.select(DatabaseInfos.MEDICAMENT);
		for (int i = 1; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				Medicament medicament = new Medicament();
				// System.out.println(data[i][j]);
				medicament.setId(Integer.parseInt(data[i][j]));
				medicament.setName(data[i][++j]);

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate dateTime = LocalDate.parse(data[i][++j], formatter);
				medicament.setEnd(dateTime);
				medicament.setWhen(data[i][++j]);

				formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
				LocalTime time = LocalTime.parse(data[i][++j], formatter);
				medicament.setTime(time);
				medicament.setUseCase(data[i][++j]);
				medicament.setPrice(Double.parseDouble(data[i][++j]));
				medicament.setNotificationMessage(data[i][++j]);
				medicaments.add(medicament);
			}
		}
		return medicaments;
	}

	@Override
	public boolean updateName(int id, String name) {
		int a = db.update(DatabaseInfos.MEDICAMENT, id, name);
		if (a != 0)
			return true;
		return false;
	}

	@Override
	public boolean updateEndDate(int id, LocalDate end) {
		Medicament medicament = new Medicament();
		int a = db.update(DatabaseInfos.MEDICAMENT, id, medicament.getName(), end);
		if (a != 0)
			return true;
		return false;
	}

	@Override
	public boolean updateWhen(int id, String when) {
		Medicament medicament = new Medicament();
		int a = db.update(DatabaseInfos.MEDICAMENT, id, medicament.getName(),medicament.getEnd(), when);
		if (a != 0)
			return true;
		return false;
	}

	@Override
	public boolean updateTime(int id, LocalTime time) {
		Medicament medicament = new Medicament();
		int a = db.update(DatabaseInfos.MEDICAMENT, id, medicament.getName(),medicament.getEnd(), medicament.getWhen(),time);
		if (a != 0)
			return true;
		return false;
	}

	@Override
	public boolean updateUseCase(int id, String useCase) {
		Medicament medicament = new Medicament();
		int a = db.update(DatabaseInfos.MEDICAMENT, id, medicament.getName(),medicament.getEnd(), medicament.getWhen(),medicament.getTime(), useCase);

		if (a != 0)
			return true;
		return false;
	}

	@Override
	public boolean updatePrice(int id, Double price) {
		Medicament medicament = new Medicament();
		int a = db.update(DatabaseInfos.MEDICAMENT, id, medicament.getName(),medicament.getEnd(), medicament.getWhen(),medicament.getTime(), medicament.getUseCase(), price);
		if (a != 0)
			return true;
		return false;
	}

}
