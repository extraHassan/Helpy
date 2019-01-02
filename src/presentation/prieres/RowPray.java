package presentation.prieres;

import models.Prayer;
import presentation.components.Designer;
import services.PrayerService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;

public class RowPray extends  JPanel  {

    private JLabel frenchName;
    private JLabel arabicName;
    private JLabel time;
    private Designer designer = new Designer();
    private Prayer prayer;
    private JPanel itemsContainer ;
    PrayerService prayerService = new PrayerService();

    public RowPray(Prayer prayer) {
        this.prayer = prayer;
        setOpaque(false);
        setActions(this);
        buildPane();
    }

    public void buildPane() {
        initLabels();
        itemsContainer=new JPanel();
        itemsContainer.setBackground(designer.getLightGreen());
        itemsContainer.setOpaque(false);
        itemsContainer.setLayout(new GridLayout(1, 3));
        itemsContainer.add(frenchName);
        itemsContainer.add(time);
        itemsContainer.add(arabicName);
        setBorder(BorderFactory.createMatteBorder(0,0,2,0,designer.getLightGreen()));
        setLayout(new BorderLayout());
        add(itemsContainer, BorderLayout.CENTER);
    }

    public void initLabels() {
        if (prayer.getFrenchName().equals("Fajr")){
            frenchName = new JLabel("Fajr");
            frenchName.setFont(new Font("Dubai",Font.BOLD,25));
            frenchName.setForeground(new Color(255, 102, 196));
            frenchName.setVerticalAlignment(0);
            frenchName.setHorizontalAlignment(0);
            arabicName = new JLabel(designer.resizeImage("resources/images/fajrArabic .png",50,50));
        }
        else if(prayer.getFrenchName().equals("Dohr")){
            frenchName = new JLabel("Dohr");
            frenchName.setFont(new Font("Dubai",Font.BOLD,25));
            frenchName.setForeground(new Color(255, 102, 196));
            frenchName.setVerticalAlignment(0);
            frenchName.setHorizontalAlignment(0);
            arabicName = new JLabel(designer.resizeImage("resources/images/dohrArabic.png",50,50));
        }
        else if(prayer.getFrenchName().equals("Asr")){
            frenchName = new JLabel("Asr");
            frenchName.setFont(new Font("Dubai",Font.BOLD,25));
            frenchName.setForeground(new Color(255, 102, 196));
            frenchName.setVerticalAlignment(0);
            frenchName.setHorizontalAlignment(0);
            arabicName = new JLabel(designer.resizeImage("resources/images/asr.png",50,50));
        }
        else if(prayer.getFrenchName().equals("Maghrib")){
            frenchName = new JLabel("Maghrib");
            frenchName.setFont(new Font("Dubai",Font.BOLD,25));
            frenchName.setForeground(new Color(255, 102, 196));
            frenchName.setVerticalAlignment(0);
            frenchName.setHorizontalAlignment(0);
            arabicName = new JLabel(designer.resizeImage("resources/images/maghrib.png",50,50));
        }
        else {
            frenchName = new JLabel("Ichaa");
            frenchName.setFont(new Font("Dubai",Font.BOLD,25));
            frenchName.setForeground(new Color(255, 102, 196));
            frenchName.setVerticalAlignment(0);
            frenchName.setHorizontalAlignment(0);
            arabicName = new JLabel(designer.resizeImage("resources/images/ichaaAr.png",50,50));
        }


        time = new JLabel(prayer.getTime().toString());
        time.setHorizontalAlignment(0);
        time.setVerticalAlignment(0);
        time.setFont(designer.getFont());
        time.setForeground(new Color(255, 102, 196));
        setTimeAction();
    }


    public void setTimeAction(){

        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()>=4){
                    String newTime = JOptionPane.showInputDialog(null,"vous voulez changer l'heure ? ",prayer.getFrenchName(),1);
                    if(newTime!=null && !newTime.isEmpty()){
                        prayer.setTime(LocalTime.parse(newTime));
                        prayerService.updateTime(prayer.getId(),newTime);
                        time.setText(prayer.getTime().toString());
                    }
                    super.mouseClicked(e);
                }

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                time.setCursor(new Cursor(Cursor.HAND_CURSOR));
                setOpaque(true);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setOpaque(false);
                repaint();
            }
        };
        time.addMouseListener(mouseAdapter);

    }

    public void setActions(JPanel pane) {
        pane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                pane.setOpaque(true);
                pane.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                pane.setOpaque(false);
                pane.repaint();
            }
        });
    }
}
