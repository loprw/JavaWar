

import java.util.List;

public abstract class VehiculoGuerra implements Tripulable {

	private String nombre;
	private int puntosVida;
	private int ataque;
	private int defensa;
	private String tipo;
	private List<Guerrero> guerrerosEmbarcados;
	
	public VehiculoGuerra (String nombre, int ataque, int defensa) {
		
		this.nombre = nombre;
		this.puntosVida = 50;
		
		
		if (ataque < 0) {
			System.out.println("El valor de Ataque es inválido, se aumenta a 5.");
			this.ataque = 5;
		}
		
		if (defensa < 0 ) {
			System.out.println("El valor de Defensa es inválido, se aumenta a 5.");
			this.defensa = 5;
		}
		
		if ((ataque + defensa) > 10) {
			System.out.println("Los valores de Ataque y Defensa suman más de 10. Se inician en 5 cada uno.");
			this.ataque = 5;
			this.defensa = 5;
		} else {
			System.out.println("Se inicia el valor de Ataque en " + ataque + " y el valor de Defena en " + defensa + ".");
			this.ataque = ataque;
			this.defensa = defensa;
		}
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
}
