package model;

import java.io.*;
import java.util.*;

import exceptions.NotFoundException;

public class Owner implements Serializable, Comparable<Owner>{
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
		importPets();
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
			
			ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream(
					new File("D:/AAPROGRAMAS/apo2/LAB2/PetClub/PetClub/doc/pets" + getId() + ".txt")));

			writeFile.writeObject(pets);
			
			writeFile.close();
			
		} catch (Exception e) {
			System.out.println("ERROR: No se ha encontrado Archivo");
		}
	}
	
	public void eliminatePet(String id) {
		boolean exit = false;
		for (int k = 0; k < pets.size() || !exit; k++) {
			int comp = k + 1;

			try {
				if (id.equals(pets.get(k).getName()) || id.equals(pets.get(k).getId())) {
					pets.remove(k);
					ObjectOutputStream writeFile = new ObjectOutputStream(
					new FileOutputStream("D:/AAPROGRAMAS/apo2/LAB2/PetClub/PetClub/doc/pets"+ getId()+".txt"));

					writeFile.writeObject(pets);

					writeFile.close();
					exit = true;
				} else if (comp == pets.size()) {
					new NotFoundException().printStackTrace();
				}
			} catch (Exception e) {
				
			}
		}
	}
	  
	public String petList() {
		String msg = "";
		
		for (int i = 0; i < pets.size(); i++) {
			msg += i+") "+pets.get(i).getName();
		}
		
		return msg;
		
	}
	
	public void importPets() {
		try {
			ArrayList<Pet> export = null;
			ObjectInputStream exportFile = new ObjectInputStream(
			new FileInputStream(new File("D:/AAPROGRAMAS/apo2/LAB2/PetClub/PetClub/doc/pets"+getId()+".txt")));
			
			ArrayList<Pet> readObject = (ArrayList<Pet>) exportFile.readObject();
			export = readObject;
			
			for (int i = 0; i < export.size(); i++) {
				pets.add(export.get(i));
			}
			
			exportFile.close();

		} catch (Exception e) {
			
		}
	}
	
	public int counterPets() {		
		return pets.size();
	}

	@Override
	public int compareTo(Owner o) {
		int comp = 0;
		if (counterPets()<o.counterPets()) {
			comp = -1;
		}else if (counterPets()>o.counterPets()) {
			comp = 1;
		}else if (counterPets() == o.counterPets()) {
			comp = 0;
		}
		return comp;
	}
	
	
	

}
