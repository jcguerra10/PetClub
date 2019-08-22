package model;

import java.io.*;
import java.util.ArrayList;

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
				nClub = i+") " + clubs.get(i);
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

	public void eliminateClub(int club) {

	}

	public void eliminateOwner(int club, int owner) {

	}

	public void eliminatePet(int club, int owner, int pet) {

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
			msg += i +") "+clubs.get(i).getName() +"\n";
		}
		return msg;
	}
	public String getListOwners(int indexClub) {
		return clubs.get(indexClub).getListOwners();
	}
	
	public String petList(int indexClub, int indexOwner) {
		return clubs.get(indexClub).petList(indexOwner);
	}
}
