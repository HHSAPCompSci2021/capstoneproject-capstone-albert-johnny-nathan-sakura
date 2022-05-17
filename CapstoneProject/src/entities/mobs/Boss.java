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
	private PApplet surface;
	private double[][] movement;
	private int curInd;
	private int frames;
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
		setHp(5000);
		frames = 0;
		if (stageNum == 1) {
			movement = new double[4][2];
			movement[0][0] = -3;
			movement[0][1] = 0;
			movement[3][0] = 3;
			movement[3][1] = 0;
		}
		if (stageNum == 2) {
			movement = new double[4][2];
			movement[0][0] = -5;
			movement[0][1] = 0;
			movement[3][0] = 5;
			movement[3][1] = 0;
		}
		if (stageNum == 3) {
			movement = new double[4][2];
			movement[0][0] = -10;
			movement[0][1] = 0;
			movement[3][0] = 10;
			movement[3][1] = 0;
		}
		
		
	}
	
	/**
	 * Makes the boss shoot a "pattern" bullet
	 */
	public void shootPatternBullet() {
		Bullet b = new Bullet(getX(), getY(), 30, 30, 0, 15, true, false, 10);
		b.setup(surface);
		getDaList().add(b);
	}
	
	public void act() {
		//hey nathan! you can change movements based on stageNum/goonNum in the 
		//constructor! i have made some examples you dont need
		//all these if statements in act
		frames++;
		if(stageNum == 1) {
			if (frames == 20) {
				frames = 0;
				curInd++;
				if (curInd >= movement.length) {
					curInd = 0;
				}
				
				double vx = movement[curInd][0]; 
				double vy = movement[curInd][1];
//				if(curInd % 2 == 0) {
//					vy = 10;
//				}
//				if(curInd % 2 != 0) {
//					vy = -10;
//				}
				shoot();	
				setvx(vx);
				setvy(vy);
			}
			if(frames % 4 == 0) {
				shoot();
			}
			setX(getvx() + getX());
			setY(getvy() + getY());
		}
	if(stageNum == 2) {
		if (frames == 35) {
			frames = 0;
			curInd++;
			if (curInd >= movement.length) {
				curInd = 0;
			}
			
			movement[0][0] = 12;
			movement[3][0] = -12;
			double vx = movement[curInd][0]; 
			double vy = movement[curInd][1];
//			if(curInd % 3 == 0) {
//				vy = 12;
//			}
//			if(curInd % 3 != 0) {
//				vy = -12;
//			}	
			shoot();
			setvx(vx);
			setvy(vy);
		}
		if(frames % 4 == 0) {
			shoot();
		}
		setX(getvx() + getX());
		setY(getvy() + getY());
	}
	
	if(stageNum == 3) {
		if (frames == 40) {
			frames = 0;
			curInd++;
			if (curInd >= movement.length) {
				curInd = 0;
			}
			
			
			double vx = movement[curInd][0]; 
			double vy = movement[curInd][1];
//			if(curInd % 3 == 0) {
//				vx -= 2;
//				vy -= 12;
//			}
//			if(curInd % 3 != 0) {
//				vx += 2;
//				vy += 2;
//				
//			}
			shoot();
			setvx(vx);
			setvy(vy);
		}
		if(frames % 4 == 0) {
			shoot();
		}
		setX(getvx() + getX());
		setY(getvy() + getY());
	}

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
//	/**
//	 * Allows the Boss to move
//	 */
//	public void move() {
//		act();
//	}
}
