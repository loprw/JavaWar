package base.interfaces;

import java.util.List;

import base.Guerrero;

public interface Tripulable extends Atacar, Defender {

	void embarcarGuerrero(Guerrero guerrero);
	
	void embarcarGuerreros(Guerrero[] guerreros);
}
