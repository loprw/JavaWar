package base;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import base.exceptions.AtaqueValidationException;
import base.exceptions.DefensaValidationException;
import base.exceptions.SumaAtributosValidationException;

public class Destructor extends VehiculoGuerra {
	
	private static final Logger logger = LoggerFactory.getLogger(Destructor.class);

	public Destructor(String nombre, int ataque, int defensa)
			throws AtaqueValidationException, DefensaValidationException, SumaAtributosValidationException {
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

			System.out.println("\n\t\tEl total de puntos de vida es de " + nuevosPuntosVida + ".\n");
		} else {
			System.out.println("\n\t\tEl ataque ha sido infructuoso.\n");
		}
	}

	@Override
	public void embarcarGuerrero(Guerrero guerrero) {
		logger.debug("Entrando en el método embarcarGuerrero.");
		getGuerrerosEmbarcados().add(guerrero);
	}
	
	public void embarcarGuerrero(TripulacionDestructor guerrero) {
		embarcarGuerrero(guerrero);
	}
	
	@Override
	public void embarcarGuerreros(Guerrero[] guerreros) {
		for (Guerrero guerrero : guerreros) {
			getGuerrerosEmbarcados().add(guerrero);	
		}
	}
	
	public void embarcarGuerreros(TripulacionDestructor[] guerreros) {
		embarcarGuerreros(guerreros);
	}
	
	public void embarcarGuerreros(List<TripulacionDestructor> guerreros) {
		for (Guerrero guerrero : guerreros) {
			getGuerrerosEmbarcados().add(guerrero);	
		}
	}
 }
