package edu.bw.ecoover18.radio;
import java.util.ArrayList;
import java.util.List;
/*
 */

public class AirwaveManager {
	private double frequency = 102.1;
	private String currentlyPlaying = "";
	private ArrayList<String> queue = new ArrayList<String>();

	public AirwaveManager() {

	}

	public AirwaveManager(double freq) {
		frequency = freq;
	}

	public AirwaveManager(double freq, String startPlay) {
		frequency = freq;
		sendToAirwave(startPlay);
	}

	public void setFrequency(double freq) {
		frequency = freq;
	}

	public void addToQueue(String song) {
		if(!queue.contains(song))
			queue.add(song);
	}

	public void removeFromQueue(String toRemove) {
		queue.remove(toRemove);
	}

	public void clearQueue() {
		queue = new ArrayList<String>();
	}

	public void sendToAirwave(String songName) {
		try {
			//sudo ./fm_transmitter [-f frequency] [-r] filename
			String toSend = "sudo ./fm_transmitter -f " + frequency + " -r " + songName;
			Runtime.getRuntime().exec(toSend);
			setCurrentlyPlaying(songName);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public void setCurrentlyPlaying(String setAs) {
		currentlyPlaying = setAs;
	}

	public String getCurrentlyPlaying() {
		return currentlyPlaying;
	}
}
