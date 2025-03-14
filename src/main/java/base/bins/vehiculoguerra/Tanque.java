package base.bins.vehiculoguerra;

import java.util.List;

import base.bins.guerrero.Guerrero;
import base.bins.guerrero.TripulacionTanque;
import base.exceptions.AtaqueValidationException;
import base.exceptions.DefensaValidationException;
import base.exceptions.SumaAtributosValidationException;

public class Tanque extends VehiculoGuerra {

	public Tanque(String nombre, int ataque, int defensa)
			throws AtaqueValidationException, DefensaValidationException, SumaAtributosValidationException {
		super(nombre, ataque, defensa) ;
		this.setTipo("Tanque");
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

		System.out.println("\n\t\tEl tanque defiende con un valor total de " + totalDefensa + ".");

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

		totalAtaque = (int) (this.getAtaque() * (Math.random() * 1.1) + sumaGuerreros * (Math.random() * 1.1 / 2));

		System.out.println("\n\t\tEl tanque ataca con un valor total de " + totalAtaque + ".");

		return totalAtaque;
	}

	@Override
	public void recibirDany(int totalAtaque, int totalDefensa) {
		int dany = totalAtaque - totalDefensa;

		if (dany > 0) {
			System.out.print("\n\t\tEl tanque ha recibido " + dany + " puntos de daño.");

			int nuevosPuntosVida = this.getPuntosVida() - dany;

			this.setPuntosVida(nuevosPuntosVida);

			System.out.println("\n\t\tEl total de puntos de vida es de " + nuevosPuntosVida + ".\n");
		} else {
			System.out.println("\n\t\tEl ataque ha sido infructuoso.\n");
		}
	}

	@Override
	public void embarcarGuerrero(Guerrero guerrero) {
		getGuerrerosEmbarcados().add(guerrero);
	}
	
	public void embarcarGuerrero(TripulacionTanque guerrero) {
		Guerrero guerreroGuerrero = (Guerrero) guerrero;
		embarcarGuerrero(guerreroGuerrero);
	}
	
	@Override
	public void embarcarGuerreros(Guerrero[] guerreros) {
		for (Guerrero guerrero : guerreros) {
			getGuerrerosEmbarcados().add(guerrero);	
		}
	}
	
	public void embarcarGuerreros(TripulacionTanque[] guerreros) {
		embarcarGuerreros(guerreros);
	}
	
	public void embarcarGuerreros(List<TripulacionTanque> guerreros) {
		for (Guerrero guerrero : guerreros) {
			getGuerrerosEmbarcados().add(guerrero);	
		}
	}
}
