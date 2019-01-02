package backEnd.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import backEnd.dao.MedicamentDao;
import backEnd.dao.MedicamentDaoImpl;
import backEnd.models.Medicament;

public class MedicamentService {
	private MedicamentDao medicamentDao;

	public MedicamentService() {
		medicamentDao = new MedicamentDaoImpl();
	}

	public boolean addMedicament(Medicament contact) {
		return medicamentDao.insert(contact);
	}

	public Medicament findById(int id) {
		return medicamentDao.select(id);
	}

	public boolean delete(int id) {
		return medicamentDao.delete(id);
	}

	public List<Medicament> findAll() {
		return medicamentDao.liste();
	}

	public boolean updateName(int id, String name) {
		return medicamentDao.updateName(id, name);
	}

	public boolean updateEndDate(int id, LocalDate end) {
		return medicamentDao.updateEndDate(id, end);
	}

	public boolean updateWhen(int id, String when) {
		return medicamentDao.updateWhen(id, when);
	}

	public boolean updateTime(int id, LocalTime time) {
		return medicamentDao.updateTime(id, time);
	}

	public boolean updateUseCase(int id, String useCase) {
		return medicamentDao.updateUseCase(id, useCase);
	}

	public boolean updatePrice(int id, Double price) {
		return medicamentDao.updatePrice(id, price);
	}


}
