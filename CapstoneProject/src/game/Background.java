package game;

import processing.core.PApplet;
import processing.core.PImage;

/**A Background class that can draw and scroll up smoothly
 * @author ayu663
 */
public class Background {
	private PImage photo;
	private int curCenterY;
	private int x, y, width, height, stageNum;
	
	/**Constructs a Background class that will scroll up
	 * 
	 * @param photo PImage to draw
	 * @param x X-coordinate of the Background
	 * @param y Y-coordinate of the Background
	 * @param width Width of the Background
	 * @param height Height of the Background
	 * @param stageNum Current Stage number
	 * @pre photo is a valid PImage 
	 */
	public Background(PImage photo, int x, int y, int width, int height, int stageNum) {
		this.photo = photo;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.stageNum = stageNum;
		photo.resize(width, height);
	}
	
	/**
	 * Draws the Background class from the currentCenter scrolled 
	 * @param marker The drawing surface
	 */
	public void draw(PApplet marker) {
		if (stageNum == 2) {
			marker.tint(200,100,0);
		}
		if (stageNum == 3) {
			marker.tint(100,200,0);
		}
		if (stageNum == 4) {
			marker.tint(0,100,200);
		}
		marker.image(photo, x,  curCenterY-photo.height);
		marker.image(photo, x, curCenterY);//, 0, curCenterY, width, photo.height);
		marker.image(photo, x,  curCenterY+photo.height);//, 0, curCenterY-photo.height, width, photo.height);
		marker.tint(255);
	}
	
	/**
	 * Changes the scrolling speed 
	 * @param yMove The speed to scroll
	 */
	public void scroll(int yMove) {
		curCenterY+=yMove;
		if (curCenterY > this.y+height) {
			curCenterY = this.y;
		}
	}
}
