package data;

import entities.Guerrero;

public abstract class TripulacionDestructor extends Guerrero {

	public TripulacionDestructor(String nombre, int fuerza, int resistencia) {
		super(nombre, fuerza, resistencia);
	}
	
	public TripulacionDestructor(String nombre) {
		super(nombre);
	}
}
