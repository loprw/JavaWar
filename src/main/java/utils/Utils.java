package utils;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.Guerrero;
import entities.VehiculoGuerra;

public class Utils {
	
	private static Session session;
	private static final Logger logger = LoggerFactory.getLogger(Utils.class);
	private static Scanner scan;
	
	private static Session generateSession() {
		
		try {
			SessionFactory sessionFactory = new Configuration()
					.configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
		} catch (Throwable e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw new ExceptionInInitializerError("Error al inicializar SessionFactory: " + e);
		}
		
		return session;
	}
	
	public static Session getSession() {
		
		if (session == null) {
			session = generateSession();
		}
		
		return session;
	}
	
	public static int writeNumber(String message) {
		
		System.out.println(message);
		scan = new Scanner(System.in);
		int number = scan.nextInt();
		
		return number;
	}
	
	public static String writeText(String message) {
		
		System.out.println(message);
		scan = new Scanner(System.in);
		String  text = scan.nextLine();
		
		return text;
	}
	
	public static void menu(String text) {
		
	}
	
	public static boolean validarAtaque(int atributoOfensivo, VehiculoGuerra vehiculo) {		
		logger.debug("Validando que el valor de Ataque esté entre 0 y 10.");
		if (atributoOfensivo < 0 || atributoOfensivo > 10) {
			logger.info("Valor de Ataque incorrecto, se inicializa en 5.");
			vehiculo.setAtaque(5);
			return false;
		}
		
		return true;
	}
	
	public static boolean validarDefensa(int atributoDefensivo, VehiculoGuerra vehiculo) { 
		logger.debug("Validando que el valor de Defensa esté entre 0 y 10.");
		if (atributoDefensivo < 0 || atributoDefensivo > 10) {
			logger.info("Valor de Defensa incorrecto, se inicializa en 5.");
			vehiculo.setDefensa(5);
			return false;
		}
		return true;
	}
	
	public static boolean validarAtributosVehiculos(int atributoOfensivo, int atributoDefensivo, VehiculoGuerra vehiculo) {
		logger.debug("Validando que los valores de Ataque y Defensa no sumen más de 10.");
		if ((atributoOfensivo + atributoDefensivo) > 10) {
			logger.info("Suma de valores de Ataque más Defensa incorrecta. Se inicializan en 5.");
			vehiculo.setAtaque(5);
			vehiculo.setDefensa(5);
			return false;
		}
		
		return true;
	}
	
	public static boolean validarFuerza(int atributoOfensivo, Guerrero guerrero) {		
		logger.debug("Validando que el valor de Ataque esté entre 0 y 10.");
		if (atributoOfensivo < 0 || atributoOfensivo > 10) {
			logger.info("Valor de Ataque incorrecto, se inicializa en 5.");
			guerrero.setFuerza(5);
			return false;
		}
		
		return true;
	}
	
	public static boolean validarResistencia(int atributoDefensivo, Guerrero guerrero) { 
		logger.debug("Validando que el valor de Defensa esté entre 0 y 10.");
		if (atributoDefensivo < 0 || atributoDefensivo > 10) {
			logger.info("Valor de Defensa incorrecto, se inicializa en 5.");
			guerrero.setResistencia(5);
			return false;
		}
		return true;
	}
	
	public static boolean validarAtributosGuerrero(int atributoOfensivo, int atributoDefensivo, Guerrero guerrero) {
		logger.debug("Validando que los valores de Ataque y Defensa no sumen más de 10.");
		if ((atributoOfensivo + atributoDefensivo) > 10) {
			logger.info("Suma de valores de Ataque más Defensa incorrecta. Se inicializan en 5.");
			guerrero.setFuerza(5);
			guerrero.setResistencia(5);
			return false;
		}
		
		return true;
	}
	
	public static void endSession() {
	
		scan.close();
		session.close();
	}
}
