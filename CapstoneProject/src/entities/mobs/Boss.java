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
	private int ogHP;
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
		ogHP = 40000;
		setHp(40000);
		frames = 0;
		movement = new double[4][2];
		if (stageNum == 1) {
			ogHP = 40000;
			movement[0][0] = 5;
			movement[0][1] = -5;
			movement[1][0] = 6;
			movement[1][1] = 0;
			movement[2][0] = 6;
			movement[2][1] = 0;
			movement[3][0] = 5;
			movement[3][1] = 5;			
		}
		if (stageNum == 2) {
			ogHP = 60000;
			movement[0][0] = -5;
			movement[0][1] = 7 ;
			
			movement[1][0] = 5;		
			movement[1][1] = 7;	
			
			movement[2][0] = 5;
			movement[2][1] = -7;
			
			movement[3][0] = -5;
			movement[3][1] = -7;	
		}
		if (stageNum == 3) {
			ogHP = 80000;
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
			movement[0][0] = -7;
			movement[0][1] = -5;	
			movement[1][0] = -7;
			movement[1][1] = -5;	
			movement[2][0] = 7;
			movement[2][1] = 5;
			movement[3][0] = 7;
			movement[3][1] = 5;	
			movement[4][0] = -7;
			movement[4][1] = 5;		
			movement[5][0] = 7;
			movement[5][1] = -5;			
			movement[6][0] = 7;
			movement[6][1] = -5;	
			movement[7][0] = -7;
			movement[7][1] = 5;	
			movement[8][0] = 7;
			movement[8][1] = 5;
			movement[9][0] = 7;
			movement[9][1] = 5;		
			movement[10][0] = -7;
			movement[10][1] = -5;		
			movement[11][0] = -7;
			movement[11][1] = -5;		
			movement[12][0] = 7;
			movement[12][1] = -5;		
			movement[13][0] = -7;
			movement[13][1] = 5;		
			movement[14][0] = -7;
			movement[14][1] = 5;	
			movement[15][0] = 7;
			movement[15][1] = -5;	
		}
		
		setHp(ogHP);
	}
	
	/**
	 * Makes the boss shoot a "pattern" bullet
	 */
	public void shootPatternBullet() {
		PatternBullet p = new PatternBullet((int)(getX() + getWidth()/2), (int)(getY()+ getHeight()/2), stageNum, stageNum*2);
		p.giveBounds(bounds.clone());
		p.setup(surface);
		ArrayList<Entity> list = getDaList();
		for (Bullet b : p.getBullets()) {
			if (!list.contains(b)) list.add(b);
		}
	}
	
	
	/**
	 * Surface to draw on
	 * @param PApplet Surface to draw on
	 */
	public void draw(PApplet surface) {
		surface.tint(255, (float)(1.0*(getHp())/ogHP*125)+100);
		surface.tint((int)(1.0*(getHp())/ogHP*100)+125,(int)(1.0*(getHp())/ogHP*100)+125,(int)(1.0*(getHp())/ogHP*100)+125);
		super.draw(surface);
		surface.noTint();
	}
	
	/**
	 * Allows the Boss to move and shoot
	 */
	public void act() {
		frames++;	
		if (frames % 15 == 0 && stageNum == 1) {
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
		
		if (frames % 23 == 0 && stageNum == 2) {
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
		
		if (frames % 30 == 0 && stageNum == 3) {
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
		
		if (frames % 10 == 0 && stageNum == 4) {
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
			if(curInd % 3 == 1) {
				shootPatternBullet();
			}
			setvx(vx);
			setvy(vy);
			frames = 0;
		}
		setX(getvx() + getX());
		setY(getvy() + getY());
	}
	
	public int getMaxHP() {
		return ogHP;
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
