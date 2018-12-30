package presentation.medicaments;

import models.Medicament;
import presentation.components.Designer;
import services.MedicamentService;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
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
        if(medicamentPanes.size()!=0){
            for (RowMedicament mp : medicamentPanes){
                mp.setBorder(designer.getBlackBottomMatteBorder());
                JPanel pane = new JPanel(new BorderLayout());
                pane.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
                pane.setOpaque(false);
                pane.add(mp,BorderLayout.CENTER);
                block_page.add(pane);
            }
        }else {
            JLabel emptydatabase = new JLabel();
            emptydatabase.setIcon(new ImageIcon("resources/images/database.png"));
            emptydatabase.setHorizontalAlignment(0);
            emptydatabase.setVerticalAlignment(0);
            block_page.add(emptydatabase);
        }

        block_page.setOpaque(false);
        add(block_page, BorderLayout.CENTER);
        setOpaque(false);
    }

    public void deleteRowMedicament(int id){
        medicamentService.delete(id);
        block_page.removeAll();
        removeAll();
        block_page.revalidate();
        block_page.repaint();
        revalidate();
        repaint();
        buildListMedicament();
    }

    public void convertMedicamentsToMedicamentsPane(){
        List<Medicament> meds = medicamentService.findAll();
        for (Medicament m:meds){
            medicaments.put(m.getId(),m);
        }
        medicamentPanes.clear();

        for (Integer key: medicaments.keySet()){
            Medicament med = medicaments.get(key);
            medicamentPanes.add(new RowMedicament(this,med));
        }
    }
}
