package presentation.contacts;

import models.Contact;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class ListContact extends JPanel {
    private List<Contact> contacts = new Vector<>();
    private Vector<RowContact> rowContacts = new Vector<>();

    public ListContact(){
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
            rowContacts.add(new RowContact(c));
        }
    }



    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
        buildPane();
    }

}
