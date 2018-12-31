package dao;

import java.time.LocalDate;
import java.time.LocalTime;

import models.Medicament;

public interface MedicamentDao extends Mapper<Medicament> {
	public boolean updateName(int id, String name);
	public boolean updateEndDate(int id, LocalDate end);
	public boolean updateWhen(int id, String when);
	public boolean updateTime(int id, LocalTime time);
	public boolean updateUseCase(int id, String useCase);
	public boolean updatePrice(int id, Double price);

}
