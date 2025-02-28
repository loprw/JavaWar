package base.exceptions;

public class SumaAtributosValidationException extends AtributosValidationException {

	public SumaAtributosValidationException() {
		super("Se ha producido un error en el sumatorio de Fuerza y Resistencia del Guerrero: no pueden sumar más de 10.");
	}
	
	public SumaAtributosValidationException(String message) {
		super(message);
	}
}
