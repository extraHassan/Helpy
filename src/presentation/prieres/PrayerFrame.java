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

    private JPanel block_pane = new JPanel();
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
        JPanel rowsContainer = new JPanel(new GridLayout(5,1,1,6));
        rowsContainer.setOpaque(false);
        initRowsPrayer();
        for(Integer rowPaneKey:rowPrayHashMap.keySet()){
            rowsContainer.add(rowPrayHashMap.get(rowPaneKey));
        }
        System.out.println("blockPanes size ===> "+rowsContainer.getComponents().length);

        block_pane.setLayout(new BorderLayout());
        block_pane.setOpaque(false);
        block_pane.add(rowsContainer,BorderLayout.CENTER);
        block_pane.setBorder(BorderFactory.createEmptyBorder(120,2,40,60));
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

        ImagePane block_pane_Container=new ImagePane("resources/images/masjid.png");
        block_pane_Container.setLayout(new BorderLayout());
        block_pane_Container.setPreferredSize(new Dimension(400,600));

        block_pane_Container.add(block_pane,BorderLayout.CENTER);


        setContentPane(block_pane_Container);
        initFrame();
    }

    public static void main(String[] args) {
        new PrayerFrame();
    }




}
