package presentation.contacts;

import models.Contact;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class ListPane extends JPanel {
    private Vector<Contact> contacts = new Vector<>();
    private Vector<RowContact> rowContacts = new Vector<>();

    public ListPane(){
        setLayout(new BorderLayout());
        setBackground(Color.black);
    }

    public void buildPane(){
        contactsToContactsPanes();
        GridLayout gridLayout=new GridLayout(rowContacts.size(),1);
        setLayout(gridLayout);
        for(RowContact rc : rowContacts){
            add(rc);
        }
    }

    public void contactsToContactsPanes(){
        System.out.println(contacts.size());
        for (Contact c : contacts){
            rowContacts.add(new RowContact());
        }
    }

    public Vector<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Vector<Contact> contacts) {
        this.contacts = contacts;
        buildPane();
    }

}
