package game;

import processing.core.PApplet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jay.jaysound.*;

/**
 * sound. 
 * @author albert
 * contains all the stuff needed to implement sound. 
 */
public class Sounds implements ActionListener, JayLayerListener {
	//jay.jaysound classes
	//JayLayer and JayLayerListener
	//Player.java in jj.player
	private int index = 0;
	private JayLayer j;
	public Sounds(int stageNum) {
		if (stageNum != 0) {
			j = new JayLayer(System.getProperty("user.dir") ,System.getProperty("user.dir") ,true);
			int playlist = j.addPlayList();
			j.addSong(playlist, "\\songs\\stage"+stageNum+"-1.mp3");
			System.out.println("Playlist = " + playlist);
			j.addSong(playlist, "\\songs\\stage"+stageNum+"-1.mp3");
			j.changePlayList(playlist);
			j.addJayLayerListener(this);
			j.nextSong();
			j.addSoundEffect("\\songs\\shoot.mp3");
			index = 0;
			//j.playSoundEffect(0);
			
			
	//		sound=new JayLayer("audio/","audio/",false);
	//		sound.addPlayList();
	//		sound.addSongs(0,songs);
	//		sound.addSoundEffects(soundEffects);
	//		sound.changePlayList(0);
	//		sound.addJayLayerListener(this);
			System.out.println(j.isPlaying());
	//		if (stageNum == 1) {
	//		}
	//		if (stageNum == 2) { 
	//		}
	//		if (stageNum == 3) {
	//			j.addSong(0, "songs/s.mp3");
	//		}
	//		if (stageNum == 4) {
	//			j.addSong(0, "songs/s.mp3");
	//		}
	//		j.addSoundEffect("soundeffect.mp3");
		} else {
			j = new JayLayer(System.getProperty("user.dir") ,System.getProperty("user.dir") ,false);
			int playlist = j.addPlayList();
			j.addSong(playlist, "\\songs\\end1.mp3");
			j.addSong(playlist, "\\songs\\start.mp3");
			j.addSong(playlist, "\\songs\\end1.mp3");
			j.changePlayList(playlist);
			j.addJayLayerListener(this);
			j.nextSong();
			j.addSoundEffect("\\songs\\shoot.mp3");
			index = 0;
		}
	}
	
	
	public void playEffect() {
		//if (index > j.getNumberOfSoundEffect()-1) index = 0;
//		j.addSoundEffect("\\songs\\shoot.mp3");
//		j.playSoundEffect(j.getNumberOfSoundEffect()-1);
		//index++;
	}
	public void playVine() {
//		System.out.println("VINEBOOM");
//		j.addSoundEffect("\\songs\\pickup.mp3");
//		j.playSoundEffect(j.getNumberOfSoundEffect()-1);
	}
	
	public void pickUpEffect() {
//		j.addSoundEffect("\\songs\\pickup.mp3");
//		j.playSoundEffect(j.getNumberOfSoundEffect()-1);
	}

	public void hitEffect() {
//		j.addSoundEffect("\\songs\\hit.mp3");
//		j.playSoundEffect(j.getNumberOfSoundEffect()-1);
	}
	
	public void nextTrack() {
		j.nextSong();
	}
	
	public void stopTrack() {
		j.stopSong();
	}


	@Override
	public void musicStarted() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void musicStopped() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void playlistEnded() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void songEnded() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
//	public void play() {
//		j.set
//	}
	
	
}
