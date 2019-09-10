package model;

import java.io.Serializable;
import java.util.Comparator;

public class Pet implements Serializable, Comparator<Pet> {

	private String id;

	private String name;

	private String birthday;

	private String genre;

	private String petType;

	public Pet(String id, String name, String birthday, String genre, String petType) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.genre = genre;
		this.petType = petType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	@Override
	public int compare(Pet o1, Pet o2) {		
		return o1.getName().compareTo(o2.getName());
	}

}
