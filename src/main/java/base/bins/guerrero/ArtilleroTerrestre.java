package base.bins.guerrero;

import base.exceptions.FuerzaValidationException;
import base.exceptions.ResistenciaValidationException;
import base.exceptions.SumaAtributosValidationException;

public class ArtilleroTerrestre extends TripulacionTanque {

	public ArtilleroTerrestre(String nombre, int fuerza, int resistencia)
			throws FuerzaValidationException, ResistenciaValidationException, SumaAtributosValidationException {
		super(nombre, fuerza, resistencia);
		setTipo("Artillero Terrestre");
	}

	public ArtilleroTerrestre(String nombre) {
		super(nombre);
		setTipo("Artillero Terrestre");
		setFuerza(6);
		setResistencia(4);
	}
}
