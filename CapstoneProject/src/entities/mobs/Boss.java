package entities.mobs;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * The Boss class represent a Boss enemy with the properties of enemy
 * @author nathangu
 *
 */
public class Boss extends Enemy{

	//private double shotFrequency;
	private int stageNum;
	/**
	 * Creates a new instance of Boss
	 * @param x X-coordinate
	 * @param y Y-coordinate
	 * @param w Width of the hitbox
	 * @param h Height of the hitbox
	 * @param circle If the hitbox is a circle
	 * @param image Image of the entity
	 * @param stageNum the stage # of the boss
	 */
	public Boss(double x, double y, double w, double h, boolean circle, PImage image, int stageNum) {
		super(x, y, w, h, circle);
		this.stageNum = stageNum;
		//shotFrequency = frequency;
	}
	
	/**Makes the boss shoot a "pattern" bullet
	 */
	public void shootPatternBullet() {
		
	}
	/**Sets up the boss with an image
	 * @param surface PApplet to setup with
	 */
	public void setup(PApplet surface) {
		
	}
//	/**
//	 * Allows the Boss to move
//	 */
//	public void move() {
//		act();
//	}
}
