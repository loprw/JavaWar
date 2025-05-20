package interfaces;

import entities.Guerrero;

public interface Tripulable extends Atacar, Defender {

	void embarcarGuerrero(Guerrero guerrero);
	
	void embarcarGuerreros(Guerrero[] guerreros);
}
