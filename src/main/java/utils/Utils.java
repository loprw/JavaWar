package utils;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	
	public static void endSession() {
	
		scan.close();
		session.close();
	}
}
