package entities.mobs;

import java.util.ArrayList;

import entities.Entity;
import entities.projectiles.Bullet;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * The class Goon class represents an Enemy
 */
public class Goon extends Enemy{
	//private double shotFrequency;
	private int moviewoovie;
	private boolean flag;
	private int stageNum;
	private int goonNum;
	
	/**
	 * Creates a new instance of Goon
	 * @param x X-coordinate
	 * @param y Y-coordinate
	 * @param w Width of the hitbox
	 * @param h Height of the hitbox
	 * @param circle If the hitbox is a circle
	 * @param stageNum The stage number
	 * @param goonNum The Goon number
	 */
	public Goon(double x, double y, double w, double h, boolean circle, int stageNum, int goonNum) {
		super(x, y, w, h, circle);
		this.goonNum = goonNum;
		this.stageNum = stageNum;
		setvx(10);
		setvy(10);
		flag = true;
		//shotFrequency = frequency;
		moviewoovie = 10;
		setHp(100);
	}
	
	
	
	/**
	 * Shoots Bullets
	 */
	public void shoot() {
		Bullet b = new Bullet(getX(), getY(), 30, 30, 0, -15, true, false, 5);
		//getDaList().add(b);
	}
	
	
	/**
	 * Allows the Goon to move and shoot
	 */
	public void act() {
//		super.act();
		
//		setHp(0);
		if(0<= moviewoovie && moviewoovie <= 10 && flag) {
			setX(getX() + getvx());
			shoot();
			moviewoovie--;
		}
		
		if(0 >= moviewoovie && moviewoovie > -10 && flag) {
			setY(getY() + getvy());
			shoot();
			moviewoovie--;
			if(moviewoovie <= -10) {
				flag = false;
				moviewoovie = 10;
				
			}
		}
		
		if(0<= moviewoovie && moviewoovie <= 10 && !flag) {
			setX(getX() - getvx());
			shoot();
			moviewoovie--;
		}
		
		if(0 >= moviewoovie && moviewoovie > -10 && !flag) {
			setY(getY() - getvy());
			shoot();
			moviewoovie--;
			if(moviewoovie <= -10) {
				flag = true;
				moviewoovie = 10;
			}
		}	
	}
	
	
	/**
	 * Sets up the image for the Goon
	 * @param surface the drawing surface
	 */
	public void setup(PApplet surface) {
		PImage temp;
		System.out.println("loaded image");
		temp = (surface.loadImage("sprites/stage" + stageNum + "-" + goonNum+".png"));
		temp.resize((int)getWidth(), (int)getHeight());
		setSprite(temp);
		if (moviewoovie <= -10) {
			moviewoovie = 10;
			flag = !flag;
		}
	}

	
}
