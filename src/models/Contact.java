package models;

import java.time.LocalDate;

public class Contact {
	private Integer id;
	private String name;
	private String group;
	private String number;
	private String image;
	private boolean favorite;
	private LocalDate dateAdded;

	public Contact() {
		// here i should initiate the dateAdded;
	}

	public Contact(Integer id, String name, String groupe, String number, String image, boolean favorite,
			LocalDate dateAdded) {
		super();
		this.id = id;
		this.name = name;
		this.group = groupe;
		this.number = number;
		this.image = image;
		this.favorite = favorite;
		this.dateAdded = dateAdded;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
