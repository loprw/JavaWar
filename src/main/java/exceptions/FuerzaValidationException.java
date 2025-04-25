package exceptions;

public class FuerzaValidationException extends AtributosValidationException {

	public FuerzaValidationException() {
		super("Se ha producido un error en la Fuerza del Guerrero: debe ser un valor entre 0 y 10.");
	}
	
	public FuerzaValidationException(String message) {
		super(message);
	}
}
