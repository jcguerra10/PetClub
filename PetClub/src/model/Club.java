package model;

import java.io.*;
import java.util.ArrayList;

public class Club implements Comparable<Club> {
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
		importOwners();
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
		return id + "," + name + "," + date + "," + mascotType;
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

			ObjectOutputStream writeFile = new ObjectOutputStream(
					new FileOutputStream("D:/AAPROGRAMAS/apo2/LAB2/PetClub/PetClub/doc/owners" + getId() + ".txt"));

			writeFile.writeObject(owners);

			writeFile.close();

		} catch (Exception e) {
			System.out.println("ERROR: No se ha encontrado Archivo");
		}
	}

	public String getListOwners() {
		String msg = "";
		for (int i = 0; i < owners.size(); i++) {
			msg += i + ") " + owners.get(i).getName() + "\n";
		}
		return msg;
	}

	public void petRegister(Pet newPet, int indexOwner) {
		owners.get(indexOwner).petRegister(newPet);
	}

	public void eliminateOwner(int owner) {
		owners.remove(owner);
		try {

			ObjectOutputStream writeFile = new ObjectOutputStream(

					new FileOutputStream("D:/AAPROGRAMAS/apo2/LAB2/PetClub/PetClub/doc/owners" + getId() + ".txt"));

			writeFile.writeObject(owners);

			writeFile.close();

		} catch (Exception e) {
			System.out.println("ERROR: No se ha encontrado Archivo");
		}
	}

	public void eliminatePet(int owner, String id) {
		owners.get(owner).eliminatePet(id);
	}

	public String petList(int indexOwner) {
		return owners.get(indexOwner).petList();
	}

	public void importOwners() {
		try {
			ArrayList<Owner> export = null;
			ObjectInputStream exportFile = new ObjectInputStream(
			new FileInputStream("D:/AAPROGRAMAS/apo2/LAB2/PetClub/PetClub/doc/owners" + getId() + ".txt"));
			
			ArrayList<Owner> readObject = (ArrayList<Owner>) exportFile.readObject();
			export = readObject;
			
			for (int i = 0; i < export.size(); i++) {
				owners.add(export.get(i));
			}
			
			exportFile.close();

		} catch (Exception e) {
			
		}
	}
	
	public int countOwners() {
		return owners.size();
	}

	@Override
	public int compareTo(Club o) {
		int comp = getName().compareTo(o.getName());
		return comp;
	}

}
