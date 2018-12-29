package models;

import java.sql.Time;

public class Prayer {

	private Integer id;
	private String frenchName;
	private String arabicName;
	private Time time;
	private String notificationMessage;

	public Prayer() {
		notificationMessage = toString();
	}

	public Prayer(Integer id, String frenchName, String arabicName, Time time, String notificationMessage) {
		this.id = id;
		this.frenchName = frenchName;
		this.arabicName = arabicName;
		this.time = time;
		this.notificationMessage = notificationMessage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArabicName() {
		return arabicName;
	}

	public void setArabicName(String arabicName) {
		this.arabicName = arabicName;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getFrenchName() {
		return frenchName;
	}

	public void setFrenchName(String frenchName) {
		this.frenchName = frenchName;
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
