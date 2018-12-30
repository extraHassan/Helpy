package services;

import models.Medicament;

import java.util.Vector;

public class MedicamentService {
    private Vector<Medicament> medicaments = new Vector<>();

    public MedicamentService(){
        for (int i=0;i<2;i++){
            Medicament medicament = new Medicament();
            medicament.setId(i);
            medicament.setName("extraHassan");
            medicaments.add(medicament);
        }
    }

    public Vector<Medicament> listContacts(){
        return medicaments;
    }

    public void deleteMedicament(int id){
        medicaments.remove(id);
    }
}
