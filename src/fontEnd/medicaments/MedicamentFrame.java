package fontEnd.medicaments;

import fontEnd.utils.components.Designer;
import fontEnd.utils.components.ImagePane;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MedicamentFrame extends JFrame {

    private ListMedicament listPane;
    private ImagePane block_pane ;
    private Designer designer;
    private AddMedicamentFrame addMedicamentFrame;

    private static int lock =0;
    private static MedicamentFrame medicamentFrame;

    private MedicamentFrame() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                lock=0;
            }
        });
        initBlockPane();
        setTitle("Médicaments");
        setContentPane(block_pane);
        pack();
        setVisible(true);
    }

    public  void initBlockPane(){
        designer = new Designer();
        listPane  = new ListMedicament();

        JScrollPane jScrollPane = new JScrollPane(listPane);
        jScrollPane.setOpaque(false);
        jScrollPane.getViewport().setOpaque(false);

        JLabel labelAdd = new JLabel("Ajouter un nouveau médicament");
        labelAdd.setHorizontalAlignment(0);
        labelAdd.setForeground(designer.getFontColor());
        labelAdd.setFont(designer.getFont());

        JPanel addNewMed = new JPanel(new FlowLayout(FlowLayout.CENTER));
        addNewMed.setBackground(designer.getOpacityBgColor());
        addNewMed.add(labelAdd);
        addNewMed.setBorder(BorderFactory.createMatteBorder(0,0,4,0,designer.getLightGreen()));

        addNewMed.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                addNewMed.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                addNewMed.setCursor(new Cursor(Cursor.WAIT_CURSOR));
                if(AddMedicamentFrame.getLock()==0){
                    addMedicamentFrame=AddMedicamentFrame.getInstance();
                    addMedicamentFrame.setListWhereWeAdd(listPane);
                    addNewMed.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }else {
                    JOptionPane.showMessageDialog(null,"Déjà ouvert !");
                }

            }
        });

        block_pane = new ImagePane("resources/images/coeur.png");
        block_pane.setLayout(new BorderLayout());
        block_pane.add(addNewMed,BorderLayout.NORTH);
        block_pane.add(jScrollPane,BorderLayout.CENTER);
        block_pane.setOpaque(false);
    }

    public static MedicamentFrame getInstance() {
        if (lock==0){
            medicamentFrame= new MedicamentFrame();
            lock=1;
        }
        return medicamentFrame;
    }

    public static int getLock() {
        return lock;
    }

}
