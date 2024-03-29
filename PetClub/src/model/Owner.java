package model;

import java.io.*;
import java.util.*;

import exceptions.NotFoundException;
import exceptions.RegistrationFail;

public class Owner implements Serializable, Comparable<Owner>, Comparator<Owner>{
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

	public void petRegister(Pet newPet) throws RegistrationFail {
		for (int i = 0; i < pets.size(); i++) {
			if (newPet.getId().equals(pets.get(i).getId())) {
				new RegistrationFail().printStackTrace();;
			}
		}
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
					ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream(
							"D:/AAPROGRAMAS/apo2/LAB2/PetClub/PetClub/doc/pets" + getId() + ".txt"));

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
			msg += i + ") " + pets.get(i).getName();
		}

		return msg;

	}

	public void importPets() {
		try {
			ArrayList<Pet> export = null;
			ObjectInputStream exportFile = new ObjectInputStream(new FileInputStream(
					new File("D:/AAPROGRAMAS/apo2/LAB2/PetClub/PetClub/doc/pets" + getId() + ".txt")));

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
		if (counterPets() < o.counterPets()) {
			comp = -1;
		} else if (counterPets() > o.counterPets()) {
			comp = 1;
		} else if (counterPets() == o.counterPets()) {
			comp = 0;
		}
		return comp;
	}

	public void sortBySelectionId() {
		ArrayList<Pet> p = getPets();
		int i, j, pos;
		Pet menor, tmp;
		for (i = 0; i < p.size() - 1; i++) {
			menor = p.get(i);
			pos = i; 
			for (j = i + 1; j < p.size(); j++) { 
				if ((p.get(j).getId().compareTo(menor.getId())<0)) { 
					menor = p.get(j);
					pos = j;
				}
			}
			if (pos != i) {
				tmp = p.get(i);
				p.remove(i);
				p.add(i, p.get(pos));
				p.remove(pos);
				p.add(pos, tmp);
			}
		}
	}
	
	public void sortBySelectionName() {
		ArrayList<Pet> p = getPets();
		int i, j, pos;
		Pet menor, tmp;
		for (i = 0; i < p.size() - 1; i++) {
			menor = p.get(i);
			pos = i; 
			for (j = i + 1; j < p.size(); j++) { 
				if ((p.get(j).getName().compareTo(menor.getName())<0)) { 
					menor = p.get(j);
					pos = j;
				}
			}
			if (pos != i) {
				tmp = p.get(i);
				p.remove(i);
				p.add(i, p.get(pos));
				p.remove(pos);
				p.add(pos, tmp);
			}
		}
	}
	
	public void sortBySelectionPetType() {
		ArrayList<Pet> p = getPets();
		int i, j, pos;
		Pet menor, tmp;
		for (i = 0; i < p.size() - 1; i++) {
			menor = p.get(i);
			pos = i; 
			for (j = i + 1; j < p.size(); j++) { 
				if ((p.get(j).getPetType().compareTo(menor.getPetType())<0)) { 
					menor = p.get(j);
					pos = j;
				}
			}
			if (pos != i) {
				tmp = p.get(i);
				p.remove(i);
				p.add(i, p.get(pos));
				p.remove(pos);
				p.add(pos, tmp);
			}
		}
	}
	
	public int binarySearchNamePet(Pet c) {
		sortBySelectionName();
		int position = -1;
		int start = 0;
		int last = pets.size();

		while (start <= last && position == -1) {
			int mid = (start + last) / 2;
			Pet half = pets.get(mid);
			if (half.compare(half, c) == 0) {
				position = mid;
			} else if (half.compare(half, c) > 0) {
				last = mid - 1;
			} else if (half.compare(half, c) < 0) {
				start = mid + 1;
			}

		}

		return position;
	}
	
	public int regularSearchNamePet(Pet c) {
		int position = 0;
		boolean exit = false;
		
		for (int i = 0; i < pets.size() || !exit; i++) {
			if (c.compare(c, pets.get(i)) == 0) {
				position = i;
				exit = true;
			}
		}
		if (exit == false) {
			position = -1;
		}
		return position;
	}

	@Override
	public int compare(Owner o1, Owner o2) {
		return o1.getName().compareTo(o2.getName());
	}
}
