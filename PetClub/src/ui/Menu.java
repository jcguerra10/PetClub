package ui;

import java.util.Scanner;

import model.*;

public class Menu {

	private static Scanner scanStr;
	private static Scanner scanDou;
	private static Scanner scanInt;

	private static InfoClubs infoSis;

	public static void main(String[] args) {
		
		infoSis = new InfoClubs();
		
		scanStr = new Scanner(System.in);
	    scanDou = new Scanner(System.in);
	    scanInt = new Scanner(System.in);
	    
		boolean exit = false;
        int option = 0;
        while(!exit){
        	msg();
            option = scanInt.nextInt();
            switch (option) {
                case (1):
                	addNewClub();
                	System.out.println("Agregado con exito \n");
                break;
                case (2):
                	addOwner();
                	System.out.println("Agregado con exito \n");
                case (3):
                	addPet();
                	System.out.println("Agregado con exito \n");
            }
        }
	}

	private static void addNewClub() {
		System.out.println("Id del Nuevo Club");
		String newId = scanStr.nextLine();
		System.out.println("Nombre del Nuevo Club");
		String newName = scanStr.nextLine();
		System.out.println("Fecha de Creacion");
		System.out.print("Dia:");
		String newDay = scanStr.nextLine();
		System.out.print("Mes");
		String newMonth = scanStr.nextLine();
		System.out.print("anio");
		String newYear = scanStr.nextLine();
		String newDate = newDay + "/" + newMonth + "/" + newYear;
		System.out.println("Tipo de Mascota ");
		String newMascotType = scanStr.nextLine();

		Club newClub = new Club(newId, newName, newDate, newMascotType);

		infoSis.clubRegister(newClub);

	}

	public static void addOwner() {

		System.out.println(infoSis.getListClubs());
		int indexClub = scanInt.nextInt();

		System.out.println("Id del Dueño");
		String newId = scanStr.nextLine();
		System.out.println("Nombre del Dueño");
		String newName = scanStr.nextLine();
		System.out.println("Apellido del dueño");
		String newLastName = scanStr.nextLine();
		System.out.println("Fecha de Nacimiento");
		System.out.print("Dia:");
		String newDay = scanStr.nextLine();
		System.out.print("Mes");
		String newMonth = scanStr.nextLine();
		System.out.print("anio");
		String newYear = scanStr.nextLine();
		String newDate = newDay + "/" + newMonth + "/" + newYear;
		System.out.println("Tipo de Mascota ");
		String newMascotType = scanStr.nextLine();

		Owner newOwner = new Owner(newId, newName, newLastName, newDate, newMascotType);

		infoSis.ownerRegister(indexClub, newOwner);
	}
	
	public static void addPet() {
		
		System.out.println(infoSis.getListClubs());
		int indexClub = scanInt.nextInt();
		System.out.println(infoSis.getListOwners(indexClub));
		int indexOwner = scanInt.nextInt();
		System.out.println("Id de la nueva Mascota");
		String newId = scanStr.nextLine();
		System.out.println("Nombre de la nueva Mascota");
		String newName = scanStr.nextLine();
		System.out.println("Nacimiento de la nueva Mascota");
		System.out.print("Dia:");
		String newDay = scanStr.nextLine();
		System.out.print("Mes");
		String newMonth = scanStr.nextLine();
		System.out.print("anio");
		String newYear = scanStr.nextLine();
		String newDate = newDay + "/" + newMonth + "/" + newYear;
		System.out.println("Genero de la nueva Mascota");
		System.out.println("1. Macho");
		System.out.println("2. Hembra");
		int op = scanInt.nextInt();
		String newGenre = "";
		if (op == 1) {
			newGenre = "Macho";
		} else if (op == 2){
			newGenre = "Hembra";
		}
		System.out.println("Tipo de Mascota ");
		String newMascotType = scanStr.nextLine();

		Pet newPet = new Pet(newId, newName, newDate, newGenre, newMascotType);

		infoSis.petRegister(indexClub, newPet, indexOwner);
	}

	public static void msg() {
		System.out.println("BIENVENIDO");
		System.out.println("1. Agregar un nuevo Club");
		System.out.println("2. Agregar un nuevo Dueño");
		System.out.println("3. Agregar una nueva Mascota");

	}

}
