package entities.mobs;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import entities.Entity;
import entities.projectiles.Bullet;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * The class Goon class represents an Enemy
 */
public class Goon extends Enemy{
	private int stageNum;
	private int goonNum;
	private PApplet surface;
	private long frames, shots;
	private double[][] movement;
	private int curInd;
	private int counter;
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
		setHp(2500);	
		frames = 0;
		counter = 0;
		movement = new double[6][2];
		if (stageNum == 1) {
			if(goonNum == 1) {
				movement[0][0] = -7;
				movement[0][1] = 0;
				movement[3][0] = 7;
				movement[3][1] = 0;
			}
			if(goonNum == 2) {
				movement[0][0] = -7;
				movement[0][1] = 5;
				movement[3][0] = 7;
				movement[3][1] = 5;	
			}
			if(goonNum == 3) {
				movement[0][0] = -10;
				movement[0][1] = 1;
				movement[3][0] = 10;
				movement[3][1] = 1;
			}
			
		}
		if (stageNum == 2) {
			if(goonNum == 1) {
				movement[0][0] = -6;		
				movement[0][1] = 10 ;		
				movement[1][0] = 6;		
				movement[1][1] = 10;		
				movement[2][0] = 6;
				movement[2][1] = -10;
				movement[3][0] = -6;
				movement[3][1] = -10;	
			}
			if(goonNum == 2) {
				movement[0][0] = -4;		
				movement[0][1] = 10 ;		
				movement[1][0] = 6;		
				movement[1][1] = 10;		
				movement[2][0] = -6;
				movement[2][1] = -10;
				movement[3][0] = -4;
				movement[3][1] = -10;	
			}
			if(goonNum == 3) {
				movement[0][0] = -6;		
				movement[0][1] = 8 ;		
				movement[1][0] = 6;		
				movement[1][1] = 8;		
				movement[2][0] = 6;
				movement[2][1] = -8;
				movement[3][0] = -6;
				movement[3][1] = -8;	
			}
					}
		if (stageNum == 3) {
			if(goonNum == 1) {
				movement[0][0] = -5;
				movement[0][1] = 10;
				movement[1][0] = 5;
				movement[1][1] = 10;
				movement[2][0] = 5;
				movement[2][1] = -10;
				movement[3][0] = -5;
				movement[3][1] = -10;
			}
			if(goonNum == 2) {
				movement[0][0] = 5;
				movement[0][1] = -10;
				movement[1][0] = -10;
				movement[1][1] = -10;
				movement[2][0] = -5;
				movement[2][1] = 10;
				movement[3][0] = 15;
				movement[3][1] = 10;
			}
			if(goonNum == 3) {
				movement[0][0] = 5;
				movement[0][1] = -10;
				movement[1][0] = -10;
				movement[1][1] = -10;
				movement[2][0] = -5;
				movement[2][1] = 10;
				movement[3][0] = 15;
				movement[3][1] = 10;
			}
		}
		curInd = 0;
	}
	
	
	
	/**
	 * Shoots Bullets
	 */
	public void shoot() {
		if (shots % 3 == 0) {
			Bullet b = new Bullet(this.getX()+getWidth()/2-15, this.getY()+this.getHeight(), 20, 20, 0.5, 4, true, false, 1);
			b.setup(surface);
			b.bounds = bounds.clone();
			getDaList().add(b);
		}
		if (shots % 3 == 1) {
			Bullet b = new Bullet(this.getX()+getWidth()/2-15, this.getY()+this.getHeight(), 20, 20, 0, 5, true, false, 1);
			b.setup(surface);
			b.bounds = bounds.clone();
			getDaList().add(b);
		}
		if (shots % 3 == 2) {
			Bullet b = new Bullet(this.getX()+getWidth()/2-15, this.getY()+this.getHeight(), 20, 20, -0.5, 4, true, false, 1);
			b.setup(surface);
			b.bounds = bounds.clone();
			getDaList().add(b);
		}
		shots++;

	}
	
	
	/**
	 * Allows the Goon to move and shoot
	 */
	public void act() {
		frames++;	
		if (frames % 10 == 0) {
			counter++;
			curInd++;
			if (curInd >= movement.length) {
				curInd = 0;
			}
			
			double vx = movement[curInd][0];
			double vy = movement[curInd][1];
			if(counter == 1) {
				movement[curInd][1] = -vy;
				movement[curInd][0] = -vx;
				counter = 0;
			}
			setvx(vx);
			setvy(vy);
			shoot();
			frames = 0;
		}
		setX(getvx() + getX());
		setY(getvy() + getY());
	}
	public void draw(PApplet surface) {
		surface.tint(255, (float)(1.0*(getHp())/2500*125)+100);
		surface.tint((int)(1.0*(getHp())/2500*100)+125,(int)(1.0*(getHp())/2500*100)+125,(int)(1.0*(getHp())/2500*100)+125);
		super.draw(surface);
		surface.noTint();
	}
		

	
	/**
	 * Sets the X-coordinate velocity
	 * @param d
	 */
	public void setXMovement(double d) {
		setvx(d);
	}
	
	/**
	 * Sets the X-coordinate velocity
	 * @param d
	 */
	public void setYMovement(double d) {
		setvy(d);
	}
	
	
	/**
	 * Sets up the image for the Goon
	 * @param surface the drawing surface
	*/
	public void setup(PApplet surface) {
		this.surface = surface;
		PImage temp;
		System.out.println("loaded image");
		temp = (surface.loadImage("sprites/stage" + stageNum + "-" + goonNum+".png"));
		temp.resize((int)getWidth(), (int)getHeight());
		setSprite(temp);
	}

	
}
