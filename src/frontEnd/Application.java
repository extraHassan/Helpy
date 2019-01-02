package frontEnd;

import frontEnd.agenda.SwingFrame;
import frontEnd.mailing.MailFrame;
import frontEnd.utils.components.Designer;
import frontEnd.utils.components.ImagePane;
import frontEnd.contacts.ContactFrame;
import frontEnd.medicaments.MedicamentFrame;
import frontEnd.prieres.PrayerFrame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Application extends JFrame {
    private Designer designer = new Designer();
    private JPanel block_page = new JPanel();
    private ImagePane blockPageContainer = new ImagePane("resources/images/bgApplication.png");
    private JPanel prayer = new JPanel(new BorderLayout());
    private JPanel contact = new JPanel(new BorderLayout());
    private JPanel medicament = new JPanel(new BorderLayout());
    private JPanel agenda = new JPanel(new BorderLayout());
    private JLabel mail = new JLabel(designer.resizeImage("resources/images/email.png",70,70));

    private JPanel mailContainer = new JPanel(new BorderLayout());
    private JPanel prayerContainer = new JPanel(new BorderLayout());
    private JPanel contactContainer = new JPanel(new BorderLayout());
    private JPanel medicamentContainer = new JPanel(new BorderLayout());
    private JPanel agendaContainer = new JPanel(new BorderLayout());

    private  LineBorder lineBorder = new LineBorder(designer.getBgColor(),5,true);

    private JPanel mailMenu;

    public Application(){
        System.out.println("BIENVENUE CHEZ HELPY APPLICATION ***ENSA TETOUAN***");
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
            click.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
        else if (frameIndex==1){
            if (ContactFrame.getLock()==1)
                flag=true;
            ContactFrame.getInstance();
            click.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
        else if(frameIndex==2){
            if (MailFrame.getLock()==1)
                flag=true;
            MailFrame.getInstance();
            click.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
        else if(frameIndex==3){
            if (SwingFrame.getLock()==1)
                flag=true;
            SwingFrame.getInstance();
            click.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
        else{
            if (MedicamentFrame.getLock()==1)
                flag=true;
            MedicamentFrame.getInstance();
            click.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }

        if(flag==true){
            JOptionPane.showMessageDialog(null,"Le panneau est déjà ouvert ! ");
        }
    }

	public void initFramesActions(){
        prayerContainer.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                prayerContainer.setCursor(new Cursor(Cursor.HAND_CURSOR));
                prayerContainer.setBorder(new LineBorder(Color.red,5,true));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                prayerContainer.setBorder(new LineBorder(designer.getBgColor(),5,true));
            }

            public void mouseClicked(MouseEvent e) {
                openFrame(prayer,0);
            }
        });

        contact.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                contactContainer.setCursor(new Cursor(Cursor.HAND_CURSOR));
                contactContainer.setBorder(new LineBorder(Color.red,5,true));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                contactContainer.setBorder(new LineBorder(designer.getBgColor(),5,true));
            }

            public void mouseClicked(MouseEvent e) {
                openFrame(contact,1);
            }
        });

        medicament.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                medicamentContainer.setCursor(new Cursor(Cursor.HAND_CURSOR));
                medicamentContainer.setBorder(new LineBorder(Color.red,5,true));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                medicamentContainer.setBorder(new LineBorder(designer.getBgColor(),5,true));
            }

            public void mouseClicked(MouseEvent e) {
                openFrame(medicament,4);
            }
        });

        agenda.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                agendaContainer.setCursor(new Cursor(Cursor.HAND_CURSOR));
                agendaContainer.setBorder(new LineBorder(Color.red,5,true));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                agendaContainer.setBorder(new LineBorder(designer.getBgColor(),5,true));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                openFrame(agenda,3);
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

        prayer.add(new JLabel(designer.resizeImage("resources/images/mosque.png",120,120)));
	    contact.add(new JLabel(designer.resizeImage("resources/images/phone-book.png",120,120)));
	    medicament.add(new JLabel(designer.resizeImage("resources/images/medicine.png",120,120)));
	    agenda.add(new JLabel(designer.resizeImage("resources/images/calendar.png",120,120)));

	    prayer.setBackground(new Color(0, 255, 135,230));
        contact.setBackground(new Color(0, 255, 135,230));
        medicament.setBackground(new Color(0, 255, 135,230));
        agenda.setBackground(new Color(0, 255, 135,230));

        prayerContainer.add(prayer);
        prayerContainer.setOpaque(false);
        contactContainer.add(contact);
        contactContainer.setOpaque(false);
        medicamentContainer.add(medicament);
        medicamentContainer.setOpaque(false);
        agendaContainer.add(agenda);
        agendaContainer.setOpaque(false);

        prayerContainer.setBorder(lineBorder);
        contactContainer.setBorder(lineBorder);
        medicamentContainer.setBorder(lineBorder);
        agendaContainer.setBorder(lineBorder);


        block_page.setLayout(new BorderLayout());

	    JPanel center = new JPanel();
        center.setLayout(new GridLayout(2,2,40,40));
        center.add(prayerContainer);
        center.add(medicamentContainer);
        center.add(contactContainer);
        center.add(agendaContainer);
        center.setOpaque(false);
        center.setPreferredSize(new Dimension(500,500));
        center.setBorder(BorderFactory.createEmptyBorder(30,15,30,15));


        mail.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
        mailContainer.add(mail);
        mailContainer.setBackground(new Color(0, 255, 135,230));

        mailMenu = new JPanel(new BorderLayout());
        mailMenu.add(mailContainer);
        mailMenu.setBorder(BorderFactory.createMatteBorder(5,0,0,0,designer.getBgColor()));
        mailMenu.setOpaque(false);

        JLabel logApp = new JLabel(designer.resizeImage("resources/images/lasthelpy.png",100,100));
        logApp.setOpaque(false);
        logApp.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        block_page.add(logApp,BorderLayout.NORTH);
        block_page.add(center,BorderLayout.CENTER);
        block_page.add(mailMenu,BorderLayout.SOUTH);
        block_page.setOpaque(false);

        setPreferredSize(new Dimension(400,800));
    }

    public static void main(String[] args) {
        new Application();
    }

}
