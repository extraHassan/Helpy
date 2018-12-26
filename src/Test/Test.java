package Test;

import java.sql.Date;

import dao.ContactMapper;
import models.Contact;
import presentation.Frame;

public class Test {
	
	public Test() {
		exp02(); 
	}
	
	
	void exp01() {
		Contact contact = new Contact(); 
		contact.setDateAdded(new Date(System.currentTimeMillis()));
		contact.setFavorite(true);
		contact.setGroup("famille");
		contact.setId(2);
		contact.setImage("no image");
		contact.setName("zouhir bibi");
		contact.setNumber("0635135348");
		ContactMapper contactMapper = new ContactMapper();
		contactMapper.insert(contact);
	}
	
	void exp02() {
		new Frame();
	}
	
	public static void main(String[] args) {
		new Test();
	}
}
