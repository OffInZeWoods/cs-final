package edu.bw.ecoover18.radio;/*This class contains the UI that allows the DJ to change songs/orders
 *of songs to play over the pirate radio station.
 *
 *Class Name: PlaylistManageUI.java
 *	Sub-Class: ChangeAttribute.java
 *Group: The A-Team (Kris S, Mark R, Ethan C) - Spring '19
 *Programmed by: Ethan R. Coover (Baldwin Wallace University, Berea, OH)
 *Version: 1.1.0
 */

import javax.swing.*;
import java.util.ArrayList;

public class PlaylistManagerUI implements Runnable{
	public PlaylistManager manage = new PlaylistManager();

	public PlaylistManagerUI() {

	}

	public void viewPlaylist() {
		ArrayList<String> playlist = manage.getPlaylist();
		String toDisplay = "";
		int count = 0;

		for(String s : playlist) {
			toDisplay += count + ": " + s + "\n";
		}

		System.out.println(toDisplay);
	}

	public void addWhole() {
		manage.addAll(true);
		JOptionPane.showMessageDialog(null, "Playlist added successfully.");
		this.showDisplay();
	}

	public void alterPlaylist() {
		ArrayList<String> playlist = manage.getPlayli
	}

	public void nowPlaying() {

	}

	public void run() {
		manage.addAll(true);
		this.showDisplay();
	}

	public void showDisplay() {
		String[] options = new String[] {"Exit Playlist Manager", "View Current Playlist", "Add Whole Playlist", "Alter Playlist", "Now Playing"};
		int choice = JOptionPane.showOptionDialog(null, "What would you like to do?", "Playlist Manager", JOptionPane.DEFAULT_OPTION,
					 JOptionPane.PLAIN_MESSAGE, null, options, 0);

		switch(choice) {
			case 0: System.exit(0);
			break;
			case 1: this.viewPlaylist();
			break;
			case 2: this.addWhole();
			break;
			case 3: this.alterPlaylist();
			break;
			default: this.nowPlaying();
		}
	}

	/* static class ChangeAttribute {
		public final int DELETE_SONG = -1;
		public final int MOVE_SONG = 0;
		public final int REPLAY_SONG = 1;
		private int currentAtt = 0;

		public ChangeAttribute(int attr) {
			currentAtt = attr;
		}

		public void setAttribute(int setTo) {
			currentAtt = setTo;
		}

		public int getAttribute() {
			return currentAtt;
		}

		public static ChangeAttribute makeAttribute() {
			String[] options = new String[] {"Delete a Song.", "Move a Song.", "Replay Current Song."};
		}
	} */
}