package model;

import java.io.*;
import java.util.ArrayList;

import exceptions.NotFoundException;

public class InfoClubs {

	public static String dir = "D:\\AAPROGRAMAS\\apo2\\LAB2\\PetClub\\PetClub\\doc\\clubs.txt";

	private ArrayList<Club> clubs;

	public InfoClubs() {
		
		clubs = new ArrayList<Club>();
		importFiles();
	}

	public void clubRegister(Club newClub) {
		clubs.add(newClub);
		try {
			FileWriter entry = new FileWriter(dir);

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

	public void generateClubListsInsertion() {
		ArrayList<Club> n = getClubs();
		int in;
		 
        for (int i = 1 ; i < n.size() ; i++) {
            Club aux = n.get(i);
            in = i;  
        
            while (in > 0 && n.get(in - 1).countOwners() > aux.countOwners()) {
                n.add(in, n.get(in - 1));
                --in;
            }
 
            n.add(in, aux);	
        }
        setClubs(n);
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
					FileWriter entry = new FileWriter(dir);

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
//			msg += i + ") " + clubs.get(i).getName() + "\n";
			msg += clubs.get(i) +"\n";
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
		File file = new File(dir);
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line = "";
			
			while ((line = buffer.readLine())!= null) {
				String[] s = line.split(",");
				Club e = new Club(s[0],s[1], s[2], s[3]);
				clubs.add(e);
				
			}
			buffer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
