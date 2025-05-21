package dto;

public class GuerreroDTO {
	
	private Long id;
	private String nombre;
	private int fuerza;
	private int resistencia;
	private String tipo;
	
	public GuerreroDTO(Long id, String nombre, int fuerza, int resistencia, String tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fuerza = fuerza;
		this.resistencia = resistencia;
		this.tipo = tipo;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
