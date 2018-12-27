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

    public ListPane(){
        setLayout(new BorderLayout());
        setBackground(Color.black);
    }

    public void buildPane(){
        contactsToContactsPanes();
        GridLayout gridLayout=new GridLayout(rowContacts.size(),1);
        setLayout(gridLayout);
        for(int i=0;i<rowContacts.size();i++){
            add(new RowContact(this,contacts.get(0)));
        }
    }

    public void contactsToContactsPanes(){
        System.out.println(contacts.size());
        for(int i=0;i<contacts.size();i++){
            Contact c = contacts.get(i);
            c.setDateAdded(new Date(System.currentTimeMillis()));
            c.setFavorite(true);
            c.setGroup("famille");
            c.setId(2);
            c.setImage("resources/images/contact.png");
            c.setName("zouhir bibi");
            c.setNumber("0635135348");
            rowContacts.put(c.getId(),new RowContact(this,c));
        }
    }

    public HashMap<Integer, Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Vector<Contact> conta) {
        for(Contact c : conta){
            contacts.put(c.getId(),c);
        }
        this.contacts = contacts;
        buildPane();
    }

    public HashMap<Integer, RowContact> getRowContacts() {
        return rowContacts;
    }

    public void setRowContacts(HashMap<Integer, RowContact> rowContacts) {
        this.rowContacts = rowContacts;
    }
}
