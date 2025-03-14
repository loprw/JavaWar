package base.utilities;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import base.ArtilleroNaval;
import base.ArtilleroTerrestre;
import base.Conductor;
import base.Destructor;
import base.Piloto;
import base.Tanque;
import base.VehiculoGuerra;
import base.exceptions.AtaqueValidationException;
import base.exceptions.DefensaValidationException;
import base.exceptions.SumaAtributosValidationException;
import base.exceptions.TamanyArrayIncorrectoException;

public class Utilities {

	private static final Logger logger = LoggerFactory.getLogger(Utilities.class);

	public static VehiculoGuerra crearVehiculo1() {
		logger.info("Vamos a crear el Vehículo 1:");
		VehiculoGuerra vehiculo1 = null;

		try {
			vehiculo1 = new Tanque("Tiger", 3, 7);
		} catch (AtaqueValidationException ave) {
			logger.error(ave.getMessage());
		} catch (DefensaValidationException dve) {
			logger.error(dve.getMessage());
		} catch (SumaAtributosValidationException save) {
			logger.error(save.getMessage());
		}

		return vehiculo1;
	}

	public static VehiculoGuerra crearVehiculo2() {
		logger.info("Vamos a crear el Vehículo 2:");

		VehiculoGuerra vehiculo2 = null;

		try {
			vehiculo2 = new Destructor("Rocinante", 7, 3);
		} catch (AtaqueValidationException ave) {
			logger.error(ave.getMessage());
		} catch (DefensaValidationException dve) {
			logger.error(dve.getMessage());
		} catch (SumaAtributosValidationException save) {
			logger.error(save.getMessage());
		}

		return vehiculo2;
	}

	public static void enfrentamiento(VehiculoGuerra vehiculo1, VehiculoGuerra vehiculo2) {
		boolean vehiculoUnoDestruido = false;
		boolean vehiculoDosDestruido = false;
		int contador = 1;

		logger.info("Empieza la guerra:\n");

		while (!vehiculoUnoDestruido || !vehiculoDosDestruido) {

			logger.info("\tEmpieza el turno " + contador++ + " del enfrentamiento:");

			int ataque = vehiculo1.atacar();
			int defensa = vehiculo2.defender(ataque);
			vehiculo2.recibirDany(ataque, defensa);

			if (vehiculo2.getPuntosVida() <= 0) {
				vehiculoDosDestruido = true;
			}

			if (vehiculoDosDestruido) {
				logger.info("\n\t\t\tEl vehículo " + vehiculo2.getNombre() + " ha sido destruido.\n");
				break;
			}

			int ataque2 = vehiculo2.atacar();
			int defensa2 = vehiculo1.defender(ataque2);
			vehiculo1.recibirDany(ataque2, defensa2);

			if (vehiculo1.getPuntosVida() <= 0) {
				vehiculoUnoDestruido = true;
			}

			if (vehiculoUnoDestruido) {
				logger.info("\n\t\t\tEl vehículo " + vehiculo1.getNombre() + " ha sido destruido.\n");
				break;
			}
		}
	}

	public static void enfrentamiento(VehiculoGuerra[] arrayVehiculos) {
		if (arrayVehiculos.length == 2) {
			enfrentamiento(arrayVehiculos[0], arrayVehiculos[1]);
		} else {
			logger.info("Número de vehículos incorrecto: el juego está preparado para que se enfrenten 2 vehículos.");
		}
	}

	public static int pideDatoNumerico(String texto) {

		System.out.println(texto);
		Scanner scan = new Scanner(System.in);
		int numero = scan.nextInt();

		return numero;
	}

	public static String pideDatoCadena(String dato) {

		System.out.println(dato);
		Scanner scan = new Scanner(System.in);
		String texto = scan.nextLine();

		return texto;
	}

	public static void ejecutaMenu() {

		final int OPCION_SALIDA = 0;
		int opcion = -1;

		do {

			System.out.println("\t\t¡¡¡BIENVENIDO A JAVA WAR!!!");
			System.out
					.println("\nEscoge entre estas opciones.\n\t1. Partida rápida.\n\t2. Partida rápida con guerreros."
							+ "\n\t3. Partida personalizada completa.\n\n\t0 Salir.\n\n");
			opcion = Utilities.pideDatoNumerico("Indica el número de la opción que desees:");

			switch (opcion) {
			case 1 -> {
				VehiculoGuerra[] vehiculos = crearVehiculosDefecto();
				enfrentamiento(vehiculos);
			}
			case 2 -> {
				VehiculoGuerra[] vehiculos = crearVehiculosDefecto();
				try {
					logger.debug("Entrando en try para crear guerreros.");
					crearGuerrerosDefecto(vehiculos);
				} catch (TamanyArrayIncorrectoException taie) {
					logger.debug("Saliendo del try para crear guerreros por error");
					logger.error(taie.getMessage());
				}
				int valor = vehiculos[0].getGuerrerosEmbarcados().size();
				String cadena = String.valueOf(valor);
				logger.debug("Tamaño del listado de Guerreros de vehiculo1: " + cadena);
				int valor2 = vehiculos[1].getGuerrerosEmbarcados().size();
				String cadena2 = String.valueOf(valor2);
				logger.debug("Tamaño del listado de Guerreros de vehiculo2: " + cadena2);
				System.out.println(vehiculos[0]);
				System.out.println(vehiculos[1]);
				enfrentamiento(vehiculos);
			}
			case 3 -> {

			}
			case 0 -> System.out.println("¡Adiós!");
			default -> System.out.println("Has indicado una opción incorrecta.");
			}

		} while (opcion != OPCION_SALIDA);
	}

	// controlar que el array resultante sea 2.
	public static VehiculoGuerra[] crearVehiculosDefecto() {
		VehiculoGuerra vehiculo1 = crearVehiculo1();
		System.out.println(vehiculo1);
		VehiculoGuerra vehiculo2 = crearVehiculo2();
		System.out.println(vehiculo2);
		VehiculoGuerra[] vehiculos = { vehiculo1, vehiculo2 };

		return vehiculos;
	}

	// controlar que el array sea de tamaño 2
	public static void crearGuerrerosDefecto(VehiculoGuerra[] vehiculos) throws TamanyArrayIncorrectoException {

		logger.debug("Entrada en método crearGuerrerosDefecto");

		if (vehiculos.length != 2) {
			throw new TamanyArrayIncorrectoException();
		}

		int capacidad = 10;
		for (int i = 0; i < 2; i++) {
			int valor = 0;
			int contador = 1;

			do {
				if (vehiculos[i] instanceof Destructor) {
					Destructor destructor = (Destructor) vehiculos[i];
					int numAleatorio = ((int) (Math.random() * 2));
					if (numAleatorio == 0) {
						String nombre = "N".concat(String.valueOf(contador++));
						destructor.embarcarGuerrero(new Piloto(nombre));
						;
					} else {
						String nombre = "N".concat(String.valueOf(contador++));
						destructor.embarcarGuerrero(new ArtilleroNaval(nombre));
					}
				} else if (vehiculos[i] instanceof Tanque) {
					Tanque tanque = (Tanque) vehiculos[i];
					int numAleatorio = ((int) (Math.random() * 2));
					if (numAleatorio == 0) {
						String nombre = "N".concat(String.valueOf(contador++));
						tanque.embarcarGuerrero(new Conductor(nombre));
					} else {
						String nombre = "N".concat(String.valueOf(contador++));
						tanque.embarcarGuerrero(new ArtilleroTerrestre(nombre));
					}
				}
				valor = vehiculos[i].getGuerrerosEmbarcados().size();
			} while (valor < capacidad);
		}
	}
}
