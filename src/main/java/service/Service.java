package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.GuerreroDAOImpl;
import dao.VehiculoGuerraDAOImpl;
import data.ArtilleroNaval;
import data.ArtilleroTerrestre;
import data.Conductor;
import data.Destructor;
import data.Piloto;
import data.Tanque;
import dto.GuerreroDTO;
import dto.VehiculoGuerraDTO;
import entities.Guerrero;
import entities.VehiculoGuerra;
import interfaces.GuerreroDAO;
import interfaces.VehiculoGuerraDAO;

public class Service {
	
	private static final Logger logger = LoggerFactory.getLogger(Service.class);
	private VehiculoGuerraDAO vhdao = new VehiculoGuerraDAOImpl();
	private GuerreroDAO gdao = new GuerreroDAOImpl();
	private GuerreroDTO guerrDto;
	private VehiculoGuerraDTO vehDto;
	
	public VehiculoGuerraDTO convertVehculoGuerraEntityToDto(VehiculoGuerra veh) {
		vehDto = new VehiculoGuerraDTO(veh.getId(), veh.getNombre(), veh.getPuntosVida(), veh.getAtaque(),
					veh.getDefensa(), veh.getTipo(), veh.getGuerrerosEmbarcados());

		return vehDto;
	}
	
	public VehiculoGuerraDTO convertGuerreroEntityToDto(Guerrero guerrero) {
		guerrDto = new GuerreroDTO(guerrero.getId(), guerrero.getNombre(), guerrero.getFuerza(),
				guerrero.getResistencia(), guerrero.getTipo());

		return vehDto;
	}
	
	public VehiculoGuerra convertVehiculoGuerraDtoToEntity(VehiculoGuerraDTO dto) {
		
		VehiculoGuerra vehiculo = null;
		
		if (dto.getTipo().equals("Destructor")) {
			vehiculo = new Destructor(dto.getNombre(), dto.getPuntosVida(), dto.getAtaque(), dto.getDefensa(), dto.getGuerrerosEmbarcados());
		} else if (dto.getTipo().equals("Taque")) {
			vehiculo = new Tanque(dto.getNombre(), dto.getPuntosVida(), dto.getAtaque(), dto.getDefensa(), dto.getGuerrerosEmbarcados());
		}
		
		return vehiculo;
	}
	
	public Guerrero convertGuerreroDtoToEntity(GuerreroDTO dto) {
		
		Guerrero guerrero = null;
		
		if (dto.getTipo().equals("Artillero Naval") || dto.getTipo().equals("Piloto")) {
			if (dto.getTipo().equals("Artillero Naval")) {
				guerrero = new ArtilleroNaval(dto.getNombre(), dto.getFuerza(), dto.getResistencia());
			} else if (dto.getTipo().equals("Piloto")) {
				guerrero = new Piloto(dto.getNombre(), dto.getFuerza(), dto.getResistencia());
			}
		} else if (dto.getTipo().equals("Artillero Terrestre") || dto.getTipo().equals("Conductor")) {
			if (dto.getTipo().equals("Artillero Terrestre")) {
				guerrero = new ArtilleroTerrestre(dto.getNombre(), dto.getFuerza(), dto.getResistencia());
			} else if (dto.getTipo().equals("Conductor")) {
				guerrero = new Conductor(dto.getNombre(), dto.getFuerza(), dto.getResistencia());
			}
		}
		
		return guerrero;
	}
	
	void insertVehiculo(VehiculoGuerraDTO dto) {
		
		vhdao.insertVehiculoGuerra(convertVehiculoGuerraDtoToEntity(dto));
	}
	
	public void enfrentamiento(VehiculoGuerraDTO vehiculo1, VehiculoGuerraDTO vehiculo2) {
		VehiculoGuerra vh1 = convertVehiculoGuerraDtoToEntity(vehiculo1);
		VehiculoGuerra vh2 = convertVehiculoGuerraDtoToEntity(vehiculo2);
		boolean vehiculoUnoDestruido = false;
		boolean vehiculoDosDestruido = false;
		int contador = 1;

		logger.info("Empieza la guerra:\n");

		while (!vehiculoUnoDestruido || !vehiculoDosDestruido) {

			logger.info("\tEmpieza el turno " + contador++ + " del enfrentamiento:");

			int ataque = vh1.atacar();
			int defensa = vh2.defender(ataque);
			vh2.recibirDany(ataque, defensa);

			if (vh2.getPuntosVida() <= 0) {
				vehiculoDosDestruido = true;
			}

			if (vehiculoDosDestruido) {
				logger.info("\n\t\t\tEl vehículo " + vh2.getNombre() + " ha sido destruido.\n");
				break;
			}

			int ataque2 = vh2.atacar();
			int defensa2 = vh1.defender(ataque2);
			vh1.recibirDany(ataque2, defensa2);

			if (vh1.getPuntosVida() <= 0) {
				vehiculoUnoDestruido = true;
			}

			if (vehiculoUnoDestruido) {
				logger.info("\n\t\t\tEl vehículo " + vh1.getNombre() + " ha sido destruido.\n");
				break;
			}
		}
	}
	
	//Queremos hacerlo aquí? Hay que hacer un método para grabarlo en base de datos, pero hay que pensar donde y como
	void embarqueGuerrero() {
		
	}
}
