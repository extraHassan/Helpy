package services;

import models.Medicament;

import java.util.Vector;

public class MedicamentService {
    public Vector<Medicament> listContacts(){
        Vector<Medicament> medicaments = new Vector<>();

        for (int i=0;i<10;i++){
            Medicament medicament = new Medicament();
            medicament.setName("doliprine");
            medicaments.add(medicament);
        }
        return medicaments;
    }
}
