package models;

import java.sql.Date;
import java.sql.Time;

public class Medicament {
	private Long id;
	private String name;
	private Date end;
	private String when;
	private Time time;
	private String useCase;
	private Double price;
	private String notificationMessage;

	public Medicament() {
		notificationMessage = toString();
	}

	public Medicament(Long id, String name, Date end, String when, Time time, String useCase, Double price,
			String notificationMessage) {
		super();
		this.id = id;
		this.name = name;
		this.end = end;
		this.when = when;
		this.time = time;
		this.useCase = useCase;
		this.price = price;
		this.notificationMessage = notificationMessage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getUseCase() {
		return useCase;
	}

	public void setUseCase(String useCase) {
		this.useCase = useCase;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getNotificationMessage() {
		return notificationMessage;
	}

	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}


}
