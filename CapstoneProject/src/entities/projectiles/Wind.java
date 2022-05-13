package entities.projectiles;

import entities.mobs.Player;
import processing.core.PApplet;
import processing.core.PImage;


/**
 * this class represents wind, which pushes a player back. 
 * @author Johnny Zhang
 *
 */
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
	public Wind(double x, double y, double w, double h, double vx, double vy, boolean circle, double dmg) {
		super(x, y, w, h, vx, vy, circle, false, dmg);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Pushes the player back 
	 * @param player The Player
	 */
	public void interact(Player player) {
		player.setvy(player.getvy() - 10);
	}
	
	/**
	 * sets up the image
	 * @param PApplet the drawing surface
	 */
	public void setup(PApplet surface) {
		PImage temp;
		System.out.println("loaded image");
		temp = (surface.loadImage("sprites/projectile-wind.png"));
		temp.resize((int)getWidth(), (int)getHeight());
		setSprite(temp);
	}
	
}
