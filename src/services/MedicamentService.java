package services;

import models.Medicament;

import java.util.HashMap;
import java.util.Vector;

public class MedicamentService {
    private HashMap<Integer,Medicament> medicaments = new HashMap<>();

    public MedicamentService(){
        for (int i=0;i<3;i++){
            Medicament medicament = new Medicament();
            medicament.setId(i);
            medicament.setName("extraHassan");
            medicaments.put(medicament.getId(),medicament);
        }
    }

    public void addMedicament(Medicament med){
        medicaments.put(med.getId(),med);
        System.out.println(med.toString());
    }

    public HashMap<Integer, Medicament> getMedicaments() {
        return medicaments;
    }

    public void deleteMedicament(int id){
        medicaments.remove(id);
    }
}
