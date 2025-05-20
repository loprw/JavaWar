package data;

public class ArtilleroNaval extends TripulacionDestructor {

	public ArtilleroNaval(String nombre, int fuerza, int resistencia) {
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
