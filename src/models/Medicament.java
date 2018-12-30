package models;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Medicament {

	private int id;
	private String name; 
	private LocalDate end;
	private String when;
	private LocalTime time;
	private String price; 
	private String useCase; 
	private String notificationMessage; 
	
	public Medicament() {
		notificationMessage=toString();
	}




	public void setEnd(LocalDate end) {
		this.end = end;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
	public String toString() {
	    String info = "id :" + id + " name : "+name + " date de fin : "+end+ " when : "+ when + " time: "+time
                +" price : "+price + " usecase: "+useCase;
	    return info;
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
	
	public String getWhen() {
		return when;
	}
	
	public void setWhen(String when) {
		this.when = when;
	}


}
