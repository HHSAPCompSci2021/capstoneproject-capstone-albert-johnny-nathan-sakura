package entities.projectiles;

import entities.Entity;
import entities.mobs.Player;
import processing.core.PImage;

/**
 * This is a trap, which can be deployed by players.
 * @author Johnny Zhang
 *
 */
public class Trap extends Bullet {
	//1 = hurt, 2 = slow, 3 = subtractCoins
	private boolean available, cost;
	private int type;
	
	/**
	 * Creates a new instance of Trap with the properties of Entity
	 * @param x X-Coordinate
	 * @param y Y-Coordinate
	 * @param w Width of hitbox
	 * @param h Height of hitbox
	 * @param circle If the hitbox is a circle
	 * @param image Image of the player sprite
	 */
	public Trap(double x, double y, double w, double h, double vx, double vy, int type, boolean circle, double dmg,
			PImage image) {
		super(x, y, w, h, vx, vy, circle, dmg, image);
		this.type = type;
	}
	
	/**
	 * Determines the type of trap and applies the effects on the specified Player
	 * @param player
	 */
	public void act(Player player) {
		if (type == 1) {
			player.setHp(player.getHp()-getDmg());
		}
		if (type == 2) {
			player.setvx(0);
			player.setvy(0);
		}
		if (type == 3) {
			player.addCoins(-10);
		}
	}
}
