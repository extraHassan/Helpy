package fontEnd.contacts;

import backEnd.models.Contact;
import fontEnd.utils.components.Designer;
import fontEnd.utils.components.ImagePane;
import backEnd.services.ContactService;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class ListContact extends ImagePane {
    private List<Contact> contacts = new Vector<>();
    private Vector<RowContact> rowContacts = new Vector<>();
    private ContactService contactService=new ContactService();
    private Designer designer = new Designer();

    public ListContact(String backgroundImage){
        super(backgroundImage);
        setLayout(new BorderLayout());
        setBackground(Color.black);
        buildPane();
    }

    public void deleteRowContact(int id){
        contactService.delete(id);
        removeAll();
        revalidate();
        repaint();
        buildPane();
    }

    public void refresh(){
        removeAll();
        revalidate();
        repaint();
        buildPane();
    }


    public void buildPane(){
        contactsToContactsPanes();
        setLayout(new BorderLayout());
        JPanel panelContainer = new JPanel(new GridLayout(rowContacts.size(),1,15,15));
        panelContainer.setOpaque(false);
        if (rowContacts.isEmpty()){
            ImagePane empty= new ImagePane("resources/images/database.png");
            JPanel emptyContainer = new JPanel(new BorderLayout());
            emptyContainer.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
            emptyContainer.add(empty);
            emptyContainer.setBackground(designer.getBgColor());
            removeAll();
            add(emptyContainer,BorderLayout.CENTER);
            revalidate();
            repaint();
        }
            for(RowContact rc : rowContacts){
                JPanel panel = new JPanel(new BorderLayout());
                panel.add(rc,BorderLayout.NORTH);
                panelContainer.add(panel);
            }
        add(panelContainer,BorderLayout.NORTH);
    }

    public void contactsToContactsPanes(){
        contacts=contactService.findAll();
        rowContacts.clear();
        for (Contact c : contacts){
            rowContacts.add(new RowContact(this,c));
        }
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
        buildPane();
    }

}
