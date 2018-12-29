package presentation.medicaments;

import presentation.components.ImagePane;
import javax.swing.*;
import java.awt.*;

public class MedicamentPane extends JFrame {

    private ListMedicament listPane = new ListMedicament();;
    private ImagePane block_pane ;

    public MedicamentPane() {
        initBlockPane();
        setTitle("Contacts");
        setContentPane(block_pane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public  void initBlockPane(){
        JScrollPane jScrollPane = new JScrollPane(listPane);
        jScrollPane.setOpaque(false);
        jScrollPane.getViewport().setOpaque(false);

        block_pane = new ImagePane("resources/images/coeur.png");
        block_pane.setLayout(new BorderLayout());
        block_pane.add(jScrollPane,BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        new MedicamentPane();
    }

}
