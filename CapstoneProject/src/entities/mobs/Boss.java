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
	private int framesMod;
	/**
	 * Creates a new instance of Boss
	 * @param x X-coordinate
	 * @param y Y-coordinate
	 * @param w Width of the hitbox
	 * @param h Height of the hitbox
	 * @param circle If the hitbox is a circle
	 * @param stageNum the stage number of the Boss
	 */
	public Boss(double x, double y, double w, double h, boolean circle, int stageNum) {
		super(x, y, w, h, circle);
		this.stageNum = stageNum;
		setHp(50000);
		frames = 0;
		movement = new double[4][2];
		if (stageNum == 1) {
			movement[0][0] = 5;
			movement[0][1] = -5;
			movement[1][0] = 7;
			movement[1][1] = 0;
			movement[2][0] = 7;
			movement[2][1] = 0;
			movement[3][0] = 5;
			movement[3][1] = 5;			
		}
		if (stageNum == 2) {
			movement[0][0] = -7;		
			movement[0][1] = 8 ;		
			movement[1][0] = 7;		
			movement[1][1] = 8;		
			movement[2][0] = 7;
			movement[2][1] = -8;
			movement[3][0] = -7;
			movement[3][1] = -8;	
		}
		if (stageNum == 3) {
			movement[0][0] = 5;
			movement[0][1] = -7;
			movement[1][0] = -5;
			movement[1][1] = -7;
			movement[2][0] = -5;
			movement[2][1] = 7;
			movement[3][0] = 5;
			movement[3][1] = 7;
		}
		if(stageNum == 4) {
			movement = new double[16][2];
			movement[0][0] = -3;
			movement[0][1] = -4;	
			movement[1][0] = -3;
			movement[1][1] = -4;	
			movement[2][0] = 3;
			movement[2][1] = 4;
			movement[3][0] = 3;
			movement[3][1] = 4;	
			movement[4][0] = -3;
			movement[4][1] = 4;		
			movement[5][0] = 3;
			movement[5][1] = -4;			
			movement[6][0] = 3;
			movement[6][1] = -4;	
			movement[7][0] = -3;
			movement[7][1] = 4;	
			movement[8][0] = 3;
			movement[8][1] = 4;
			movement[9][0] = 3;
			movement[9][1] = 4;		
			movement[10][0] = -3;
			movement[10][1] = -4;		
			movement[11][0] = -3;
			movement[11][1] = -4;		
			movement[12][0] = 3;
			movement[12][1] = -4;		
			movement[13][0] = -3;
			movement[13][1] = 4;		
			movement[14][0] = -3;
			movement[14][1] = 4;	
			movement[15][0] = 3;
			movement[15][1] = -4;	
		}
		
		
	}
	
	/**
	 * Makes the boss shoot a "pattern" bullet
	 */
	public void shootPatternBullet() {
		PatternBullet p = new PatternBullet((int)getX(), (int)getY(), stageNum, stageNum*2);
		p.giveBounds(bounds.clone());
		p.setup(surface);
		ArrayList<Entity> list = getDaList();
		for (Bullet b : p.getBullets()) {
			if (!list.contains(b)) list.add(b);
		}
	}
	
	/**
	 * Allows the Boss to move and shoot
	 */
	public void act() {
		frames++;	
		if (frames % (stageNum * 10) == 0) {
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
			}
			setvx(vx);
			setvy(vy);
			shootPatternBullet();
			frames = 0;
		}
		
		if (frames % 25 == 0 && stageNum == 4) {
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
			}
			setvx(vx);
			setvy(vy);
			shootPatternBullet();
			frames = 0;
		}
		setX(getvx() + getX());
		setY(getvy() + getY());
	}
	
	
	
	
	/**
	 * Sets up the boss with an image
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
