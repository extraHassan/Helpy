package presentation.medicaments;

import models.Medicament;
import presentation.components.Designer;
import services.MedicamentService;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class ListMedicament extends JPanel {
    private MedicamentService medicamentService = new MedicamentService();
    private Vector<Medicament> medicaments;
    private Vector<RowMedicament> medicamentPanes = new Vector<>();
    private Designer designer = new Designer();

    public ListMedicament(){
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

        setOpaque(false);
    }

    public void convertMedicamentsToMedicamentsPane(){
        medicaments = medicamentService.listContacts();
        for (Medicament med : medicaments){
            medicamentPanes.add(new RowMedicament(med));
        }
    }
}
