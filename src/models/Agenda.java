package models;

import java.sql.Date;
import java.sql.Time;

public class Agenda {
	private Integer id;
	private String event;
	private String description;
	private String notificationMessage;
	private Date date;
	private Time time;

	public Agenda() {
		notificationMessage = toString();
	}

	public Agenda(Integer id, String event, String description, String notificationMessage, Date date, Time time) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
}
