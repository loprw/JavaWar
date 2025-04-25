package data;

import entities.Guerrero;

public abstract class TripulacionTanque extends Guerrero {

	public TripulacionTanque(String nombre, int fuerza, int resistencia) {
		super(nombre, fuerza, resistencia);
	}
	
	public TripulacionTanque(String nombre) {
		super(nombre);
	}
}
