package base.bins.guerrero;

import base.exceptions.FuerzaValidationException;
import base.exceptions.ResistenciaValidationException;
import base.exceptions.SumaAtributosValidationException;

public abstract class TripulacionDestructor extends Guerrero {

	public TripulacionDestructor(String nombre, int fuerza, int resistencia)
			throws FuerzaValidationException, ResistenciaValidationException, SumaAtributosValidationException {
		super(nombre, fuerza, resistencia);
	}
	
	public TripulacionDestructor(String nombre) {
		super(nombre);
	}
}
