package base.bins.guerrero;

import base.exceptions.FuerzaValidationException;
import base.exceptions.ResistenciaValidationException;
import base.exceptions.SumaAtributosValidationException;

public abstract class TripulacionTanque extends Guerrero {

	public TripulacionTanque(String nombre, int fuerza, int resistencia)
			throws FuerzaValidationException, ResistenciaValidationException, SumaAtributosValidationException {
		super(nombre, fuerza, resistencia);
	}
	
	public TripulacionTanque(String nombre) {
		super(nombre);
	}
}
