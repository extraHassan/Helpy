package presentation.medicaments;

import services.MedicamentService;

import javax.swing.*;
import java.awt.*;

public class MedicamentPane extends JFrame {

    private JTabbedPane jTabbedPane = new JTabbedPane();
    private ListMedicament listPane;
    private JPanel block_pane = new JPanel(new BorderLayout());
    private MedicamentService medicamentService = new MedicamentService();

    public MedicamentPane() {
        listPane = new ListMedicament("resources/images/coeur.png");
        initBlockPane();
        setTitle("Contacts");
        setContentPane(block_pane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public  void initBlockPane(){
        JPanel listPaneContainer = new JPanel(new BorderLayout());
        listPaneContainer.add(listPane,BorderLayout.CENTER);
        JScrollPane jScrollPane = new JScrollPane(listPaneContainer);
        jTabbedPane.add("Medicaments",jScrollPane);
        block_pane.add(jTabbedPane,BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        new MedicamentPane();
    }

}
