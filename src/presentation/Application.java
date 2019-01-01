package presentation;

import jdk.nashorn.internal.scripts.JO;
import presentation.components.Designer;
import presentation.components.ImagePane;
import presentation.contacts.ContactFrame;
import presentation.mailing.MailFrame;
import presentation.medicaments.MedicamentFrame;
import presentation.prieres.PrayerFrame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Application extends JFrame {

    private JPanel block_page = new JPanel();
    private ImagePane blockPageContainer = new ImagePane("resources/images/bgApplication.png");
    private JPanel prayer = new JPanel(new BorderLayout());
    private JPanel contact = new JPanel(new BorderLayout());
    private JPanel medicament = new JPanel(new BorderLayout());
    private JPanel agenda = new JPanel(new BorderLayout());
    private JLabel mail = new JLabel(resizeImage("resources/images/email.png",70,70));
    private Designer designer = new Designer();
    private JPanel mailContainer = new JPanel(new BorderLayout());
    private  LineBorder lineBorder ;
    private JPanel mailMenu;

    public Application(){
	    initBlockPage();
        initFramesActions();
	    blockPageContainer.setLayout(new GridLayout(1,1));
	    blockPageContainer.add(block_page);
	    blockPageContainer.setBackground(Color.red);

	    setContentPane(blockPageContainer);
        setTitle("ENSA - Helpy");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(430,700));
        pack();
        setVisible(true);
	}

	public void openFrame(JPanel click,int frameIndex){
        boolean flag= false;
        click.setCursor(new Cursor(Cursor.WAIT_CURSOR));

        if(frameIndex==0){
            if (PrayerFrame.getLock()==1)
                flag=true;
            PrayerFrame.getInstance();
        }
        else if (frameIndex==1){
            if (ContactFrame.getLock()==1)
                flag=true;
            ContactFrame.getInstance();
        }
        else if(frameIndex==2){
            if (MailFrame.getLock()==1)
                flag=true;
            MailFrame.getInstance();
        }
        else{
            if (MedicamentFrame.getLock()==1)
                flag=true;
            MedicamentFrame.getInstance();
        }

        if(flag==true){
            click.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            JOptionPane.showMessageDialog(null,"Le panneau est déjà ouvert ! ");
        }
    }

	public void initFramesActions(){
        prayer.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                prayer.setCursor(new Cursor(Cursor.HAND_CURSOR));
                prayer.setBorder(new LineBorder(Color.red,5,true));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                prayer.setBorder(new LineBorder(designer.getBgColor(),5,true));
            }

            public void mouseClicked(MouseEvent e) {
                openFrame(prayer,0);
            }
        });

        contact.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                contact.setCursor(new Cursor(Cursor.HAND_CURSOR));
                contact.setBorder(new LineBorder(Color.red,5,true));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                contact.setBorder(new LineBorder(designer.getBgColor(),5,true));
            }

            public void mouseClicked(MouseEvent e) {
                openFrame(contact,1);
            }
        });

        medicament.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                medicament.setCursor(new Cursor(Cursor.HAND_CURSOR));
                medicament.setBorder(new LineBorder(Color.red,5,true));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                medicament.setBorder(new LineBorder(designer.getBgColor(),5,true));
            }

            public void mouseClicked(MouseEvent e) {
                openFrame(medicament,3);
            }
        });

        agenda.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                agenda.setCursor(new Cursor(Cursor.HAND_CURSOR));
                agenda.setBorder(new LineBorder(Color.red,5,true));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                agenda.setBorder(new LineBorder(designer.getBgColor(),5,true));
            }
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });

        mailContainer.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                mailMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
                mailMenu.setBorder(BorderFactory.createMatteBorder(5,0,0,0,Color.red));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mailMenu.setBorder(BorderFactory.createMatteBorder(5,0,0,0,designer.getBgColor()));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                openFrame(mailContainer,2);
            }
        });
    }

	public void initBlockPage(){

	    prayer.add(new JLabel(resizeImage("resources/images/mosque.png",120,120)));
	    contact.add(new JLabel(resizeImage("resources/images/phone-book.png",120,120)));
	    medicament.add(new JLabel(resizeImage("resources/images/medicine.png",120,120)));
	    agenda.add(new JLabel(resizeImage("resources/images/calendar.png",120,120)));

	    prayer.setBackground(new Color(0, 255, 135,230));
        contact.setBackground(new Color(0, 255, 135,230));
        medicament.setBackground(new Color(0, 255, 135,230));
        agenda.setBackground(new Color(0, 255, 135,230));


        lineBorder = new LineBorder(designer.getBgColor(),5,true);
        prayer.setBorder(lineBorder);
        contact.setBorder(lineBorder);
        medicament.setBorder(lineBorder);
        agenda.setBorder(lineBorder);


        block_page.setLayout(new BorderLayout());

	    JPanel center = new JPanel();
        center.setLayout(new GridLayout(2,2,40,40));
        center.add(prayer);
        center.add(medicament);
        center.add(contact);
        center.add(agenda);
        center.setOpaque(false);
        center.setPreferredSize(new Dimension(500,500));
        setPreferredSize(new Dimension(400,800));
        center.setBorder(BorderFactory.createEmptyBorder(30,15,30,15));


        mail.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
        mailContainer.add(mail);
        mailContainer.setBackground(new Color(0, 255, 135,230));

        mailMenu = new JPanel(new BorderLayout());
        mailMenu.add(mailContainer);
        mailMenu.setBorder(BorderFactory.createMatteBorder(5,0,0,0,designer.getBgColor()));
        mailMenu.setOpaque(false);



        JLabel logApp = new JLabel(resizeImage("resources/images/lasthelpy.png",100,100));
        logApp.setOpaque(false);
        logApp.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        block_page.add(logApp,BorderLayout.NORTH);
        block_page.add(center,BorderLayout.CENTER);
        block_page.add(mailMenu,BorderLayout.SOUTH);
        block_page.setOpaque(false);
    }

    public ImageIcon resizeImage(String path,int width,int height ) {
        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage();
        Image image2 = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(image2);
        return icon2;
    }

    public static void main(String[] args) {
        new Application();
    }

}
