package model;

import java.io.*;
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
		return "Club [id=" + id + ", name=" + name + ", date=" + date + ", mascotType=" + mascotType;
	}

	public void setOwners(ArrayList<Owner> owners) {
		this.owners = owners;
	}

	// METHODS

	public void generateListOwners() {
		
	}
	
	public void ownerRegister(Owner newOwner) {
		owners.add(newOwner);
		try {
			
			ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream("D:/AAPROGRAMAS/apo2/LAB2/PetClub/PetClub/doc/OWNERS.txt"));
			
			writeFile.writeObject(owners);
			
			writeFile.close();
			
		} catch (Exception e) {
			System.out.println("ERROR: No se ha encontrado Archivo");
		}
	}
	
	public String getListOwners() {
		String msg = "";
		for (int i = 0; i < owners.size(); i++) {
			msg += i +") "+ owners.get(i).getName() +"\n";
		}
		return msg;
	}

	public void petRegister(Pet newPet, int indexOwner) {
		owners.get(indexOwner).petRegister(newPet);
	}

	public void eliminateOwner(int owner) {
		
	}

	public void eliminatePet(int owner, int pet) {

	}
	
	public String petList(int indexOwner) {
		return owners.get(indexOwner).petList();
	}

}
