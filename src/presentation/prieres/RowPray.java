package presentation.prieres;

import javafx.scene.control.TextInputDialog;
import jdk.nashorn.internal.scripts.JO;
import models.Prayer;
import presentation.components.Designer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.sql.Time;

public class RowPray extends  JPanel  {

    private JLabel frenchName;
    private JLabel arabicName;
    private JLabel time;
    private Designer designer = new Designer();
    private Prayer prayer;
    private JPanel itemsContainer ;


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
        frenchName = new JLabel(prayer.getFrenchName());
        arabicName = new JLabel(prayer.getArabicName());
        time = new JLabel(prayer.getTime().toString());
        arabicName.setFont(designer.getFont());
        arabicName.setForeground(new Color(255, 102, 196));
        frenchName.setFont(designer.getFont());
        frenchName.setForeground(new Color(255, 102, 196));
        time.setFont(designer.getFont());
        time.setForeground(new Color(255, 102, 196));
        setTimeAction();
    }


    public void setTimeAction(){

        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                    String newTime = JOptionPane.showInputDialog(null,"vous voulez changer l'heure ? ",prayer.getFrenchName(),1);
                    if(newTime!=null && !newTime.isEmpty()){
                        //here the service must change the date
                        prayer.setHour(new Time(15,12,3));
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
