
public class Destructor extends VehiculoGuerra {

	public Destructor(String nombre, int ataque, int defensa) {
		super(nombre, ataque, defensa);
		this.setTipo("Destructor");
	}

	@Override
	public int defender(int valorAtaque) {
		int sumaGuerreros = 0;
		int totalDefensa = 0;

		if (this.getGuerrerosEmbarcados() != null) {
			for (Guerrero guerrero : this.getGuerrerosEmbarcados()) {
				sumaGuerreros += guerrero.getResistencia();
			}
		}

		totalDefensa = (int) (this.getDefensa() * (Math.random() * 1.1) + sumaGuerreros * (Math.random() * 1.1 / 2));
		System.out.println("\n\t\tEl destructor defiende con un valor total de " + totalDefensa + ".");

		return totalDefensa;
	}

	@Override
	public int atacar() {
		int sumaGuerreros = 0;
		int totalAtaque = 0;

		if (this.getGuerrerosEmbarcados() != null) {
			for (Guerrero guerrero : this.getGuerrerosEmbarcados()) {
				sumaGuerreros += guerrero.getFuerza();
			}
		}

		totalAtaque = (int) (this.getAtaque() * (Math.random() * 1.1) + sumaGuerreros * (Math.random() * 1.1 / 20));
		System.out.println("\n\t\tEl destructor ataca con un valor total de " + totalAtaque + ".");

		return totalAtaque;
	}

	@Override
	public void recibirDany(int totalAtaque, int totalDefensa) {
		int dany = totalAtaque - totalDefensa;

		if (dany > 0) {
			System.out.print("\n\t\tLa nave ha recibido " + dany + " puntos de daño.");

			int nuevosPuntosVida = this.getPuntosVida() - dany;

			this.setPuntosVida(nuevosPuntosVida);

			System.out.println("\n\t\tLe quedan " + nuevosPuntosVida + ".\n");
		} else {
			System.out.println("\n\t\tEl ataque ha sido infructuoso.\n");
		}
	}
}
