package service;

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
}
