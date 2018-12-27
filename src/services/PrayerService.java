package services;

import models.Prayer;

import java.sql.Time;
import java.util.Vector;

public class PrayerService {

    public Vector<Prayer> findAll(){
        Vector<Prayer> prayers = new Vector<>();
        prayers.add(new Prayer(1,"FAJR","الصبح(الفجر)",new Time(05,30,33),"it " +
                "is show time for " +
                "FAJR"));
        prayers.add(new Prayer(2,"DOHR","الظهر",new Time(12,15,33),"it " +
                "is show time for " +
                "DOHR"));
        prayers.add(new Prayer(3,"ASR","العصر",new Time(16,00,33),"it " +
                "is show time for " +
                "ASR"));
        prayers.add(new Prayer(4,"MAGHRIB","المغرب",new Time(17,30,33),"it " +
                "is show time for " +
                "MAGHRIB"));
        prayers.add(new Prayer(5,"ICHAA","العشاء",new Time(20,30,33),"it " +
                "is show time for " +
                "ICHAA"));
        return prayers;
    }
}
