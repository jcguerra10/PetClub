package exceptions;

public class RegistrationFail extends Exception{
	public RegistrationFail() {
		super("ObjectAlreadyExist");
	}
}
