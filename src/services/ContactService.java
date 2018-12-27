package services;

import models.Contact;

import java.sql.Date;
import java.util.Vector;

public class ContactService {
    public Vector<Contact> listContacts(){
        Vector<Contact> contacts = new Vector<>();
        Contact c = new Contact();
        c.setId(2);
        c.setDateAdded(new Date(System.currentTimeMillis()));
        c.setFavorite(true);
        c.setGroup("family");
        c.setId(2);
        c.setImage("resources/images/contact.png");
        c.setName("Zouhir bibi");
        c.setNumber("0635135348");
        contacts.add(c);
        return contacts;
    }
    public int deleteContact(int id){
        return 0;
    }
}
