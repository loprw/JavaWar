package base.exceptions;

public class ResistenciaValidationException extends AtributosValidationException{

	public ResistenciaValidationException() {
		super("Se ha producido un error en la Resistencia del Guerrero: debe ser un valor entre 0 y 10.");
	}
	
	public ResistenciaValidationException(String message) {
		super(message);
	}
}
