package ui;

import java.util.Scanner;

import exceptions.NotFoundException;
import exceptions.RegistrationFail;
import model.*;

public class Menu {

	private static Scanner scanStr;
	private static Scanner scanInt;

	private static InfoClubs infoSis;

	public static void main(String[] args) {
		
		infoSis = new InfoClubs();
		
		scanStr = new Scanner(System.in);
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
                break;	
                case (3):
                	addPet();
                	System.out.println("Agregado con exito \n");
                break;
                case (4):
                	eliminateClub();              
               	break;
                case (5):
                	eliminateOwner();
                	System.out.println("Eliminado con exito \n");
                break;
                case (6):
                	eliminatePet();
                break;
                case (7):
                	generateClubList();
                break;
                case (8):
                	clubSortById();
                break;
                case (9):
                	infoSis.sortByName();
                break;
                case (10):
                	infoSis.sortByPetType();
                break;	
                case(11):
                	infoSis.sortOwnersBubbleId();
                break;
                case (12):
                	infoSis.sortOwnersBubbleName();
                break;
                case (13):
                	infoSis.sortOwnersBubbleMascotType();
                break;
                case (14):
                	infoSis.sortById();         
                break;
                case (15):
                	infoSis.sortByName();                
                break;
                case (16):
                	infoSis.sortByPetType();
                break;
                case (17):
                	binarySearchNameC();
                break;
                case (18):
                	traditionalSearchC();
                break;
                case (19):
                	binarySearchNameO();
                break;	
                case (20):
                	traditionalSearchNameO();
                case(21):
                	binarySearchNameM();
                break;
                case (0):
                	exit = true;
                break;
            }
        }
	}

	
	private static void binarySearchNameM() {
		System.out.println("Digite el nombre: ");
		String bName = scanStr.nextLine();
		Pet search = new Pet(null, bName, null, null, null);
		infoSis.binarySearchNamePet(search);
	}


	private static void traditionalSearchNameO() {
		System.out.println("Digite el nombre: ");
		String bName = scanStr.nextLine();
		Owner search = new Owner(null, bName, null, null, null);
		infoSis.regularSearchNameOwner(search);
	} 


	private static void binarySearchNameO() {
		System.out.println("Digite el nombre: ");
		String bName = scanStr.nextLine();
		Owner search = new Owner(null, bName, null, null, null);
		infoSis.binarySearchNameOwner(search);
	}


	private static void binarySearchNameC() {
		System.out.println("Digite el nombre: ");
		String bName = scanStr.nextLine();
		Club search = new Club(null, bName, null, null);
		infoSis.binarySearchNameClub(search);
		
	}
	
	private static void traditionalSearchC() {
		System.out.println("Digite el nombre: ");
		String bName = scanStr.nextLine();
		Club search = new Club(null, bName, null, null);
		infoSis.regularSearchNameClub(search);
		
	}

	private static void clubSortById() {
		infoSis.sortById();		
	}

	public static void generateClubList() {
		infoSis.generateClubListsInsertion();
	}

	public static void eliminateClub() {
		System.out.print("Digite el codigo o el nombre del Club: ");
		String identification = scanStr.nextLine();
		try {
			infoSis.eliminateClub(identification);
		} catch (NotFoundException e) {
			
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

		try {
			infoSis.clubRegister(newClub);
		} catch (RegistrationFail e) {

		}

	}

	public static void addOwner() {

		System.out.println(infoSis.getListClubs());
		int indexClub = scanInt.nextInt();

		System.out.println("Id del Due�o");
		String newId = scanStr.nextLine();
		System.out.println("Nombre del Due�o");
		String newName = scanStr.nextLine();
		System.out.println("Apellido del due�o");
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
	
	public static void eliminateOwner() {
		System.out.println(infoSis.getListClubs());
		int indexClub = scanInt.nextInt();
		System.out.println(infoSis.getListOwners(indexClub));
		int indexOwner = scanInt.nextInt();
		
		infoSis.eliminateOwner(indexClub, indexOwner);
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
	
	public static void eliminatePet() {
		System.out.println(infoSis.getListClubs());
		int indexClub = scanInt.nextInt();
		System.out.println(infoSis.getListOwners(indexClub));
		int indexOwner = scanInt.nextInt();
		System.out.print("Digite el Codigo o Nombre de la mascota");
		String idPet = scanInt.nextLine();
		
		infoSis.eliminatePet(indexClub, indexOwner, idPet);
	}

	public static void msg() {
		System.out.println("BIENVENIDO");
		System.out.println("1. Agregar un nuevo Club");
		System.out.println("2. Agregar un nuevo Due�o");
		System.out.println("3. Agregar una nueva Mascota");
		System.out.println("4. Eliminar Club");
		System.out.println("5. Eliminar Due�o");
		System.out.println("6. Eliminar Mascota");
		System.out.println("7. Generar listas");
		System.out.println("8. Ordenar Club por Id");
		System.out.println("9. Ordenar Club por Nombre");
		System.out.println("10. Ordenar Club por Tipo de mascota");
		System.out.println("11. Ordenar Due�os por Id");
		System.out.println("12. Ordenar Due�os por Nombre");
		System.out.println("13. Ordenar Due�os por tipo mascota");
		System.out.println("14. Ordenar Mascota por Id");
		System.out.println("15. Ordenar Mascota por Nombre");
		System.out.println("16. Ordenar Mascota por Tipo de mascota");
		System.out.println("17. Busqueda Binaria Club");
		System.out.println("18. Busqueda Tradicional Club");
		System.out.println("19. Busqueda Binaria Due�o");
		System.out.println("20. Busqueda Tradicional Due�o");
		System.out.println("21. Busqueda Binaria Animal");
		System.out.println("22. Busqueda Tradicional Animal");
	}

}
