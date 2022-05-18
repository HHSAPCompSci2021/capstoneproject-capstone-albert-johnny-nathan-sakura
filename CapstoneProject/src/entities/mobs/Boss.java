package entities.mobs;

import java.util.ArrayList;

import entities.Entity;
import entities.projectiles.Bullet;
import entities.projectiles.PatternBullet;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * The Boss class represent a Boss enemy with the properties of Enemy
 * @author nathangu
 */
public class Boss extends Enemy{

	private int stageNum;
	private PApplet surface;
	private double[][] movement;
	private int curInd;
	private int frames;
	private int counter;
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
		setHp(100000);
		frames = 0;
		movement = new double[4][2];
		if (stageNum == 1) {
			movement[0][0] = -50;
			movement[0][1] = 1;
			movement[3][0] = 50;
			movement[3][1] = -1;
		}
		if (stageNum == 2) {
			movement[0][0] = -10;		
			movement[0][1] = 8 ;		
			movement[1][0] = 10;		
			movement[1][1] = 8;		
			movement[2][0] = 10;
			movement[2][1] = -8;
			movement[3][0] = -10;
			movement[3][1] = -8;	
		}
		if (stageNum == 3) {
			movement[0][0] = 13;
			movement[0][1] = -7;
			movement[1][0] = -13;
			movement[1][1] = -7;
			movement[2][0] = -13;
			movement[2][1] = 7;
			movement[3][0] = 13;
			movement[3][1] = 7;
		}
		
		
	}
	
	/**
	 * Makes the boss shoot a "pattern" bullet
	 */
	public void shootPatternBullet() {
		
		PatternBullet p = new PatternBullet((int)getX(), (int)getY(), stageNum, 5);
		p.setup(surface);
		ArrayList<Entity> list = getDaList();
		for (Bullet b : p.getBullets()) {
			if (!list.contains(b)) list.add(b);
		}
	}
	
	public void act() {
		//hey nathan! you can change movements based on stageNum/goonNum in the 
		//constructor! i have made some examples you dont need
		//all these if statements in act
		frames++;	
		if (frames % (stageNum * 6) == 0) {
			counter++;
			curInd++;
			if (curInd >= movement.length) {
				curInd = 0;
			}
			
			double vx = movement[curInd][0];
			double vy = movement[curInd][1];
			double chance = Math.random();
			if(counter == 1 || (chance < 0.5 && stageNum == 3)) {
				movement[curInd][1] = -vy;
				movement[curInd][0] = -vx;
				counter = 0;
				if(stageNum == 3) {
					shootPatternBullet();
				}
			}
			setvx(vx);
			setvy(vy);
			shootPatternBullet();
			frames = 0;
		}
		setX(getvx() + getX());
		setY(getvy() + getY());
	}
	
	
	
	
	/**Sets up the boss with an image
	 * @param surface PApplet to setup with
	 */
	public void setup(PApplet surface) {
		this.surface = surface;
		PImage temp;
		System.out.println("loaded image");
		temp = (surface.loadImage("sprites/stage" + stageNum + "-3.png"));
		temp.resize((int)getWidth(), (int)getHeight());
		setSprite(temp);
	}
}
