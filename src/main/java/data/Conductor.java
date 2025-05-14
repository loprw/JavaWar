package data;

public class Conductor extends TripulacionTanque {
	
	public Conductor(String nombre, int fuerza, int resistencia) {
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
