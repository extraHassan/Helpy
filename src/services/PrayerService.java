package services;

import models.Prayer;

import java.sql.Time;
import java.util.Vector;

public class PrayerService {

    public Vector<Prayer> findAll(){
        Vector<Prayer> prayers = new Vector<>();
        prayers.add(new Prayer(1,"FAJR","Ø§Ù„ØµØ¨Ø­(Ø§Ù„Ù�Ø¬Ø±)",new Time(05,30,33),"it " +
                "is show time for " +
                "FAJR"));
        prayers.add(new Prayer(2,"DOHR","Ø§Ù„Ø¸Ù‡Ø±",new Time(12,15,33),"it " +
                "is show time for " +
                "DOHR"));
        prayers.add(new Prayer(3,"ASR","Ø§Ù„Ø¹ØµØ±",new Time(16,00,33),"it " +
                "is show time for " +
                "ASR"));
        prayers.add(new Prayer(4,"MAGHRIB","Ø§Ù„Ù…ØºØ±Ø¨",new Time(17,30,33),"it " +
                "is show time for " +
                "MAGHRIB"));
        prayers.add(new Prayer(5,"ICHAA","Ø§Ù„Ø¹Ø´Ø§Ø¡",new Time(20,30,33),"it " +
                "is show time for " +
                "ICHAA"));
        return prayers;
    }
}
