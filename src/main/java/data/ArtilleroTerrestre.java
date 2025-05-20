package data;

public class ArtilleroTerrestre extends TripulacionTanque {

	public ArtilleroTerrestre(String nombre, int fuerza, int resistencia) {
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
