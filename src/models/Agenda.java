package models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Agenda {
	private Integer id;
	private String event;
	private String description;
	private String notificationMessage;
	private LocalDate date;
	private LocalTime time;

	public Agenda() {
		notificationMessage = toString();
	}

	public Agenda(Integer id, String event, String description, String notificationMessage, LocalDate date, LocalTime time) {
		super();
		this.id = id;
		this.event = event;
		this.description = description;
		this.notificationMessage = notificationMessage;
		this.date = date;
		this.time = time;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String toString() {
		return super.toString();
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNotificationMessage() {
		return notificationMessage;
	}

	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

}
