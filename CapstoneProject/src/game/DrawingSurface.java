package game;
import java.util.ArrayList;

import processing.core.PApplet;

/**A DrawingSurface class that can draw both games with half the screen
 * @author ayu663
 */
public class DrawingSurface extends PApplet {
	private ArrayList<Integer> keys;
	private Game game1, game2;
	private boolean startMenu;
	private boolean pauseMenu, cutscene;
	private int newWidth, newHeight;
	private int whoWon;
	private boolean gameDone;
	
	/**
	 * Constructs a DrawingSurface with initializing the default game with width and height
	 * @param width1 Both Game's width
	 * @param height1 Each Game's height
	 */
	public DrawingSurface(int width1, int height1) {
		this.newWidth = width1;
		this.newHeight = height1;
		keys = new ArrayList<Integer>();
		startMenu = true;
		pauseMenu = false;
	}
	
	/**
	 * Sets up a DrawingSurface by setting up the Game
	 */
	public void setup() {
		textFont(createFont("fonts/redalert1.ttf",30));
		System.out.println(newWidth + " " + newHeight);
		game1 = new Game(1, newWidth, newHeight);
		game2 = new Game(2, newWidth, newHeight);
		game1.setup(this);
		game2.setup(this);
	}
	
	/**
	 * Draws the games
	 */
	public void draw() {
		game1.giveInputs(this);
		game2.giveInputs(this);
		
		if (isPressed(27)) {
			pauseMenu = true;
		}
		if (pauseMenu) {
			background(90);
			textSize(40);
			text("Paused", width/4,height/4,width/2,height/2);
			textSize(30);
			text("Press ENTER to start game",width/4,height/3,width/2,height/2*3);
			if (isPressed(10)) {
				pauseMenu = false;
			}
		}
		else if (startMenu) {
			background(200);
			textSize(40);
			text("Lunatic's Resolve", width/4,height/4,width/2,height/2);
			textSize(30);
			text("Press SPACE to start game",width/4,height/3,width/2,height/2*3);
			if (isPressed(32)) {
				startMenu = false;
				cutscene = true;
			}
		} else if (cutscene) {

			background(200);
			textSize(30);
			text("Each player will move up the tower while dodging a sea of bullets approaching in different patterns. "
					+ "Besides surviving their own path, they must foresee traps the other hero sends in their direction. "
					+ "Each section of the map features a different boss. "
					+ "By surviving and killing the final adversary standing in their way, can they progress to the next floor. "
					+ "The hero to complete all the floors and reach the pinnacle first will be crowned the victor in this futile race. "
					+ "They will also receive bragging rights for the rest of their short lives inhabiting the deserted wasteland."
					+ " A hero will also win if the counterpart perishes in this unforgiving world. "
					,width/6,height/4,width - 360, height - 150);
			if (isPressed(((int)'Y')) || isPressed(((int)'y'))) {
				cutscene = false;
			}
		} else if (gameDone) {
			background(225);
			fill(0, 95, 143);
			if (whoWon == 1) fill(130, 7, 0);
			text("Player " + whoWon + " won!!", width/2-100,height/2,width,height);
			
		}
		else {
			clear();
			
			//somehow add black bars in the game - set the Game's dimensions to 
			//fit within these black bars
			//plan: 50 on the left of game1, 50 in middle, 50 on the right of
			//		game2, 50 on top, 100 at bottom for statistics (within game
			//		x bounds also)
			background(100);
			game2.draw(this);
			game1.draw(this);
			if (game1.gameOver()) {
				whoWon = 2;
				gameDone = true;
			}
			if (game2.gameOver()) {
				whoWon = 1;
				gameDone = true;
			}
			if (game1.gameCompleted()) {
				whoWon = 1;
				gameDone = true;
			}
			if (game2.gameCompleted()) {
				whoWon = 2;
				gameDone = true;
			}
		}
	}
	/**
	 * Updates keypressed list
	 */
	public void keyPressed() {
		keys.add(keyCode);
		if (key == ESC)  // This prevents a processing program from closing on escape key
			key = 0;
	}

	/**
	 * Updates keypressed list
	 */
	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove(keys.indexOf(keyCode));
	}
	
	/**
	 * Detects if a key is pressed
	 * @param code Key number
	 * @return True if key is pressed, false otherwise
	 */
	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}
	
}
