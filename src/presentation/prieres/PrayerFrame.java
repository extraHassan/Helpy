package presentation.prieres;

import models.Prayer;
import presentation.components.Designer;
import presentation.components.ImagePane;
import services.PrayerService;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Vector;

public class PrayerFrame extends JFrame {

    private ImagePane block_pane = new ImagePane("resources/images/mosquee.jpg");
    private HashMap<Integer, Prayer> prayerHashMap = new HashMap<>();
    private HashMap<Integer,RowPray> rowPrayHashMap = new HashMap<>();
    private PrayerService prayerService=new PrayerService();
    private Designer designer = new Designer();

    public void initPrayers(){
        Vector<Prayer> prayers = prayerService.findAll();
        for(Prayer prayer:prayers){
            this.prayerHashMap.put(prayer.getId(),prayer);
        }
        System.out.println("prayers size ===> "+this.prayerHashMap.size());
    }

    public void initRowsPrayer(){
        initPrayers();
        for(Integer prayerKey:prayerHashMap.keySet()){
            rowPrayHashMap.put(prayerKey,new RowPray(prayerHashMap.get(prayerKey)));
        }
        System.out.println("rowPrayers size ===> "+this.rowPrayHashMap.size());
    }

    public void initBlockPane(){
        JPanel rowsContainer = new JPanel(new GridLayout(5,1));
        rowsContainer.setBorder(designer.getPrayerTimesMargin());
        rowsContainer.setOpaque(false);
        initRowsPrayer();
        for(Integer rowPaneKey:rowPrayHashMap.keySet()){
            rowsContainer.add(rowPrayHashMap.get(rowPaneKey));
        }
        System.out.println("blockPanes size ===> "+rowsContainer.getComponents().length);
        ImagePane aya=new ImagePane("resources/images/aya.png");
        aya.setPreferredSize(new Dimension(80,160));
        aya.setOpaque(false);
        block_pane.setLayout(new BorderLayout());
        block_pane.add(rowsContainer,BorderLayout.EAST);
        block_pane.add(aya,BorderLayout.SOUTH);

    }

    public void initFrame(){
            setTitle("Prayers");
            setBackground(designer.getBgColor());
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pack();
            setVisible(true);
    }

    public PrayerFrame(){
        initBlockPane();
        setContentPane(block_pane);
        initFrame();
    }

    public static void main(String[] args) {
        new PrayerFrame();
    }




}
