package presentation.medicaments;

import models.Medicament;
import presentation.components.Designer;

import javax.swing.*;

public class MedicamentPane {
    private Medicament medicament;
    private JLabel name;
    private Designer designer = new Designer();

    public MedicamentPane(Medicament medicament){
        this.medicament = medicament;
        buildPane();
    }

    public void initAll(){
        name.setText(medicament.getName());
        name.setHorizontalAlignment(0);
        name.setFont(designer.getFont());
        name.setForeground(designer.getFontColor());


    }

    public void buildPane(){

    }

}
