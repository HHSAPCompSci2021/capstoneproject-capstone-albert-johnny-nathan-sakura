package entities.projectiles;

import entities.Entity;
import entities.mobs.Player;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * this class represents a coin, which can be picked up.
 * @author Johnny Zhang
 *
 */
public class Coin extends Entity {
	int value;
	PImage img;
	/**
	 * Creates a new instance of Coin with the properties of Entity
	 * @param x X-Coordinate
	 * @param y Y-Coordinate
	 * @param w Width of hitbox
	 * @param h Height of hitbox
	 * @param circle If the hitbox is a circle
	 * @param image Image of the player sprite
	 */
	public Coin(double x, double y, double w, double h, boolean circle) {
		super(x, y, w, h, circle);
		value = 5;
	}
	
	/**
	 * Adds the coins to the player
	 * @param e The player
	 */
	public void interact(Player e) {
		e.addCoins(value);
		die();
	}
	
	/**
	 * sets up the image for the coin
	 * @param surface the drawing surface
	 */
	public void setup(PApplet surface) {
		PImage temp;
		System.out.println("loaded image");
		temp = (surface.loadImage("sprites/entity-coin.png"));
		temp.resize((int)getWidth(), (int)getHeight());
		setSprite(temp);
	}
	
}
