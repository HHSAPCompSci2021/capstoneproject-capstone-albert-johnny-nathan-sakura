package entities.mobs;

import entities.projectiles.Bullet;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * The Boss class represent a Boss enemy with the properties of Enemy
 * @author nathangu
 */
public class Boss extends Enemy{

	private int stageNum;
	/**
	 * Creates a new instance of Boss
	 * @param x X-coordinate
	 * @param y Y-coordinate
	 * @param w Width of the hitbox
	 * @param h Height of the hitbox
	 * @param circle If the hitbox is a circle
	 * @param stageNum the stage # of the boss
	 */
	public Boss(double x, double y, double w, double h, boolean circle, int stageNum) {
		super(x, y, w, h, circle);
		this.stageNum = stageNum;
		setHp(1000);
		//shotFrequency = frequency;
	}
	
	/**
	 * Makes the boss shoot a "pattern" bullet
	 */
	public void shootPatternBullet() {
		Bullet b = new Bullet(getX(), getY(), 30, 30, 0, 15, true, false, 10);
		getDaList().add(b);
	}
	/**Sets up the boss with an image
	 * @param surface PApplet to setup with
	 */
	public void setup(PApplet surface) {
		PImage temp;
		System.out.println("loaded image");
		temp = (surface.loadImage("sprites/stage1-3.png"));
		temp.resize((int)getWidth(), (int)getHeight());
		setSprite(temp);
	}
//	/**
//	 * Allows the Boss to move
//	 */
//	public void move() {
//		act();
//	}
}
