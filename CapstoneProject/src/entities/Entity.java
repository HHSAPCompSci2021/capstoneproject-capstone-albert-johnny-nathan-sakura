package entities;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * The Entity class represents an entity inside with a movement speed, location, and hitbox.
 * The entity is drawn using the Processing library.
 * It detects collisions between other entities and allows the entity to act. 
 * @author nathangu
 */
public class Entity {
	
	private double width, height, dmg, x, y, vx, vy;
	private boolean isCircleHitbox;
	private PImage sprite;
	public double[] bounds; //{topLeftX, topLeftY, windowWidth, windowHeight}
	
	/**
	 * Creates a new instance of Entity
	 * @param x X-coordinate
	 * @param y Y-coordinate
	 * @param w Width of the hitbox
	 * @param h Height of the hitbox
	 * @param circle If the hitbox is a circle
	 * @param image Image of the entity
	 */
	public Entity(double x, double y, double w, double h, boolean circle, PImage image) {
		this.x = x; 
		this.y = y; 
		this.width = w; 
		this.height = h; 
		isCircleHitbox = circle; 
		sprite = image;
		vx = 0;
		vy = 0;
		dmg = 0;
	}
	
	/**Returns whether or not the entity is touching another entity
	 * @param e The other entity
	 * @return True if the two entities touch, false otherwise
	 */
	public boolean isTouching(Entity e) {
		//Rectangle-Rectangle
		//if(!e.getCircleHitbox() && !getCircleHitbox()) {
			if(isPointInside(e.getX(), e.getY()) || isPointInside(e.getX() + e.getWidth(), e.getY()) 
			|| isPointInside(e.getX() + e.getWidth(), e.getY() + e.getHeight())
			|| isPointInside(e.getX(), e.getY() + e.getHeight())) {
				return true;
			}
			else {
				return false;
			}
		//}		
		//Circle-Circle
//		else if(e.getCircleHitbox() && this.getCircleHitbox()){			
//			double centerDist = Math.sqrt(Math.pow(getX() - e.getX(), 2) + Math.sqrt(Math.pow(getY() - e.getY(), 2)));
//			double radiusDist = getWidth()+ e.getWidth();
//			
//			if(centerDist <= radiusDist) {
//				return true;
//			}
//			else {
//				return false;
//			}
//
//		}
//		//Rectangle-Circle
//		//This is when the pt is top left corner so i need to fix this
//		else if(!this.getCircleHitbox() && e.getCircleHitbox()){
//			double xDist = Math.abs(e.getX() - getX());
//		    double yDist = Math.abs(e.getY() - getY());
//
//		    if (xDist > (getWidth()/2 + e.getWidth())) {
//		    	return false; 
//		    }
//		    
//		    if (yDist > (getHeight()/2 + e.getWidth())){
//		    	return false; 
//		    }
//
//		    if (xDist <= (getWidth()/2)) {
//		    	return true; 
//		    } 
//		    if (yDist <= (getHeight()/2)) { 
//		    	return true; 
//		    }
//
//		    double corner = Math.pow(xDist - getWidth() / 2, 2) +
//		    		Math.pow(yDist - getHeight() / 2, 2);
//		    
//		    return (corner <= (Math.pow(e.getWidth(), 2)));
//		}
//		
//		//Circle-Rectangle
//		//This is when the pt is top left corner so i need to fix this
//		else {
//			double xDist = Math.abs(getX() - e.getX());
//		    double yDist = Math.abs(getY() - e.getY());
//
//		    if (xDist > (e.getWidth()/2 + getWidth())) {
//		    	return false; 
//		    }
//		    
//		    if (yDist > (e.getHeight()/2 + getWidth())){
//		    	return false; 
//		    }
//
//		    if (xDist <= (getWidth()/2)) {
//		    	return true; 
//		    } 
//		    if (yDist <= (getHeight()/2)) { 
//		    	return true; 
//		    }
//
//		    double corner = Math.pow(xDist - getWidth() / 2, 2) +
//		    		Math.pow(yDist - getHeight() / 2, 2);
//		    
//		    return (corner <= (Math.pow(getWidth(), 2)));
//		}
	}
	
	
	/**
	 * Returns whether or not the point is inside
	 * @param x X-coordinate
	 * @param y Y-coordinate
	 * @return True if the point is inside, false otherwise
	 */
	public boolean isPointInside(double x, double y) {
		
		if(x >= this.getX() && x <= this.getX() + this.getWidth() 
		&& y >= this.getY() && y <= this.getY() + this.getHeight()) {
			return true;
		}
		return false;
	}

	/**
	 * Causes the entity to act
	 */
	public void act() {
		double distX;
		double distY;
		
		x += vx;
		y += vy;
				
		if(bounds[0] <= getX() || getX() >= bounds[0] + bounds[2]) {
			vx = - vx;
			x += vx;
		}		
		if(bounds[1] <= getY() || getY() >= bounds[1] + bounds[3]) {
			vy = - vy;
			y += vy;
		}					
	}
	
	/**
	 * Draws out the entity
	 * @param surface The surface to be drawn on
	 */
	public void draw(PApplet surface) {

	}
	
	/**
	 * @return X-Coordinate
	 */
	public double getX() {
		return x;
	}
	/**
	 * Sets the X-Coordinate
	 * @param coord New X-Coordinate
	 */
	public void setX(double coord) {
		x = coord;
	}
	/**
	 * @return Y-Coordinate
	 */
	public double getY() {
		return y;
	}
	/**
	 * Sets the Y-Coordinate
	 * @param coord New Y-Coordinate
	 */
	public void setY(double coord) {
		y = coord;
	}
	/**
	 * @return X-velocity
	 */
	public double getvx() {
		return vx;
	}
	/**
	 * Sets the X-velocity
	 * @param velo New X-velocity
	 */
	public void setvx(double velo) {
		vx = velo;
	}
	/**
	 * @return Y-velocity
	 */
	public double getvy() {
		return vy;
	}
	/**
	 * Sets the Y-velocity
	 * @param velo New Y-velocity
	 */
	public void setvy(double velo) {
		vy = velo;
	}
	/**
	 * @return Width of the entity
	 */
	public double getWidth() {
		return width;
	}
	/**
	 * Sets the width
	 * @param width New width
	 */
	public void setWidth(double width) {
		this.width = width;
	}
	/**
	 * @return Height of the entity
	 */
	public double getHeight() {
		return height;
	}
	/**
	 * Sets the height
	 * @param width New height
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	/**
	 * @return True if hitbox is a circle, false otherwise
	 */
	public boolean getCircleHitbox() {
		return isCircleHitbox;
	}
	
	
}
