package Test;


import java.time.LocalDate;
import java.time.LocalTime;

import dao.AgendaDao;
import dao.AgendaDaoImpl;
import dao.ContactDaoImpl;
import dao.MedicamentDao;
import dao.MedicamentDaoImpl;
import models.Agenda;
import models.Contact;
import models.Medicament;


public class Test {

	public Test() {
		exp03();
	}

	void exp01() {
		Contact contact = new Contact();

		contact.setDateAdded(LocalDate.now());
		contact.setFavorite(true);
		contact.setGroup("famille");

		contact.setImage("no image");
		contact.setName("toto tota");
		contact.setNumber("0635135348");
		ContactDaoImpl contactMapper = new ContactDaoImpl();
		//System.out.println(contactMapper.select(6).getDateAdded());
		// contactMapper.insert(contact);
		// contactMapper.delete(5);
		//System.out.println(contactMapper.updateFavorite(6, false));
		// System.out.println(contactMapper.updateName(6, "ahmed belarbi"));
		// System.out.println(contactMapper.updateGroup(6, "friends"));
		// System.out.println(contactMapper.updateImage(6, "pas dimage"));
		System.out.println(contactMapper.liste().get(0).getId());
	}
	
	void exp03() {
		Medicament medicament = new Medicament();
		medicament.setEnd(LocalDate.of(2018, 02, 5));
		medicament.setName("oxycolo");
		medicament.setNotificationMessage("prenez votre med");
		medicament.setPrice(223.3);
		medicament.setTime(LocalTime.of(23, 04));
		medicament.setUseCase(" boire");
		medicament.setWhen("3 fois");
		MedicamentDao medicamentMapper = new MedicamentDaoImpl();
		//System.out.println(contactMapper.select(6).getDateAdded());
		// contactMapper.insert(contact);
		// contactMapper.delete(5);
		//System.out.println(contactMapper.updateFavorite(6, false));
		// System.out.println(contactMapper.updateName(6, "ahmed belarbi"));
		// System.out.println(contactMapper.updateGroup(6, "friends"));
		// System.out.println(contactMapper.updateImage(6, "pas dimage"));
		System.out.println(medicamentMapper.insert(medicament));
		System.out.println(medicamentMapper.select(1).getUseCase());
	}

	void exp02() {
		Agenda agenda = new Agenda();
		
		agenda.setDate(LocalDate.now());
		agenda.setDescription("ashdsdjflasdfjh");
		agenda.setEvent("sortie");
		agenda.setNotificationMessage("hola amigo");
		agenda.setTime(LocalTime.now());
		
		AgendaDao agendaMapper = new AgendaDaoImpl();
		
		//System.out.println(agendaMapper.insert(agenda));contactMapper.liste()
		//System.out.println(agendaMapper.select(1).getTime());
	}

	public static void main(String[] args) {
		new Test();
	}
}
