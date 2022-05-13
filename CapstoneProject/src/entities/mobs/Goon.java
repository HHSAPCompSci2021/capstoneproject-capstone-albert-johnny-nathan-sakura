package entities.mobs;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * The class Goon class represents an Enemy
 */
public class Goon extends Enemy{
	private double shotFrequency;
	private int moviewoovie;
	private boolean flag;
	/**
	 * Creates a new instance of Goon
	 * @param x X-coordinate
	 * @param y Y-coordinate
	 * @param w Width of the hitbox
	 * @param h Height of the hitbox
	 * @param circle If the hitbox is a circle
	 * @param image Image of the entity
	 */
	public Goon(double x, double y, double w, double h, boolean circle, double frequency) {
		super(x, y, w, h, circle);
		shotFrequency = frequency;
		moviewoovie = 15;
		setHp(1);
	}
	
	/**
	 * Shoots Bullets
	 */
	public void shootBullet() {
		shoot();
	}
	
//	/**
//	 * Removes the bullets out of the window
//	 */
//	public void removeOutBullets() {
//		
//	}
	
	/**
	 * Allows the Goon to move and shoot
	 */
	public void act() {
		if(0<= moviewoovie && moviewoovie >= 15 && flag) {
			setX(getX() + getvx());
		}
		
		if(0 >= moviewoovie && moviewoovie > -15 && flag) {
			setX(getY() - getvy());
		}
		
		if(0<= moviewoovie && moviewoovie >= 15 && !flag) {
			setX(getX() - getvx());
		}
		
		if(0 >= moviewoovie && moviewoovie > -15 && !flag) {
			setX(getY() + getvy());
		}
		
		
		shootBullet();
		//act();
	}
	
	public void setup(PApplet surface) {
		PImage temp;
		System.out.println("loaded image");
		temp = (surface.loadImage("sprites/stage1-1.png"));
		temp.resize((int)getWidth(), (int)getHeight());
		setSprite(temp);
		if (moviewoovie <= -15) {
			moviewoovie = 15;
			flag = !flag;
		}
	}

	
}
