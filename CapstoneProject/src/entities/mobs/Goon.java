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
	//private double shotFrequency;
	private int stageNum;
	private int goonNum;
	private PApplet surface;
	private long frames;
	private double[][] movement;
	private int curInd;
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
		//har dcode
		setHp(2500);
//		setvx(10);
//		setvy(10);		
		frames = 0;
		movement = new double[4][2];
		movement[0][0] = -10;
		movement[0][1] = 10;
		movement[3][0] = 10;
		movement[3][1] = 10;
		curInd = 1;
//		movement[0] = new Point2D.Double(bounds[0] + 200, bounds[1] + 200);
//		movement[1] = new Point2D.Double(bounds[0] + bounds[2] + 200, bounds[1] + 200);
//		movement[2] = new Point2D.Double(bounds[0] + bounds[2] + 200, bounds[1] + bounds[3] + 200);
//		movement[3] = new Point2D.Double(bounds[0] + 200, bounds[1] + bounds[3] + 200);
//		movement[4] = new Point2D.Double((bounds[0] + bounds[2]) / 2 + 200, (bounds[1] + bounds[3]) / 2 + 200);
		
	}
	
	
	
	/**
	 * Shoots Bullets
	 */
	public void shoot() {
		Bullet b = new Bullet(this.getX()+getWidth()/2-15, this.getY() - 25, 30, 30, 0, 5, true, false, 1);
		b.setup(surface);
		getDaList().add(b);
	}
	
	
	/**
	 * Allows the Goon to move and shoot
	 */
	public void act() {
		frames++;
		if(stageNum == 1) {
			if (frames == 10) {
				frames = 0;
				curInd++;
				if (curInd >= movement.length) {
					curInd = 0;
				}
				
				double vx = movement[curInd][0]; 
				double vy = movement[curInd][1];
				if(curInd % 2 == 0) {
					vy = 10;
				}
				if(curInd % 2 != 0) {
					vy = -10;
				}			
				setvx(vx);
				setvy(vy);
				shoot();	
			}
			setX(getvx() + getX());
			setY(getvy() + getY());
		}
	if(stageNum == 2) {
		if (frames == 5) {
			frames = 0;
			curInd++;
			if (curInd >= movement.length) {
				curInd = 0;
			}
			
			movement[0][0] = 12;
			movement[3][0] = -12;

			double vx = movement[curInd][0]; 
			double vy = movement[curInd][1];
			if(curInd % 3 == 0) {
				vy = 12;
			}
			if(curInd % 3 != 0) {
				vy = -12;
			}			
			setvx(vx);
			setvy(vy);
			shoot();	
		}
		setX(getvx() + getX());
		setY(getvy() + getY());
	}
	
	if(stageNum == 3) {
		if (frames == 8) {
			frames = 0;
			curInd++;
			if (curInd >= movement.length) {
				curInd = 0;
			}
			
			
			double vx = movement[curInd][0]; 
			double vy = movement[curInd][1];
			if(curInd % 3 == 0) {
				vx -= 2;
				vy -= 13;
			}
			if(curInd % 3 != 0) {
				vx += 2;
				vy += 3;
				
			}			
			setvx(vx);
			setvy(vy);
			shoot();	
		}
		setX(getvx() + getX());
		setY(getvy() + getY());
	}
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
