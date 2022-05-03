import processing.core.PImage;

public class Entity {
	
	private double width, height, dmg, x, y, vx, vy;
	private boolean isCircleHitbox;
	private PImage sprite;
	public int[] bounds; //{topLeftX, topLeftY, windowWidth, windowHeight}
	
	public Entity(double x, double y, double w, double h, boolean circle, PImage image) {
		this.x = x; this.y = y; this.width = w; this.height = h; isCircleHitbox = circle; sprite = image;
	}
	
	public boolean isTouching(Entity e) {
	}
	
	public void act() {
		
	}
	
	public void draw(PApplet surface) {
		
	}
}
