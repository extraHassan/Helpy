package services;

import models.Contact;

import java.util.Vector;

public class ContactService {
    public Vector<Contact> listContacts(){
        Vector<Contact> contacts = new Vector<>();
        Contact contact = new Contact();
        contact.setId(2);
        contacts.add(contact);
        return contacts;
    }
    public int deleteContact(int id){
        return 0;
    }
}
