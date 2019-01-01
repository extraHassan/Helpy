package presentation.prieres;

import models.Prayer;
import presentation.components.Designer;
import presentation.components.ImagePane;
import services.PrayerService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.List;

public class PrayerFrame extends JFrame  {

    private JPanel block_pane = new JPanel();
    private HashMap<Integer, Prayer> prayerHashMap = new HashMap<>();
    private HashMap<Integer,RowPray> rowPrayHashMap = new HashMap<>();
    private PrayerService prayerService=new PrayerService();
    private Designer designer = new Designer();

    private static int lock =0;
    private static PrayerFrame prayerFrame;

    public void initPrayers(){
        List<Prayer> prayers = prayerService.findAll();
        for(Prayer prayer : prayers){
            prayerHashMap.put(prayer.getId(),prayer);
        }
    }

    public void initRowsPrayer(){
        initPrayers();
        for(Integer prayerKey:prayerHashMap.keySet()){
            rowPrayHashMap.put(prayerKey,new RowPray(prayerHashMap.get(prayerKey)));
        }
    }

    public void initBlockPane(){
        JPanel rowsContainer = new JPanel(new GridLayout(5,1,1,6));
        rowsContainer.setOpaque(false);
        initRowsPrayer();

        for(Integer rowPaneKey:rowPrayHashMap.keySet()){
            rowsContainer.add(rowPrayHashMap.get(rowPaneKey));
        }
        block_pane.setLayout(new BorderLayout());
        block_pane.setOpaque(false);
        block_pane.add(rowsContainer,BorderLayout.CENTER);
        block_pane.setBorder(BorderFactory.createEmptyBorder(120,2,40,60));
    }

    public void initFrame(){
            setTitle("Prayers");
            setBackground(designer.getBgColor());
            pack();
            setVisible(true);
    }

    private PrayerFrame(){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                lock=0;
            }
        });
        initBlockPane();

        ImagePane block_pane_Container=new ImagePane("resources/images/masjid.png");
        block_pane_Container.setLayout(new BorderLayout());
        block_pane_Container.setPreferredSize(new Dimension(400,600));
        block_pane_Container.add(block_pane,BorderLayout.CENTER);

        setContentPane(block_pane_Container);
        initFrame();
    }



    public  static PrayerFrame getInstance() {
        if (lock==0){
            prayerFrame = new PrayerFrame();
            lock=1;
        }
        return prayerFrame;
    }

    public static int getLock() {
        return lock;
    }
}
