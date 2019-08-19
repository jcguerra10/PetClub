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
                	agregarNuevoClub();
                	System.out.println("Agregado con exito \n");
            }
        }
	}
	
    private static void agregarNuevoClub() {
		System.out.println("Id del Nuevo Club");
		String newId = scanStr.nextLine();
		System.out.println("Nombre del Nuevo Club");
		String newName = scanStr.nextLine();
		System.out.println("Fecha de Creacion");
		System.out.print("Dia:"); String newDay = scanStr.nextLine();
		System.out.print("Mes"); String newMonth = scanStr.nextLine();
		System.out.print("anio"); String newYear = scanStr.nextLine();
		String newDate = newDay+"/"+newMonth+"/"+newYear;
		System.out.println("Tipo de Mascota ");
		String newMascotType = scanStr.nextLine();
		
		Club newClub = new Club(newId, newName, newDate, newMascotType);
		
		infoSis.clubRegister(newClub);
		
		
	}

	public static void msg() {
    	System.out.println("BIENVENIDO");
    	System.out.println("1. Agregar un nuevo Club");
    	System.out.println("2. Agregar un nuevo Dueño");
    	System.out.println("3. Agregar una nueva Mascota");
    	
    }

}
