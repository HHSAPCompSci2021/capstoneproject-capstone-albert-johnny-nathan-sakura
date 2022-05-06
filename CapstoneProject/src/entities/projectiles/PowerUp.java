package entities.projectiles;

import entities.Entity;
import entities.mobs.Player;
import processing.core.PImage;

public class PowerUp extends Entity {
	//1 = heal, 2 = multi, 3 = pierce, 4 = rate, 5 = dmg, 6 = hp
	int time;
	int type;
	/**
	 * Creates a new instance of PowerUp with the properties of Entity
	 * @param x X-Coordinate
	 * @param y Y-Coordinate
	 * @param w Width of hitbox
	 * @param h Height of hitbox
	 * @param circle If the hitbox is a circle
	 * @param image Image of the player sprite
	 */
	public PowerUp(double x, double y, double w, double h, int type, boolean circle, PImage image) {
		super(x, y, w, h, circle, image);
		this.type = type;
	}
	
	/**
	 * Gives the PowerUp to the player
	 * @param e
	 */
	public void act(Player e) {
		e.setPowerUpDuration(time);
		e.setPowerUpType(type);
	}

}
