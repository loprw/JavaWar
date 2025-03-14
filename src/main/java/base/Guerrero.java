package base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import base.exceptions.FuerzaValidationException;
import base.exceptions.ResistenciaValidationException;
import base.exceptions.SumaAtributosValidationException;

public abstract class Guerrero {

	private String nombre;
	private String tipo;
	private int fuerza;
	private int resistencia;
	private static final Logger logger = LoggerFactory.getLogger(Guerrero.class);

	public Guerrero(String nombre, int fuerza, int resistencia)
			throws FuerzaValidationException, ResistenciaValidationException, SumaAtributosValidationException {

		this.nombre = nombre;
		this.fuerza = 5;
		validarFuerza(fuerza);
		this.resistencia = 5;
		validarResistencia(resistencia);
		validarFuerzaYResistencia(fuerza, resistencia);
	}

	public Guerrero(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public int getFuerza() {
		return fuerza;
	}

	public int getResistencia() {
		return resistencia;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	protected void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
	
	protected void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\t\tGuerrero: \n\t\t\tNombre = ");
		builder.append(nombre);
		builder.append("\n\t\t\tTipo = ");
		builder.append(tipo);
		builder.append("\n\t\t\tFuerza = ");
		builder.append(fuerza);
		builder.append("\n\t\t\tResistencia = ");
		builder.append(resistencia);
		builder.append("\n");
		return builder.toString();
	}

	private int validarFuerza(int fuerza) throws FuerzaValidationException {
		logger.debug("Validando que el valor de Fuerza esté entre 0 y 10.");
		if (fuerza < 0 || fuerza > 10) {
			throw new FuerzaValidationException();
		}

		return fuerza;
	}

	private int validarResistencia(int resistencia) throws ResistenciaValidationException {
		logger.debug("Validando que el valor de Resistencia esté entre 0 y 10.");
		if (resistencia < 0 || resistencia > 10) {
			throw new ResistenciaValidationException();
		}
		return resistencia;
	}
	
	private void validarFuerzaYResistencia(int fuerza, int resistencia) throws SumaAtributosValidationException {
		logger.debug("Validando que los valores de Fuerza y Resistencia no sumen más de 10.");
		if ((fuerza + resistencia) > 10) {
			this.fuerza= 5;
			this.resistencia = 5;
			throw new SumaAtributosValidationException();
		}
	}
}
