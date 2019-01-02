package services;

import java.time.LocalTime;

import javax.swing.JDialog;


import models.Prayer;

public class NotificatorService {
	
	private PrayerService ps;

	public NotificatorService() {
		ps = new PrayerService();
	}
	
	public void notifyPrayer(Prayer p) {
		
	
		if(p.getTime().compareTo(LocalTime.now())== 0) {
			JDialog j = new JDialog();
				
			j.setTitle(p.getFrenchName());	
			j.setVisible(true);
		}
		
		else System.out.println("mazaal");
	}

}
