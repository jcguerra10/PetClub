package model;

import java.util.ArrayList;

public class Club {
	// ATTRIBUTES
	private String id;

	private String name;

	private String date;

	private String mascotType;

	//

	private ArrayList<Owner> owners;

	// CONSTRUCTOR

	public Club(String id, String name, String date, String mascotType) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.mascotType = mascotType;
		owners = new ArrayList<Owner>();
	}

	// GET & SET
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMascotType() {
		return mascotType;
	}

	public void setMascotType(String mascotType) {
		this.mascotType = mascotType;
	}

	public ArrayList<Owner> getOwners() {
		return owners;
	}

	@Override
	public String toString() {
		return "Club [id=" + id + ", name=" + name + ", date=" + date + ", mascotType=" + mascotType + ", owners="
				+ owners + "]";
	}

	public void setOwners(ArrayList<Owner> owners) {
		this.owners = owners;
	}

	// METHODS

	public void generateListOwners() {

	}

	public void ownerRegister() {

	}

	public void petRegister() {

	}

	public void eliminateOwner(int owner) {

	}

	public void eliminatePet(int owner, int pet) {

	}

}
