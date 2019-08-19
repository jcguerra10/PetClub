package model;

import java.io.*;
import java.util.ArrayList;

public class InfoClubs {
	
	private ArrayList<Club> clubs;
	
	public InfoClubs() {
		clubs = new ArrayList<Club>();
	}
	
	public void clubRegister(Club newClub) {
		clubs.add(newClub);
		try {
			FileWriter entry = new FileWriter("D:\\AAPROGRAMAS\\apo2\\LAB2\\PetClub\\PetClub\\doc\\DATA.txt");
			
			BufferedWriter bufferW = new BufferedWriter(entry);
			
			boolean exit = false;
			
			String nClub = "";
			nClub += clubs.get(clubs.size()-1);
			
			bufferW.write(nClub);
			
			bufferW.close();
			
		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo");
		}
		
		
	}

	public void generateLists() {
		
	}

	public void ownerRegister() {

	}

	public void petRegister() {

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
}
