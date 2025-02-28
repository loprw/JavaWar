package base;

import base.exceptions.FuerzaValidationException;
import base.exceptions.ResistenciaValidationException;
import base.exceptions.SumaAtributosValidationException;

public class Conductor extends TripulacionTanque {
	
	public Conductor(String nombre, int fuerza, int resistencia)
			throws FuerzaValidationException, ResistenciaValidationException, SumaAtributosValidationException {
		super(nombre, fuerza, resistencia);
		setTipo("Conductor");
	}
	
	public Conductor(String nombre) {
		super(nombre);
		setTipo("Conductor");
		setFuerza(4);
		setResistencia(6);
	}
}
