package model;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Owner implements Serializable {
	private String id;

	private String name;

	private String lastName;

	private String birthday;

	private String petType;
	
	private ArrayList<Pet> pets;

	public Owner(String id, String name, String lastName, String birthday, String petType) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.birthday = birthday;
		this.petType = petType;
		pets = new ArrayList<Pet>();
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	public ArrayList<Pet> getPets() {
		return pets;
	}

	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}
	
	//
	
	public void petRegister(Pet newPet) {
		pets.add(newPet);
		try {
			
			ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream("D:/AAPROGRAMAS/apo2/LAB2/PetClub/PetClub/doc/PETS.txt"));
			
			writeFile.writeObject(pets);
			
			writeFile.close();
			
		} catch (Exception e) {
			System.out.println("ERROR: No se ha encontrado Archivo");
		}
	}
	
	public void eliminatePet(int pet) {
		
	}
	
	public String petList() {
		String msg = "";
		
		for (int i = 0; i < pets.size(); i++) {
			msg += i+") "+pets.get(i).getName();
		}
		
		return msg;
		
	}
	
	
	

}
