package Test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;

import dao.ContactDaoImpl;
import dao.MedicamentDao;
import dao.MedicamentDaoImpl;
import dao.PrayerDao;
import dao.PrayerDaoImpl;
import models.Contact;
import models.Medicament;
import models.Prayer;
import services.ContactService;
import services.MailService;
import services.NotificatorService;


public class Test {

	public Test() {
		exp02();
	}

	void exp01() {
		Contact contact = new Contact();
		ContactService cs = new ContactService();
		
		contact.setDateAdded(LocalDate.now());
		contact.setFavorite(true);
		contact.setGroup("sdkjf");
		File fi = new File("C:\\Users\\muscu\\Desktop\\bricolo\\logo2.png");
		
        try {
			FileInputStream fis = new FileInputStream(fi);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		contact.setImage(fi.getPath());
		//System.out.println(contact.getImage());
		contact.setName("test image ");
		contact.setNumber("0635135348");
		ContactDaoImpl contactMapper = new ContactDaoImpl();
		//System.out.println(contactMapper.select(7).isFavorite());
		 contactMapper.insert(contact);
		// cs.addContact(contact);
		// cs.updateFavorite(7, true);
		// contactMapper.delete(5);
		//System.out.println(contactMapper.updateFavorite(6, false));
		// System.out.println(contactMapper.updateName(6, "ahmed belarbi"));
		// System.out.println(contactMapper.updateGroup(6, "friends"));
		// System.out.println(contactMapper.updateImage(6, "pas dimage"));
		
		System.out.println(contactMapper.liste().get(13).getImage());
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
		//System.out.println(medicamentMapper.insert(medicament));
		
		System.out.println(medicamentMapper.liste());
	}

	void exp02() {
		
		PrayerDao pd = new PrayerDaoImpl();
		Prayer p = new Prayer();
		p.setArabicName("dohr");
		p.setFrenchName("dooohr");
		p.setTime(LocalTime.now());
		p.setNotificationMessage("sdahfasdklh a hdsjkfh asd fhaef kasjdh fjkasdhf jkasdhf");
		NotificatorService ns = new NotificatorService();
		ns.notifyPrayer(p);
		
		
		
		//System.out.println(pd.insert(p));
	}
	
	void exp04() {
		MailService ms = new MailService();
		ms.sendEmail("hassounnambz@gmail.com", "6*15@hassan2018", "elmzabi.hassan18@gmail.com","test d service","slaaaa w slaaaam 3la rassolah ewa jme3 rassk 3liya");
	}

	public static void main(String[] args) {
		new Test();
	}
}
