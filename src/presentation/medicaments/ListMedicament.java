package presentation.medicaments;

import models.Medicament;
import presentation.components.Designer;
import presentation.components.ImagePane;
import services.MedicamentService;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Vector;

public class ListMedicament extends JPanel {
    private MedicamentService medicamentService = new MedicamentService();
    private HashMap<Integer,Medicament> medicaments;
    private Vector<RowMedicament> medicamentPanes = new Vector<>();
    private Designer designer = new Designer();
    private JPanel block_page = new JPanel();
    public ListMedicament(){
        buildListMedicament();
    }

    public void buildListMedicament(){
        convertMedicamentsToMedicamentsPane();
        setLayout(new BorderLayout());
        block_page=new JPanel();
        block_page.setLayout(new GridLayout(medicamentPanes.size(),1,4,4));
        for (RowMedicament mp : medicamentPanes){
            mp.setBorder(designer.getBlackBottomMatteBorder());

            JPanel pane = new JPanel(new BorderLayout());
            pane.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
            pane.setOpaque(false);
            pane.add(mp,BorderLayout.CENTER);
            block_page.add(pane);
        }
        block_page.setOpaque(false);
        add(block_page, BorderLayout.CENTER);
        setOpaque(false);
    }

    public void deleteRowMedicament(int id){
        medicamentService.deleteMedicament(id);
        block_page.removeAll();
        removeAll();
        block_page.revalidate();
        block_page.repaint();
        revalidate();
        repaint();
        buildListMedicament();
    }

    public void convertMedicamentsToMedicamentsPane(){
        medicaments = medicamentService.getMedicaments();
        medicamentPanes.clear();
        for (Integer key: medicaments.keySet()){
            Medicament med = medicaments.get(key);
            medicamentPanes.add(new RowMedicament(this,med));
        }
    }
}
