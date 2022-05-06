package entities.projectiles;

import entities.mobs.Player;
import processing.core.PImage;

public class Wind extends Projectile {
	/**
	 * Creates a new instance of Wind with the properties of Entity
	 * @param x X-Coordinate
	 * @param y Y-Coordinate
	 * @param w Width of hitbox
	 * @param h Height of hitbox
	 * @param circle If the hitbox is a circle
	 * @param image Image of the player sprite
	 */
	public Wind(double x, double y, double w, double h, double vx, double vy, boolean circle, double dmg,
			PImage image) {
		super(x, y, w, h, vx, vy, circle, dmg, image);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Pushes the player back 
	 * @param player The Player
	 */
	public void act(Player player) {
		player.setvy(player.getvy() - 10);
	}
	
}
