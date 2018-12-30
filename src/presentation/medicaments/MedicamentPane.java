package presentation.medicaments;

import presentation.components.Designer;
import presentation.components.ImagePane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MedicamentPane extends JFrame {

    private ListMedicament listPane  = new ListMedicament();
    private ImagePane block_pane ;
    private Designer designer = new Designer();

    public MedicamentPane() {
        initBlockPane();
        setTitle("Médicaments");
        setContentPane(block_pane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public  void initBlockPane(){

        JScrollPane jScrollPane = new JScrollPane(listPane);
        jScrollPane.setOpaque(false);
        jScrollPane.getViewport().setOpaque(false);

        JLabel labelAdd = new JLabel("Ajouter un nouveau médicament");
        labelAdd.setHorizontalAlignment(0);
        labelAdd.setForeground(designer.getFontColor());
        labelAdd.setFont(designer.getFont());

        JPanel addMedicamentPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
        addMedicamentPane.setBackground(designer.getOpacityBgColor());
        addMedicamentPane.add(labelAdd);
        addMedicamentPane.setBorder(BorderFactory.createMatteBorder(0,0,4,0,designer.getLightGreen()));

        addMedicamentPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                addMedicamentPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame frame = new AddMedicamentPane();
            }
        });

        block_pane = new ImagePane("resources/images/coeur.png");
        block_pane.setLayout(new BorderLayout());
        block_pane.add(addMedicamentPane,BorderLayout.NORTH);
        block_pane.add(jScrollPane,BorderLayout.CENTER);
        block_pane.setOpaque(false);
    }

    public static void main(String[] args) {
        new MedicamentPane();
    }

}
