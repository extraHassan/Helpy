package presentation.medicaments;

import presentation.components.Designer;
import presentation.components.ImagePane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MedicamentPane extends JFrame {

    private ListMedicament listPane;
    private ImagePane block_pane ;
    private Designer designer;
    private AddMedicamentFrame addMedicamentFrame;

    public MedicamentPane() {
        initBlockPane();
        setTitle("Médicaments");
        setContentPane(block_pane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                addMedicamentFrame.construct();
            }
        });

        block_pane = new ImagePane("resources/images/coeur.png");
        block_pane.setLayout(new BorderLayout());
        block_pane.add(addNewMed,BorderLayout.NORTH);
        block_pane.add(jScrollPane,BorderLayout.CENTER);
        block_pane.setOpaque(false);

        addMedicamentFrame=new AddMedicamentFrame(listPane);
    }

    public static void main(String[] args) {
        new MedicamentPane();
    }

}
