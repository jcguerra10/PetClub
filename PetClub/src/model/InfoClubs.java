package model;

import java.io.*;
import java.util.ArrayList;

import exceptions.NotFoundException;

public class InfoClubs {

	private ArrayList<Club> clubs;

	public InfoClubs() {
		clubs = new ArrayList<Club>();
		Club club1 = new Club("102156", "Juanchio", "16/8/2019", "Perro");
		clubRegister(club1);
	}

	public void clubRegister(Club newClub) {
		clubs.add(newClub);
		try {
			FileWriter entry = new FileWriter("D:\\AAPROGRAMAS\\apo2\\LAB2\\PetClub\\PetClub\\doc\\DATA.txt");

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

	public void generateLists() {

	}

	public void ownerRegister(int club, Owner newOwner) {
		clubs.get(club).ownerRegister(newOwner);
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
					FileWriter entry = new FileWriter("D:\\AAPROGRAMAS\\apo2\\LAB2\\PetClub\\PetClub\\doc\\DATA.txt");

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
	
	public void exportClubs() {
		
		            
	}
}
