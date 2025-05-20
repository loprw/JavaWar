package base.bins.vehiculoguerra;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import base.bins.guerrero.Guerrero;
import base.exceptions.AtaqueValidationException;
import base.exceptions.DefensaValidationException;
import base.exceptions.SumaAtributosValidationException;
import base.interfaces.Tripulable;

public abstract class VehiculoGuerra implements Tripulable {

	private String nombre;
	private int puntosVida;
	private int ataque;
	private int defensa;
	private String tipo;
	private List<Guerrero> guerrerosEmbarcados;
	private static final Logger logger = LoggerFactory.getLogger(VehiculoGuerra.class);

	public VehiculoGuerra(String nombre, int ataque, int defensa)
			throws AtaqueValidationException, DefensaValidationException, SumaAtributosValidationException {

		this.nombre = nombre;
		this.puntosVida = 1_000;
		this.ataque = 5;
		validarAtaque(ataque);
		this.defensa = 5;
		validarDefensa(defensa);
		validarAtaqueYDefensa(ataque, defensa);
		this.guerrerosEmbarcados = new ArrayList<Guerrero>();

	}
	
	public VehiculoGuerra(String nombre) {
		this.nombre = nombre;
		this.puntosVida = 1_000;
		this.ataque = 5;
		this.defensa = 5;
		this.guerrerosEmbarcados = new ArrayList<Guerrero>();
	}

	public String getNombre() {
		return nombre;
	}

	public int getPuntosVida() {
		return puntosVida;
	}

	public int getAtaque() {
		return ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public String getTipo() {
		return tipo;
	}
	
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VehiculoGuerra: \n\tNombre = ");
		builder.append(nombre);
		builder.append("\n\tPuntos Vida = ");
		builder.append(puntosVida);
		builder.append("\n\tTipo = ");
		builder.append(tipo);
		builder.append("\n\tAtaque = ");
		builder.append(ataque);
		builder.append("\n\tDefensa = ");
		builder.append(defensa);
		builder.append("\n\tGuerreros Embarcados : \n");
		builder.append(guerrerosEmbarcados);
		builder.append(".");
		return builder.toString();
	}

	public List<Guerrero> getGuerrerosEmbarcados() {
		return guerrerosEmbarcados;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPuntosVida(int puntosVida) {
		this.puntosVida = puntosVida;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setGuerrerosEmbarcados(List<Guerrero> guerrerosEmbarcados) {
		this.guerrerosEmbarcados = guerrerosEmbarcados;
	}

	public abstract void recibirDany(int totalAtaque, int totalDefensa);

	private int validarAtaque(int ataque) throws AtaqueValidationException {
		logger.debug("Validando que el valor de Ataque esté entre 0 y 10.");
		if (ataque < 0 || ataque > 10) {
			throw new AtaqueValidationException();
		}

		return ataque;
	}

	private int validarDefensa(int defensa) throws DefensaValidationException {
		logger.debug("Validando que el valor de Defensa esté entre 0 y 10.");
		if (defensa < 0 || defensa > 10) {
			throw new DefensaValidationException();
		}
		return defensa;
	}

	private void validarAtaqueYDefensa(int ataque, int defensa) throws SumaAtributosValidationException {
		logger.debug("Validando que los valores de Ataque y Defensa no sumen más de 10.");
		if ((ataque + defensa) > 10) {
			this.ataque = 5;
			this.defensa = 5;
			throw new SumaAtributosValidationException();
		}
	}
}
