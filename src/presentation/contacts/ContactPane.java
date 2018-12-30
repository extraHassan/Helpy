package presentation.contacts;

import services.ContactService;

import javax.swing.*;
import java.awt.*;

public class ContactPane extends JFrame {
    private JTabbedPane jTabbedPane = new JTabbedPane();
    private ListContact listPane = new ListContact();
    private ManageContact manageContact = new ManageContact();
    private JPanel block_pane = new JPanel(new BorderLayout());
    private ContactService contactService = new ContactService();

	public ContactPane() {
	    listPane.setContacts(contactService.listContacts());
        initBlockPane();
        setTitle("Contacts");
        setContentPane(block_pane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
	}

	public  void initBlockPane(){
	   // block_pane.setPreferredSize(new Dimension(350,600));
        JPanel listPaneContainer = new JPanel(new BorderLayout());
        listPaneContainer.add(listPane,BorderLayout.CENTER);
        JScrollPane jScrollPane = new JScrollPane(listPaneContainer);

        jTabbedPane.add("Contacts",jScrollPane);
        jTabbedPane.add("New contact",manageContact);
        block_pane.add(jTabbedPane,BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        new ContactPane();
    }
	
	
}
