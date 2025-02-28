

import java.util.Scanner;

public class Guerra {

	public static void main(String[] args) {

		VehiculoGuerra vehiculo1 = crearVehiculo1();
		VehiculoGuerra vehiculo2 = crearVehiculo2();
		
		enfrentamiento(vehiculo1, vehiculo2);
	}
	
	public static VehiculoGuerra crearVehiculo1( ) {
		System.out.println("Vamos a crear el Vehículo 1:");
		
		VehiculoGuerra vehiculo1 = new Tanque("Tiger", 3, 7);
		
		return vehiculo1;
	}
	
	public static VehiculoGuerra crearVehiculo2( ) {
		System.out.println("Vamos a crear el Vehículo 1:");
		
		VehiculoGuerra vehiculo2 = new Destructor("Rocinante", 7, 3);
		
		return vehiculo2;
	}

	public static void enfrentamiento(VehiculoGuerra vehiculo1, VehiculoGuerra vehiculo2) {
		boolean vehiculoUnoDestruido = false;
		boolean vehiculoDosDestruido = false;
		int contador = 1;
		
		System.out.println("Empieza la guerra:\n");
		
		while (!vehiculoUnoDestruido || !vehiculoDosDestruido) {

			System.out.println("\tEmpieza el turno " + contador++ + " del enfrentamiento:");
			
			int ataque = vehiculo1.atacar();
			int defensa = vehiculo2.defender(ataque);
			vehiculo2.recibirDany(ataque, defensa);
			
			if (vehiculo2.getPuntosVida() <= 0) {
				vehiculoDosDestruido = true;
			}
			
			if (vehiculoDosDestruido) {
				System.out.println("\n\t\t\tEl vehículo " + vehiculo1.getNombre() + " ha sido destruido");
				break;
			}
			
			int ataque2 = vehiculo2.atacar();
			int defensa2 = vehiculo1.defender(ataque2);
			vehiculo1.recibirDany(ataque2, defensa2);
			
			if (vehiculo1.getPuntosVida() <= 0) {
				vehiculoUnoDestruido = true;
			}
			
			if (vehiculoUnoDestruido) {
				System.out.println("\n\t\t\tEl vehículo " + vehiculo2.getNombre() + " ha sido destruido");
				break;
			}
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

}
