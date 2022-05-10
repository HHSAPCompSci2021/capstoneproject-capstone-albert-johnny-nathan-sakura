package game;

import processing.core.PApplet;
import processing.core.PImage;

/**A Background class that can draw and scroll up smoothly
 * @author ayu663
 */
public class Background {
	private PImage photo;
	private int curCenterY;
	private int x, y, width, height;
	
	/**Constructs a Background class that will scroll up
	 * 
	 * @param imagePath 
	 * @pre imagePath is a valid path for an image on this system
	 */
	public Background(PImage photo, int x, int y, int width, int height) {
		this.photo = photo;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		photo.resize(width, height);
	}
	/**Draws this Background class from the currentCenter scrolled 
	 * 
	 * @param marker
	 */
	public void draw(PApplet marker) {
		marker.image(photo, x,  curCenterY-photo.height);
		marker.image(photo, x, curCenterY);//, 0, curCenterY, width, photo.height);
		marker.image(photo, x,  curCenterY+photo.height);//, 0, curCenterY-photo.height, width, photo.height);
	}
	
	/**Changes the y the Background is currently at while scrolling
	 * 
	 * @param y
	 */
	public void scroll(int yMove) {
		curCenterY+=yMove;
		if (curCenterY > this.y+height) {
			curCenterY = 0;
		}
	}
}
