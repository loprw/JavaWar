

public abstract class Guerrero {
	
	private String nombre;
	private String tipo;
	private int fuerza;
	private int resistencia;
	
	public Guerrero(String nombre, String tipo, int fuerza, int resistencia) {
		
		this.nombre = nombre;
		this.tipo = tipo;
		
		if (fuerza < 0) {
			System.out.println("El valor de Fuerza es inválido, se aumenta a 5.");
			this.fuerza = 5;
		}
		
		if (resistencia < 0) {
			System.out.println("El valor de Resistencia es inválido, se aumenta a 5.");
			this.resistencia = 5;
		}
		
		if ((fuerza + resistencia) > 10) {
			System.out.println("Los valores de Fuerza y Resistencia suman más de 10. Se inician en 5 cada uno.");
			this.fuerza = 5;
			this.resistencia = 5;
		} else {
			System.out.println("Se inicia el valor de Ataque en " + fuerza + " y el valor de Defena en " + resistencia + ".");
			this.fuerza = fuerza;
			this.resistencia = resistencia;
		}
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

	
}
