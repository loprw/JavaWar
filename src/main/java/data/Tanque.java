package data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.Guerrero;
import entities.VehiculoGuerra;
import utils.Utils;

public class Tanque extends VehiculoGuerra{
	
	private static final Logger logger = LoggerFactory.getLogger(Tanque.class);

	public Tanque(String nombre, int ataque, int defensa) {
		super(nombre, ataque, defensa);
		this.setTipo("Tanque");
		Utils.validarAtaque(ataque, this);
		Utils.validarDefensa(defensa, this);
		Utils.validarAtributosVehiculos(ataque, defensa, this);
	}

	public Tanque(String nombre) {
		super(nombre);
		this.setTipo("Tanque");
	}
	
	@Override
	public int defender(int valorAtaque) {
		int sumaGuerreros = 0;
		int totalDefensa = 0;

		if (this.getGuerrerosEmbarcados() != null) {
			for (Guerrero guerrero : getGuerrerosEmbarcados()) {
				sumaGuerreros += guerrero.getResistencia();
			}
		}

		totalDefensa = (int) (this.getDefensa() * (Math.random() * 1.1) + sumaGuerreros * (Math.random() * 1.1 / 2));

		System.out.println("\n\t\tEl tanque defiende con un valor total de " + totalDefensa + ".");

		return totalDefensa;
	}
	
	@Override
	public void setAtaque(int ataque) {
		if (Utils.validarAtaque(ataque, this) && Utils.validarAtributosVehiculos(ataque, this.getDefensa(), this)) {
			super.setAtaque(ataque);
		}
	}
	@Override
	public void setDefensa(int defensa) {
		if (Utils.validarDefensa(defensa, this) && Utils.validarAtributosVehiculos(this.getAtaque(), defensa, this)) {
			super.setDefensa(defensa);
		}
	}

	@Override
	public void embarcarGuerrero(Guerrero guerrero) {
		logger.debug("Entrando en el método embarcarGuerrero de Tanque.");
		if (guerrero instanceof TripulacionTanque && getGuerrerosEmbarcados().size() < 10) {
			getGuerrerosEmbarcados().add(guerrero);
		} else if (!(guerrero instanceof TripulacionTanque) && getGuerrerosEmbarcados().size() >= 10){
			String text = "El guerrero " + guerrero.getNombre() + " no cabe en el Tanque "
					+ "ni es tripulante capaz para el mismo.";
			logger.info(text);
		} else if (getGuerrerosEmbarcados().size() >= 10) {
			String text = "El guerrero " + guerrero.getNombre() + " no cabe en el Tanque.";
			logger.info(text);
		} else if (!(guerrero instanceof TripulacionTanque)) {
			String text = "El guerrero " + guerrero.getNombre() + " no es un tripulante capaz para el Tanque.";
			logger.info(text);
		} else {
			logger.debug("Opción no contemplada en método embarcarGuerrero() de Tanque.");
		}
	}
	

	@Override
	public void embarcarGuerreros(Guerrero[] guerreros) {
		logger.debug("Entrando en el método embarcarGuerreros.");
		for (Guerrero guerrero : guerreros) {
			embarcarGuerrero(guerrero);
		}
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
		logger.info("\n\t\tEl tanque ataca con un valor total de " + totalAtaque + ".");

		return totalAtaque;
	}
	
	public void recibirDany(int totalAtaque, int totalDefensa) {
		int dany = totalAtaque - totalDefensa;

		if (dany > 0) {
			logger.info("\n\t\tEl tanque ha recibido " + dany + " puntos de daño.");

			this.setPuntosVida(this.getPuntosVida() - dany);

			logger.info("\n\t\tEl total de puntos de vida es de " + getPuntosVida() + ".\n");
		} else {
			logger.info("\n\t\tEl ataque ha sido infructuoso.\n");
		}
	}
}
