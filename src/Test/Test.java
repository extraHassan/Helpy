package Test;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
import services.PrayerService;


public class Test {

	public Test() {
		exp04();
	}


	public void exp04(){
        PrayerService prayerService = new PrayerService();
        DateTimeFormatter  dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");



        Prayer fajr = new Prayer();
        fajr.setId(0);
        fajr.setArabicName("الفجر");
        fajr.setFrenchName("Fajr");
        fajr.setTime(LocalTime.parse("06:51",dateTimeFormatter));
        fajr.setNotificationMessage("الصلاة خير من النوم - قم إلى صلاتك رحمك الله");

        prayerService.addPrayer(fajr);

        Prayer dohr = new Prayer();
        dohr.setId(1);
        dohr.setArabicName("الظهر");
        dohr.setFrenchName("Dohr");
        dohr.setTime(LocalTime.parse("13:28",dateTimeFormatter));
        dohr.setNotificationMessage("حان موعد أذان صلاة الظهر");
        prayerService.addPrayer(dohr);



        Prayer asr = new Prayer();
        asr.setId(2);
        asr.setArabicName("العصر");
        asr.setFrenchName("Asr");
        asr.setTime(LocalTime.parse("16:03",dateTimeFormatter));
        asr.setNotificationMessage("حان موعد أذان صلاة العصر");
        prayerService.addPrayer(asr);

        Prayer maghrib = new Prayer();
        maghrib.setId(3);
        maghrib.setArabicName("المغرب");
        maghrib.setFrenchName("Maghrib");
        maghrib.setTime(LocalTime.parse("18:27",dateTimeFormatter));
        maghrib.setNotificationMessage("حان موعد أذان صلاة المغرب");
        prayerService.addPrayer(maghrib);

        Prayer ichaa = new Prayer();
        ichaa.setId(4);
        ichaa.setArabicName("العشاء");
        ichaa.setFrenchName("Ichaa");
        ichaa.setTime(LocalTime.parse("19:45",dateTimeFormatter));
        ichaa.setNotificationMessage("حان موعد أذان صلاة العشاء");
        prayerService.addPrayer(ichaa);


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
	
	void exp05() {
		MailService ms = new MailService();
		ms.sendEmail("hassounnambz@gmail.com", "6*15@hassan2018", "elmzabi.hassan18@gmail.com","test d service","slaaaa w slaaaam 3la rassolah ewa jme3 rassk 3liya");
	}

	public static void main(String[] args) {
		new Test();
	}
}
