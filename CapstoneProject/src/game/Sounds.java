package game;

import processing.core.PApplet;
import jay.jaysound.*;
public class Sounds {
	//jay.jaysound classes
	//JayLayer and JayLayerListener
	//Player.java in jj.player
	private JayLayer j;
	public Sounds() {
		j = new JayLayer(true);
		j.addPlayList();
		j.addSong(0, "songs/s.mp3");
		j.addSoundEffect("soundeffect.mp3");
	}
	
	
	public void playEffect(int i) {
		
	}
	
}
