package models;

import java.sql.Time;

public class Priere {
	private String name; 
	private Time time; 
	private String notificationMessage;
	
	public Priere() {
		notificationMessage=toString();
	}

	public Priere(String name, Time hour, String notificationMessage) {
		super();
		this.name = name;
		this.time = hour;
		this.notificationMessage = notificationMessage;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Time getHour() {
		return time;
	}
	
	public void setHour(Time hour) {
		this.time = hour;
	}
	
	public String getNotificationMessage() {
		return notificationMessage;
	}
	
	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	} 
}
