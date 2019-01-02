package frontEnd.agenda;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;
import frontEnd.utils.components.Designer;
import frontEnd.utils.components.ImagePane;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class SwingFrame extends JFrame {

    DefaultTableModel model;
    Calendar cal = new GregorianCalendar();
    JLabel label;
    private Designer designer = new Designer();

    private static int lock =0;
    private static SwingFrame swingCalendar;

    public static int getLock() {
        return lock;
    }

    public SwingFrame() {
        lock=1;
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                lock=0;
            }
        });
        this.setTitle("Swing Calandar");
        setSize(500,500);
        this.setPreferredSize(new Dimension(500,500));
        this.setLayout(new BorderLayout());
        this.setVisible(true);


        label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Blackadder ITC",Font.CENTER_BASELINE,50));

        JLabel b1 = new JLabel(new ImageIcon("resources/images/left-arrow.png"));
        b1.setOpaque(false);
        b1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseClicked(MouseEvent e) {
                cal.add(Calendar.MONTH, -1);
                updateMonth();
            }
        });

        JLabel b2 = new JLabel(new ImageIcon("resources/images/right-arrow.png"));
        b2.setOpaque(false);
        b2.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseClicked(MouseEvent e) {
                cal.add(Calendar.MONTH, +1);
                updateMonth();
            }
        });


        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(b1,BorderLayout.WEST);
        panel.add(label,BorderLayout.CENTER);
        panel.add(b2,BorderLayout.EAST);
        panel.setBackground(designer.getBgColor());

        String [] columns = {"Dimanche","Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi"};
        model = new DefaultTableModel(null,columns);

        JTable table = new JTable(model);
        table.setLayout(new BorderLayout());
        table.setOpaque(false);
        table.setBackground(designer.getBgColor());

        JScrollPane pane = new JScrollPane(table);
        pane.setOpaque(false);

        ImagePane contentPane = new ImagePane("");
        contentPane.setLayout(new BorderLayout());

        contentPane.add(panel,BorderLayout.NORTH);
        contentPane.add(pane,BorderLayout.CENTER);
        setContentPane(contentPane);
        contentPane.setBackground(designer.getLightGreen());
        contentPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        setSize(new Dimension(500,200));
        setResizable(false);
        updateMonth();
    }

    void updateMonth() {
        cal.set(Calendar.DAY_OF_MONTH, 1);

        String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
        int year = cal.get(Calendar.YEAR);
        label.setText(month + " " + year);

        int startDay = cal.get(Calendar.DAY_OF_WEEK);
        int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);

        model.setRowCount(0);
        model.setRowCount(weeks);
        try{
            int i = startDay-1;
            for(int day=1;day<=numberOfDays;day++){
                model.setValueAt(day, i/7 , i%7 );
                i = i + 1;
            }
        }catch (Exception e){

        }

    }

    public  static SwingFrame getInstance() {
        if (lock==0){
            swingCalendar = new SwingFrame();
            lock=1;
        }
        return swingCalendar;
    }
}