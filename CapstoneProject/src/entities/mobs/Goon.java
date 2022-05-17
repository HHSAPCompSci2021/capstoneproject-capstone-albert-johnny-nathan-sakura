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
	private Point2D[] movement;
	private double[][] movement2;
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
		setHp(2500);
//		setvx(10);
//		setvy(10);		
		frames = 0;
		movement = new Point2D[5];
		movement2 = new double[4][2];
		movement2[0][0] = -5;
		movement2[0][1] = 0;
		movement2[3][0] = 5;
		movement2[3][1] = 0;
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
		Bullet b = new Bullet(this.getX()+getWidth()/2-15, this.getY() - 25, 30, 30, 0, 15, true, false, 1);
		b.setup(surface);
		getDaList().add(b);
	}
	
	
	/**
	 * Allows the Goon to move and shoot
	 */
	public void act() {
	//	super.act();
		frames++;
		if (frames == 3) {
			frames = 0;
			//int index = (int) (Math.random() * movement.length);
			curInd++;
			if (curInd >= movement2.length) {
				curInd = 0;
			}
			double vx = movement2[curInd][0]; 
			double vy = movement2[curInd][1];
			setvx(vx);
			setvy(vy);
//			double x = movement[index].getX();
////			double y = movement[index].getY();
//			setvx((x - getX()) / 5);
//			setvy((y - getY()) / 5);

			shoot();	
		}
		setX(getvx() + getX());
		setY(getvy() + getY());
////		super.act();
//		
////		setHp(0);
//		if(0<= moviewoovie && moviewoovie <= seconds && flag) {
//			if (shawtyFramesCD > 0) {
//				shawtyFramesCD--;
//			}
//			if(shawtyFramesCD <= 0) {
//				shoot();
//				shawtyFramesCD = seconds;
//			}
//			setX(getX() + getvx());
//			moviewoovie--;
//		}
//		
//		if(0 >= moviewoovie && moviewoovie > -seconds && flag) {
//			if (shawtyFramesCD > 0) {
//				shawtyFramesCD--;
//			}
//			if(shawtyFramesCD <= 0) {
//				shoot();
//				shawtyFramesCD = seconds;
//			}
//			setY(getY() + getvy());
//			moviewoovie--;
//			if(moviewoovie <= -seconds) {
//				flag = false;
//				moviewoovie = seconds;
//				
//			}
//		}
//		
//		if(0<= moviewoovie && moviewoovie <= seconds && !flag) {
//			if (shawtyFramesCD > 0) {
//				shawtyFramesCD--;
//			}
//			if(shawtyFramesCD <= 0) {
//				shoot();
//				shawtyFramesCD = seconds;
//			}
//			setX(getX() - getvx());
//			moviewoovie--;
//		}
//		
//		if(0 >= moviewoovie && moviewoovie > -10 && !flag) {
//			if (shawtyFramesCD > 0) {
//				shawtyFramesCD--;
//			}
//			if(shawtyFramesCD <= 0) {
//				shoot();
//				shawtyFramesCD = 10;
//			}
//			setY(getY() - getvy());
//			moviewoovie--;
//			if(moviewoovie <= -10) {
//				flag = true;
//				moviewoovie = 10;
//			}
//		}	
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
