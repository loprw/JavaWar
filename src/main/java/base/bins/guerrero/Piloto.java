package base.bins.guerrero;

import base.exceptions.FuerzaValidationException;
import base.exceptions.ResistenciaValidationException;
import base.exceptions.SumaAtributosValidationException;

public class Piloto extends TripulacionDestructor {

	public Piloto(String nombre, int fuerza, int resistencia)
			throws FuerzaValidationException, ResistenciaValidationException, SumaAtributosValidationException {
		super(nombre, fuerza, resistencia);
		setTipo("Piloto");
	}
	
	public Piloto(String nombre) {
		super(nombre);
		setTipo("Piloto");
		setFuerza(4);
		setResistencia(6);
	}
}
