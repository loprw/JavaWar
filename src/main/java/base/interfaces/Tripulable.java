package base.interfaces;

import base.bins.guerrero.Guerrero;

public interface Tripulable extends Atacar, Defender {

	void embarcarGuerrero(Guerrero guerrero);
	
	void embarcarGuerreros(Guerrero[] guerreros);
}
