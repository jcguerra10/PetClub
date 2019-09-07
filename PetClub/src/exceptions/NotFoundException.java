package exceptions;

public class NotFoundException extends Exception{
	public NotFoundException() {
		super("ERROR: No se ha encontrado el objeto");
	}
}
