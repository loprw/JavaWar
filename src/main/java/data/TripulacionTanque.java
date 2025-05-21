package data;

import entities.Guerrero;
import utils.Utils;

public abstract class TripulacionTanque extends Guerrero {

	public TripulacionTanque(String nombre, int fuerza, int resistencia) {
		super(nombre, fuerza, resistencia);
		Utils.validarFuerza(fuerza, this);
		Utils.validarResistencia(resistencia, this);
		Utils.validarAtributosGuerrero(fuerza, resistencia, this);
	}
	
	public TripulacionTanque(String nombre) {
		super(nombre);
	}
}
