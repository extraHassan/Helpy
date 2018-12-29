package presentation.medicaments;

import models.Medicament;
import presentation.components.Designer;
import presentation.components.ImagePane;
import services.MedicamentService;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class ListMedicament extends ImagePane {
    private Vector<Medicament> medicaments;
    private MedicamentService medicamentService = new MedicamentService();
    private Vector<RowMedicament> medicamentPanes = new Vector<>();
    private Designer designer = new Designer();

    public ListMedicament(String image){
        super(image);
        medicaments = medicamentService.listContacts();
        convertMedicamentsToMedicamentsPane();

        setLayout(new GridLayout(medicamentPanes.size(),1,4,4));
        for (RowMedicament mp : medicamentPanes){

            mp.setBorder(designer.getBlackBottomMatteBorder());
            JPanel pane = new JPanel(new BorderLayout());
            pane.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
            pane.setOpaque(false);
            pane.add(mp,BorderLayout.CENTER);

            add(pane);
        }
    }

    public void convertMedicamentsToMedicamentsPane(){
        for (Medicament med : medicaments){
            medicamentPanes.add(new RowMedicament(med));
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("medicament Pane");
        frame.setContentPane(new ListMedicament("resources/images/mail.jpg"));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
