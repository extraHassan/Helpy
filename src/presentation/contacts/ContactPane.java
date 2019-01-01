package presentation.contacts;

import services.ContactService;

import javax.swing.*;
import java.awt.*;

public class ContactPane extends JFrame {

    private JTabbedPane jTabbedPane = new JTabbedPane();
    private ListContact listPane = new ListContact("resources/images/emoji.jpg");
    private ManageContact manageContact = new ManageContact(listPane);
    private JPanel block_pane = new JPanel(new BorderLayout());

	public ContactPane() {
        initBlockPane();
        setTitle("Contacts");
        setContentPane(block_pane);
        pack();
        setVisible(true);
	}

	public  void initBlockPane(){
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
