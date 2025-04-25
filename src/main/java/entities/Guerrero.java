package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_GUERRERO")
public abstract class Guerrero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String tipo;
	private int fuerza;
	private int resistencia;
	@ManyToOne
	@JoinColumn(name = "PK_VEHICULO_GUERRA")
	private VehiculoGuerra vehiculoAsignado;
	
	public Guerrero() {
		
	}
	
	public Guerrero(String nombre, int fuerza, int resistencia) {

		this.nombre = nombre;
		this.fuerza = fuerza;
		this.resistencia = resistencia;
	}

	public Guerrero(String nombre) {
		this.nombre = nombre;
		this.fuerza = 5;
		this.resistencia = 5;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Guerrero [id=");
		builder.append(id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append(", fuerza=");
		builder.append(fuerza);
		builder.append(", resistencia=");
		builder.append(resistencia);
		builder.append("]");
		return builder.toString();
	}
}
