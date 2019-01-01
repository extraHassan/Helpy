package presentation.contacts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ContactFrame extends  JFrame  {

    private JTabbedPane jTabbedPane = new JTabbedPane();
    private ListContact listPane = new ListContact("resources/images/emoji.jpg");
    private ManageContact manageContact = new ManageContact(listPane);
    private JPanel block_pane = new JPanel(new BorderLayout());

    private static int lock = 0 ;
    private static ContactFrame contactFrame;

    private ContactFrame() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                lock=0;
            }
        });
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

    public static ContactFrame getInstance() {
        if (lock==0){
            contactFrame = new ContactFrame();
            lock=1;
        }
        return contactFrame;
    }
    public static int getLock() {
        return lock;
    }
}
