import processing.core.PApplet;
import processing.core.PImage;

public class Entity {
	
	private double width, height, dmg, x, y, vx, vy;
	private boolean isCircleHitbox;
	private PImage sprite;
	public int[] bounds; //{topLeftX, topLeftY, windowWidth, windowHeight}
	
	public Entity(double x, double y, double w, double h, boolean circle, PImage image) {
		this.x = x; 
		this.y = y; 
		this.width = w; 
		this.height = h; 
		isCircleHitbox = circle; 
		sprite = image;
	}
	
	/**Returns whether or not the entity is touching another entity
	 * @param e The other entity
	 * @return True if the two entities touch, false otherwise
	 */
	public boolean isTouching(Entity e) {
		//Rectangle-Rectangle
		if(!e.getCircleHitbox() && !getCircleHitbox()) {
			if(isPointInside(e.getX(), e.getY()) || isPointInside(e.getX() + e.getWidth(), e.getY()) 
			|| isPointInside(e.getX() + e.getWidth(), e.getY() + e.getHeight())
			|| isPointInside(e.getX(), e.getY() + e.getHeight())) {
				return true;
			}
			else {
				return false;
			}
		}		
		//Circle-Circle
		else if(e.getCircleHitbox() && this.getCircleHitbox()){			
			double centerDist = Math.sqrt(Math.pow(getX() - e.getX(), 2) + Math.sqrt(Math.pow(getY() - e.getY(), 2)));
			double radiusDist = getWidth()+ e.getWidth();
			
			if(centerDist <= radiusDist) {
				return true;
			}
			else {
				return false;
			}

		}
		//Rectangle-Circle
		//This is when the pt is top left corner so i need to fix this
		else if(!this.getCircleHitbox() && e.getCircleHitbox()){
			double xDist = Math.abs(e.getX() - getX());
		    double yDist = Math.abs(e.getY() - getY());

		    if (xDist > (getWidth()/2 + e.getWidth())) {
		    	return false; 
		    }
		    
		    if (yDist > (getHeight()/2 + e.getWidth())){
		    	return false; 
		    }

		    if (xDist <= (getWidth()/2)) {
		    	return true; 
		    } 
		    if (yDist <= (getHeight()/2)) { 
		    	return true; 
		    }

		    double corner = Math.pow(xDist - getWidth() / 2, 2) +
		    		Math.pow(yDist - getHeight() / 2, 2);
		    
		    return (corner <= (Math.pow(e.getWidth(), 2)));
		}
		
		//Circle-Rectangle
		//This is when the pt is top left corner so i need to fix this
		else {
			double xDist = Math.abs(getX() - e.getX());
		    double yDist = Math.abs(getY() - e.getY());

		    if (xDist > (e.getWidth()/2 + getWidth())) {
		    	return false; 
		    }
		    
		    if (yDist > (e.getHeight()/2 + getWidth())){
		    	return false; 
		    }

		    if (xDist <= (getWidth()/2)) {
		    	return true; 
		    } 
		    if (yDist <= (getHeight()/2)) { 
		    	return true; 
		    }

		    double corner = Math.pow(xDist - getWidth() / 2, 2) +
		    		Math.pow(yDist - getHeight() / 2, 2);
		    
		    return (corner <= (Math.pow(getWidth(), 2)));
		}
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

	
	public void act() {
		
	}
	
	public void draw(PApplet surface) {
		
	}
	
	
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getvx() {
		return vx;
	}
	public double getvy() {
		return vy;
	}
	public double getWidth() {
		return width;
	}
	public double getHeight() {
		return height;
	}
	public boolean getCircleHitbox() {
		return isCircleHitbox;
	}
	
}
