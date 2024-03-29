package model;

import java.io.*;
import java.util.ArrayList;

import exceptions.NotFoundException;
import exceptions.RegistrationFail;

public class InfoClubs {

	public static String dir = "D:\\AAPROGRAMAS\\apo2\\LAB2\\PetClub\\PetClub\\doc\\clubs.txt";
	public static String dirC = "D:\\AAPROGRAMAS\\apo2\\LAB2\\PetClub\\PetClub\\doc\\Data.csv";
	
	private ArrayList<Club> clubs;

	public InfoClubs() {

		clubs = new ArrayList<Club>();
		importFiles();
	}

	public void clubRegister(Club newClub) throws RegistrationFail {
		for (int i = 0; i < clubs.size(); i++) {
			if (newClub.getId().equals(clubs.get(i).getId())) {
				new RegistrationFail().printStackTrace();
				;
			}
			}
			clubs.add(newClub);
		try {
			FileWriter entry = new FileWriter(dirC);

			BufferedWriter bufferW = new BufferedWriter(entry);

			String nClub = "";
			for (int i = 0; i < clubs.size(); i++) {
				nClub = "" + clubs.get(i);
				bufferW.write(nClub);
				bufferW.newLine();
			}

			bufferW.close();

		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo");
		}

	}

	public void ownerRegister(int club, Owner newOwner) {
		try {
			clubs.get(club).ownerRegister(newOwner);
		} catch (RegistrationFail e) {

		}
	}

	public void petRegister(int indexClub, Pet newPet, int indexOwner) {
		clubs.get(indexClub).petRegister(newPet, indexOwner);
	}

	public void eliminateClub(String identification) throws NotFoundException {
		boolean exit = false;
		for (int k = 0; k < clubs.size() || !exit; k++) {
			int comp = k + 1;

			try {
				if (identification.equals(clubs.get(k).getName()) || identification.equals(clubs.get(k).getId())) {
					clubs.remove(k);
					FileWriter entry = new FileWriter(dirC);

					BufferedWriter bufferW = new BufferedWriter(entry);

					String nClub = "";
					for (int i = 0; i < clubs.size(); i++) {
						nClub = i + ") " + clubs.get(i);
						bufferW.write(nClub);
						bufferW.newLine();
					}
					bufferW.close();
					exit = true;
				} else if (comp == clubs.size()) {
					new NotFoundException().printStackTrace();
				}
			} catch (Exception e) {

			}
		}
	}

	public void eliminateOwner(int club, int owner) {
		clubs.get(club).eliminateOwner(owner);
	}

	public void eliminatePet(int club, int owner, String pet) {
		clubs.get(club).eliminatePet(owner, pet);
	}

	public ArrayList<Club> getClubs() {
		return clubs;
	}

	public void setClubs(ArrayList<Club> clubs) {
		this.clubs = clubs;
	}

	public String getListClubs() {
		String msg = "";
		for (int i = 0; i < clubs.size(); i++) {
			msg += i + ") " + clubs.get(i).getName() + "\n";
		}
		return msg;
	}

	public String getListOwners(int indexClub) {
		return clubs.get(indexClub).getListOwners();
	}

	public String petList(int indexClub, int indexOwner) {
		return clubs.get(indexClub).petList(indexOwner);
	}

