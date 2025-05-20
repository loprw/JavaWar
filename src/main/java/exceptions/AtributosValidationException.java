package exceptions;

public class AtributosValidationException extends JavaWarException{

	public AtributosValidationException() {
		super("Se ha producido un error en los atributos de los vehículos o los guerreros del juego.");
	}
	
	public AtributosValidationException(String message) {
		super(message);
	}
}
