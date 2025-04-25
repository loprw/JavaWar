package exceptions;

public class JavaWarException extends Exception {

	public JavaWarException() {
		super("Se ha producido un error en el juego.");
	}
	
	public JavaWarException(String message) {
		super(message);
	}
}
