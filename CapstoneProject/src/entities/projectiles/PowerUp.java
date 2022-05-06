package entities.projectiles;

import entities.Entity;
import entities.mobs.Player;
import processing.core.PImage;

public class PowerUp extends Entity {
	//1 = heal, 2 = multi, 3 = pierce, 4 = rate, 5 = dmg, 6 = hp
	int time;
	int type;
	public PowerUp(double x, double y, double w, double h, int type, boolean circle, PImage image) {
		super(x, y, w, h, circle, image);
		this.type = type;
	}
	
	public void act(Player e) {
		e.setPowerUpDuration(time);
		e.setPowerUpType(type);
	}

}
