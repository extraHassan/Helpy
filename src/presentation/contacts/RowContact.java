package presentation.contacts;

import models.Contact;
import presentation.components.ImagePane;
import services.ContactService;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RowContact extends JPanel {

    private JPanel center =null;
    private JLabel date;
    private JPanel contactHandler = new JPanel(new GridLayout(1,3,10,0));
    private ImagePane profile = new ImagePane("resources/images/contact.png");
    private JLabel nameAndGroup;
    private JLabel phone;
    private ListPane container;

    private Font font =new Font("Georgia",Font.ROMAN_BASELINE, 20);
    private Color bgColor = new Color(250,227,214);
    private Color fontColor= new Color(17,47,59);
    private Color borderColor= new Color(227,204,189);
    EmptyBorder emptyBorder = new EmptyBorder(4,2,4,2);

    private Contact contact;
    private ContactService contactService  = new ContactService();

    public void initDate(){
        String labelDate  = contact.getDateAdded().toString();
        date=new JLabel(labelDate);
        date.setFont(font);
        date.setHorizontalAlignment(SwingConstants.CENTER);
        date.setForeground(fontColor);
        date.setBackground(bgColor);
    }

    public void initPhone(){
        String labelPhone = contact.getNumber();
        phone = new JLabel(labelPhone);
        phone.setFont(font);
        phone.setHorizontalAlignment(SwingConstants.CENTER);
        phone.setForeground(fontColor);
        phone.setBackground(bgColor);
    }

    public void initNameAndGroup(){
        String labelNameAndGroup=contact.getName()+" ("+contact.getGroup()+")";
        nameAndGroup=new JLabel(labelNameAndGroup);
        nameAndGroup.setFont(font);
        nameAndGroup.setHorizontalAlignment(SwingConstants.CENTER);
        nameAndGroup.setForeground(fontColor);
        nameAndGroup.setBorder(BorderFactory.createMatteBorder(0,0,1,0,borderColor));
    }

    public void initProfile(){
        String labelProfile = contact.getImage();
        profile = new ImagePane(labelProfile);
        profile.setPreferredSize(new Dimension(70, 60));
        profile.setBackground(bgColor);
        profile.setBorder(BorderFactory.createMatteBorder(0,0,0,1,borderColor));
    }

    public  void initContactHandler(){
        ImagePane fav;
        if(contact.isFavorite()){
             fav = new ImagePane("resources/images/yellowStar.png");
        }
        else{
            fav = new ImagePane("resources/images/star.png");
        }
        ImagePane update = new ImagePane("resources/images/update.png");
        ImagePane delete = new ImagePane("resources/images/suprimer.png");
        fav.setPreferredSize(new Dimension(20,20));
        update.setPreferredSize(new Dimension(20,20));
        delete.setPreferredSize(new Dimension(20,20));
        delete.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int response= JOptionPane.showConfirmDialog(delete,"are you sure ? ");
                if(response==0){
                    contactService.deleteContact(contact.getId());
                    System.out.println("Contact deleted");
                    container.getRowContacts().clear();
                    container.buildPane();
                }
            }
        });

        contactHandler.add(fav);
        contactHandler.add(update);
        contactHandler.add(delete);
        contactHandler.setBackground(bgColor);
    }

    public  void initThis(){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));
        setBackground(bgColor);
    }

    public void initCenter(){
        center=new JPanel(new BorderLayout());
        center.add(nameAndGroup,BorderLayout.NORTH);
        center.add(phone,BorderLayout.CENTER);
        center.add(contactHandler,BorderLayout.EAST);
        center.add(date,BorderLayout.SOUTH);
        center.setBackground(bgColor);
    }

    public RowContact(ListPane container, Contact contact){
        this.container=container;
        this.contact = contact;
        initDate();
        initPhone();
        initNameAndGroup();
        initProfile();
        initContactHandler();
        initCenter();
        initThis();

        JPanel block_pane = new JPanel(new BorderLayout());
        block_pane.add(profile,BorderLayout.WEST);
        block_pane.add(center,BorderLayout.CENTER);
        block_pane.setBorder(emptyBorder);
        block_pane.setBackground(bgColor);
        add(block_pane,BorderLayout.NORTH);
    }

    public ListPane getContainer() {
        return container;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public void setContainer(ListPane container) {
        this.container = container;
    }
 }
