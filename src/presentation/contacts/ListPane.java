package presentation.contacts;

import models.Contact;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.util.HashMap;
import java.util.Vector;

public class ListPane extends JPanel {
    private HashMap<Integer,Contact> contacts = new HashMap<>();
    private HashMap<Integer,RowContact> rowContacts = new HashMap<>();

    public HashMap<Integer, Contact> getContacts() {
        return contacts;
    }

    public void setContacts(HashMap<Integer, Contact> contacts) {
        this.contacts = contacts;
    }

    public ListPane(){
        setLayout(new BorderLayout());
        setBackground(Color.black);
    }

    public void buildPane(){
        contactsToContactsPanes();
        GridLayout gridLayout=new GridLayout(rowContacts.size(),1);
        setLayout(gridLayout);

    }

    public void contactsToContactsPanes(){
        rowContacts.clear();
        if(contacts.size()!=0){
            for(Integer key:contacts.keySet()){
                Contact contact = contacts.get(key);
                rowContacts.put(contact.getId(),new RowContact(this,contact));
            }
            for(Integer index:rowContacts.keySet()){
                add(new RowContact(this,contacts.get(index)));
            }
        }
    }

    public void setContacts(Vector<Contact> listContacts) {
        System.out.println("listContacts : ==> " + listContacts.size());
        for(Contact c : listContacts){
            contacts.put(c.getId(),c);
        }
        buildPane();
    }

    public HashMap<Integer, RowContact> getRowContacts() {
        return rowContacts;
    }
}
