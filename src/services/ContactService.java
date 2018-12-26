package services;

import models.Contact;

import java.util.Vector;

public class ContactService {
    public Vector<Contact> listContacts(){
        Vector<Contact> contacts = new Vector<>();
        contacts.add(new Contact());
        contacts.add(new Contact());
        contacts.add(new Contact());
        contacts.add(new Contact());
        contacts.add(new Contact());
        contacts.add(new Contact());
        contacts.add(new Contact());
        return contacts;
    }
}
