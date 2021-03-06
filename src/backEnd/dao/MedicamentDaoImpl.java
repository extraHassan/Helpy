package backEnd.dao;

import backEnd.dao.consts.DatabaseInfos;
import backEnd.models.Medicament;
import backEnd.utils.database.DataSource;
import backEnd.utils.database.Database;
import backEnd.utils.database.MySQLDatabase;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Vector;

public class MedicamentDaoImpl implements MedicamentDao {

	private DataSource ds;
	private Database db;
    private static int id = 0 ;

	public MedicamentDaoImpl() {
		ds = new MySQLDatabase(DatabaseInfos.DATABASE);
		ds.setUser(DatabaseInfos.USER);
		ds.setPassword(DatabaseInfos.PASSWORD);
		db = Database.getDatabase();
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
	    String[][] index = db.executeQuery("select max(id) from medicament");

	    model.setId(id);
	    id++;
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

                String id = data[i][j];
                medicament.setId(Integer.parseInt(id));

                String notification = data[i][++j];
				medicament.setName(notification);

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate dateTime = LocalDate.parse(data[i][++j], formatter);
				medicament.setEnd(dateTime);

				String when = data[i][++j];
				medicament.setWhen(when);

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