	public void importFiles() {
		File file = new File(dirC);
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line = "";

			while ((line = buffer.readLine()) != null) {
				String[] s = line.split(",");
				Club e = new Club(s[0], s[1], s[2], s[3]);
				clubs.add(e);

			}
			buffer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Ordenamiento

	public void generateClubListsInsertion() {
		ArrayList<Club> n = getClubs();
		int in;
		for (int i = 0; i < n.size(); i++) {
			System.out.println(n.get(i));
		}
		System.out.println(n.size());
		for (int i = 1; i < n.size(); i++) {
			Club aux = n.get(i);
			in = i;
			while (in > 0 && n.get(in - 1).countOwners() > aux.countOwners()) {
				n.remove(in);
				n.add(in, n.get(in - 1));
				--in;
			}
			n.remove(in);
			n.add(in, aux);
		}
		setClubs(n);
		for (int i = 0; i < n.size(); i++) {
			System.out.println(n.get(i));
		}
	}

	public void sortById() {
		ArrayList<Club> n = getClubs();
		int in;

		for (int i = 1; i < n.size(); i++) {
			Club aux = n.get(i);
			in = i;

			while (in > 0 && (n.get(in - 1).getId().compareTo(aux.getId())) > 0) {
				n.remove(in);
				n.add(in, n.get(in - 1));
				--in;
			}
			n.remove(in);
			n.add(in, aux);
		}
		setClubs(n);
		for (int i = 0; i < n.size(); i++) {
			System.out.println(n.get(i));
		}
	}

	public void sortByName() {
		ArrayList<Club> n = getClubs();
		int in;

		for (int i = 1; i < n.size(); i++) {
			Club aux = n.get(i);
			in = i;

			while (in > 0 && (n.get(in - 1).getName().compareToIgnoreCase(aux.getName())) > 0) {
				n.remove(in);
				n.add(in, n.get(in - 1));
				--in;
			}
			n.remove(in);
			n.add(in, aux);
		}
		setClubs(n);
		for (int i = 0; i < n.size(); i++) {
			System.out.println(n.get(i));
		}
	}

	public void sortByPetType() {
		ArrayList<Club> n = getClubs();
		int in;

		for (int i = 1; i < n.size(); i++) {
			Club aux = n.get(i);
			in = i;

			while (in > 0 && (n.get(in - 1).getMascotType().compareToIgnoreCase(aux.getMascotType())) > 0) {
				n.remove(in);
				n.add(in, n.get(in - 1));
				--in;
			}
			n.remove(in);
			n.add(in, aux);
		}
		setClubs(n);
		for (int i = 0; i < n.size(); i++) {
			System.out.println(n.get(i));
		}
	}

	public void sortOwnersBubble() {
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).sortOwnersBubble();
		}
	}

	public void sortOwnersBubbleId() {
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).sortOwnersBubbleId();
		}
	}

	public void sortOwnersBubbleName() {
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).sortOwnersBubbleName();
		}
	}

	public void sortOwnersBubbleMascotType() {
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).sortOwnersBubbleMascotType();
		}
	}

	public void sortBySelectionId() {
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).sortBySelectionId();
		}
	}

	public void sortBySelectionName() {
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).sortBySelectionName();
		}
	}

	public void sortBySelectionPetType() {
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).sortBySelectionPetType();
		}
	}

	public int binarySearchNameClub(Club c) {
		sortBySelectionName();
		int position = -1;
		int start = 0;
		int last = clubs.size();

		while (start <= last && position == -1) {
			int mid = (start + last) / 2;
			Club half = clubs.get(mid);
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

	public int regularSearchNameClub(Club c) {
		int position = 0;
		boolean exit = false;

		for (int i = 0; i < clubs.size() || !exit; i++) {
			if (c.compare(c, clubs.get(i)) == 0) {
				position = i;
				exit = true;
			}
		}
		if (exit == false) {
			position = -1;
		}
		return position;
	}
	
	public int binarySearchNameOwner(Owner o) {
		int position = 0;
		boolean exit = false;
		for (int i = 0; i < clubs.size() || !exit; i++) {
			position = clubs.get(i).binarySearchName(o);
		}
		
		return position;
	}
	
	public int regularSearchNameOwner(Owner o) {
		int position = 0;
		boolean exit = false;
		for (int i = 0; i < clubs.size() || !exit; i++) {	
			if (clubs.get(i).regularSearchName(o) != -1) {
				position = clubs.get(i).regularSearchName(o);
				exit = true;
			}

		}	
		return position;	
	}

	public int binarySearchNamePet(Pet o) {
		int position = 0;
		boolean exit = false;
		for (int i = 0; i < clubs.size() || !exit; i++) {
			if (clubs.get(i).binarySearchPet(o) != -1) {
				position = clubs.get(i).binarySearchPet(o);
				exit = true;
			}
			
		}	
		return position;	
	}
}
