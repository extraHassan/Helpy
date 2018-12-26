package presentation.contacts;

import presentation.components.ImagePane;

import javax.swing.*;
import java.awt.*;

public class RowContact extends JPanel {

    private  JPanel center =null;
    private JLabel date = new JLabel("added le 15/12/2018 at 12:45 pm");
    private JPanel contactHandler = new JPanel(new GridLayout(1,3,10,0));
    private ImagePane profile = new ImagePane("resources/images/contact.png");
    private JLabel nameAndGroup = new JLabel("unknown (group)");
    private JLabel phone = new JLabel("no number exist!");
    private Font font =new Font("Georgia",Font.ROMAN_BASELINE, 20);
    private Color bgColor = new Color(250,227,214);
    private Color fontColor= new Color(17,47,59);
    private Color borderColor= new Color(227,204,189);

    public void initDate(){
        date.setFont(font);
        date.setHorizontalAlignment(SwingConstants.CENTER);
        date.setForeground(fontColor);
        date.setBackground(bgColor);
    }

    public void initPhone(){
        phone.setFont(font);
        phone.setHorizontalAlignment(SwingConstants.CENTER);
        phone.setForeground(fontColor);
        phone.setBackground(bgColor);
    }

    public void initNameAndGroup(){
        nameAndGroup.setFont(font);
        nameAndGroup.setHorizontalAlignment(SwingConstants.CENTER);
        nameAndGroup.setForeground(fontColor);
        nameAndGroup.setBorder(BorderFactory.createMatteBorder(0,0,1,0,borderColor));
    }

    public void initProfile(){
        profile.setPreferredSize(new Dimension(70, 60));
        profile.setBackground(bgColor);
        profile.setBorder(BorderFactory.createMatteBorder(0,0,0,1,borderColor));
    }

    public  void initContactHandler(){
        ImagePane fav = new ImagePane("resources/images/star.png");
        ImagePane update = new ImagePane("resources/images/update.png");
        ImagePane delete = new ImagePane("resources/images/suprimer.png");
        fav.setPreferredSize(new Dimension(20,20));
        update.setPreferredSize(new Dimension(20,20));
        delete.setPreferredSize(new Dimension(20,20));
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

    public RowContact(){
        initDate();
        initPhone();
        initNameAndGroup();
        initProfile();
        initContactHandler();
        initCenter();
        initThis();



        add(profile,BorderLayout.WEST);
        add(center,BorderLayout.CENTER);
    }
 }
