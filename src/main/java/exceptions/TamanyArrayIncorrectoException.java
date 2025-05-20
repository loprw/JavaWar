package exceptions;

public class TamanyArrayIncorrectoException extends JavaWarException{

	public TamanyArrayIncorrectoException() {
		super("Se ha encontrado un error en el tamaño de un array.");
	}

	public TamanyArrayIncorrectoException(String message) {
		super(message);
	}
	
	
}
