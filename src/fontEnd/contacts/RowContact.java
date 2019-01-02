package fontEnd.contacts;

import backEnd.models.Contact;
import fontEnd.utils.components.ImagePane;
import backEnd.services.ContactService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RowContact extends JPanel {

    private JPanel center =null;
    private JLabel date;
    private JPanel contactHandler = new JPanel(new GridLayout(1,3,10,0));
    private ImagePane profile;
    private JLabel nameAndGroup;
    private JLabel phone;

    private Font font =new Font("Georgia",Font.ROMAN_BASELINE, 20);
    private Color bgColor = new Color(250,227,214);
    private Color fontColor= new Color(17,47,59);
    private Color borderColor= new Color(227,204,189);
    private EmptyBorder emptyBorder = new EmptyBorder(4,2,4,2);
    private ListContact bigContainer;

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

        phone.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() >= 3){
                    String confirm = JOptionPane.showInputDialog(null,"vous voulez changez le numéro ? ");
                    if(!confirm.isEmpty()){
                        phone.setText(confirm);
                        phone.revalidate();
                        phone.repaint();
                        contactService.updateNumber(contact.getId(),confirm);
                    }
                }
            }
        });
    }

    public void initNameAndGroup(){
        String labelNameAndGroup=contact.getName()+" ("+contact.getGroup()+")";
        nameAndGroup=new JLabel(labelNameAndGroup);
        nameAndGroup.setFont(font);
        nameAndGroup.setHorizontalAlignment(SwingConstants.CENTER);
        nameAndGroup.setForeground(fontColor);
        nameAndGroup.setBorder(BorderFactory.createMatteBorder(0,0,1,0,borderColor));

        nameAndGroup.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() >= 3){
                    String name = JOptionPane.showInputDialog(null,"Vous voulez changer le nom ? ");
                    String prenom = JOptionPane.showInputDialog(null,"Vous voulez changer le prénom ? ");
                    String group = JOptionPane.showInputDialog(null, "Vous voulez changer le groupe ? ");

                    if(prenom!= null && !prenom.isEmpty() && name!=null && !name.isEmpty()){
                        contactService.updateName(contact.getId(),name +" " + prenom);
                        nameAndGroup.setText(name+" "+prenom+" ("+contact.getGroup()+")");
                        try {
                            setCursor(new Cursor(Cursor.WAIT_CURSOR));
                            Thread.sleep(800);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                    if(group != null && !group.isEmpty()){
                        contactService.updateGroup(contact.getId(),group);
                        try {
                            setCursor(new Cursor(Cursor.WAIT_CURSOR));
                            Thread.sleep(800);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        };
                        nameAndGroup.setText(contact.getName()+" ("+group+")");
                    }
                    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    nameAndGroup.revalidate();
                    nameAndGroup.repaint();
                }
            }
        });
    }

    public void initProfile(){
        String labelProfile = contact.getImage();
        if(labelProfile.equals("noSelect")){
            profile = new ImagePane("resources/images/contact.png");
        }else {
            profile = new ImagePane(labelProfile);

        }
        profile.setPreferredSize(new Dimension(70, 60));
        profile.setBackground(bgColor);
        profile.setBorder(BorderFactory.createMatteBorder(0,0,0,1,borderColor));
    }

    public  void initContactHandler(){
        JLabel fav = new JLabel();
        fav.setHorizontalAlignment(0);
        fav.setVerticalAlignment(0);
        if(contact.isFavorite()){
            fav.setIcon(new ImageIcon("resources/images/star.png"));
            fav.repaint();
            fav.revalidate();
        }
        else{
            fav.setIcon(new ImageIcon("resources/images/blackStar.png"));
            fav.repaint();
            fav.revalidate();
        }

        ImagePane delete = new ImagePane("resources/images/suprimer.png");
        delete.setOpaque(false);
        fav.setPreferredSize(new Dimension(20,20));
        delete.setPreferredSize(new Dimension(20,20));

        delete.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                delete.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                int response = JOptionPane.showConfirmDialog(null,"vous voulez vraiment supprimer ce contact ? ");
                if(response==0){
                    bigContainer.deleteRowContact(contact.getId());
                }
            }
        });

        fav.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()>=3){
                   if(contact.isFavorite()){
                       fav.setIcon(new ImageIcon("resources/images/blackStar.png"));
                       fav.revalidate();
                       fav.repaint();
                       contactService.updateFavorite(contact.getId(),false);
                   }else{
                       fav.setIcon(new ImageIcon("resources/images/star.png"));
                       fav.revalidate();
                       fav.repaint();
                       contactService.updateFavorite(contact.getId(),true);
                   }
                }

            }
        });

        contactHandler.add(fav);
        contactHandler.add(delete);
        contactHandler.setBackground(bgColor);
    }

    public  void initThis(){
        setLayout(new GridLayout(1,1));
        setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));
        setBackground(bgColor);
    }

    public void initCenter(){
        center = new JPanel(new BorderLayout());
        center.add(nameAndGroup,BorderLayout.NORTH);
        center.add(phone,BorderLayout.CENTER);
        center.add(contactHandler,BorderLayout.EAST);
        center.add(date,BorderLayout.SOUTH);
        center.setBackground(bgColor);
    }

    public RowContact(ListContact bigContainer,Contact contact){
        this.bigContainer=bigContainer;
        this.contact = contact;

        initDate();
        initPhone();
        initNameAndGroup();
        initProfile();
        initContactHandler();
        initCenter();
        initThis();


        profile.setOpaque(false);
        center.setOpaque(false);
        contactHandler.setOpaque(false);

        JPanel block_pane = new JPanel(new BorderLayout());
        block_pane.add(profile,BorderLayout.WEST);
        block_pane.add(center,BorderLayout.CENTER);
        block_pane.setBorder(emptyBorder);
        block_pane.setBackground(bgColor);
        block_pane.setOpaque(false);

        setBackground(new Color(128, 255, 112));
        add(block_pane);
    }

 }
