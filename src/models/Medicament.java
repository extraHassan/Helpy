package models;

import java.sql.Date;
import java.sql.Time;

public class Medicament {
	
	private String name; 
	private Date end; 
	private String when;
	private Time time;
	private String price; 
	private String useCase; 
	private String notificationMessage; 
	
	public Medicament() {
		notificationMessage=toString(); 
	}
	
	public Medicament(String name, Date end, String when) {
		this.name = name;
		this.end = end;
		this.when = when;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getNotificationMessage() {
		return notificationMessage;
	}

	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}

	public String getUseCase() {
		return useCase;
	}

	public void setUseCase(String useCase) {
		this.useCase = useCase;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getEnd() {
		return end;
	}
	
	public void setEnd(Date end) {
		this.end = end;
	}
	
	public String getWhen() {
		return when;
	}
	
	public void setWhen(String when) {
		this.when = when;
	} 
}
