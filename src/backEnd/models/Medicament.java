package backEnd.models;


import java.time.LocalDate;
import java.time.LocalTime;

public class Medicament {
	private Integer id;
	private String name;
	private LocalDate end;
	private String when;
	private LocalTime time;
	private String useCase;
	private Double price;
	private String notificationMessage;

	public Medicament() {
		notificationMessage = toString();
	}

	public Medicament(Integer id, String name, LocalDate end, String when, LocalTime time, String useCase, Double price,
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}

	public String getWhen() {
		return when;
	}

	public void setWhen(String when) {
		this.when = when;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
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
