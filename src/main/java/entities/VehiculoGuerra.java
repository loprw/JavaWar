package entities;

import java.util.ArrayList;
import java.util.List;

import interfaces.Tripulable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_VEHICULO_GUERRA")
public abstract class VehiculoGuerra implements Tripulable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private int puntosVida;
	private int ataque;
	private int defensa;
	private String tipo;
	@OneToMany(mappedBy = "vehiculoAsignado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Guerrero> guerrerosEmbarcados = new ArrayList<Guerrero>();
	
	public VehiculoGuerra() {
		
	}
	
	protected VehiculoGuerra(String nombre, int ataque, int defensa) {

		this.nombre = nombre;
		this.puntosVida = 1_000;
		this.ataque = ataque;
		this.defensa = defensa;

	}
	
	protected VehiculoGuerra(String nombre, int vida, int ataque, int defensa, List<Guerrero> listado) {

		this.nombre = nombre;
		this.puntosVida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.guerrerosEmbarcados = listado;

	}
	
	protected VehiculoGuerra(String nombre) {
		this.nombre = nombre;
		this.puntosVida = 1_000;
		this.ataque = 5;
		this.defensa = 5;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntosVida() {
		return puntosVida;
	}
	
	public void setPuntosVida(int puntosVida) {
		this.puntosVida = puntosVida;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Guerrero> getGuerrerosEmbarcados() {
		return guerrerosEmbarcados;
	}

	public void setGuerrerosEmbarcados(List<Guerrero> guerrerosEmbarcados) {
		this.guerrerosEmbarcados = guerrerosEmbarcados;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VehiculoGuerra [id=");
		builder.append(id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", puntosVida=");
		builder.append(puntosVida);
		builder.append(", ataque=");
		builder.append(ataque);
		builder.append(", defensa=");
		builder.append(defensa);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append(", guerrerosEmbarcados=");
		builder.append(guerrerosEmbarcados);
		builder.append("]");
		return builder.toString();
	}
}
