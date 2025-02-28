package base;

import base.exceptions.FuerzaValidationException;
import base.exceptions.ResistenciaValidationException;
import base.exceptions.SumaAtributosValidationException;

public class ArtilleroNaval extends TripulacionDestructor {

	public ArtilleroNaval(String nombre, int fuerza, int resistencia)
			throws FuerzaValidationException, ResistenciaValidationException, SumaAtributosValidationException {
		super(nombre, fuerza, resistencia);
		setTipo("Artillero Naval");
	}

	public ArtilleroNaval(String nombre) {
		super(nombre);
		setTipo("Artillero Naval");
		setFuerza(6);
		setResistencia(4);
	}
}
