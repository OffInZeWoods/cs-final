package edu.bw.ecoover18.radio;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
/*
 */

public class AirwaveManager {
	private double frequency = 87.5;
	private Queue<String> queue = new LinkedList<>();

	public AirwaveManager() {

	}

	public AirwaveManager(double freq) {
		frequency = freq;
	}

	public AirwaveManager(double freq, String startPlay) {
		frequency = freq;
		addToQueue(startPlay);
		sendToAirwave(startPlay);
	}

	public void setFrequency(double freq) {
		frequency = freq;
	}

	public void addToQueue(String toAdd) {
		try {
			queue.add(toAdd);
		} catch (Throwable t) {

		}
	}

	public void removeFirstInQueue() {
		queue.remove();
	}

	public void sendToAirwave(String songName) {
		try {
			//sudo ./fm_transmitter [-f frequency] [-r] filename
			String toSend = "sudo ./fm_transmitter -f " + frequency + " -r " + songName;
			Runtime.getRuntime().exec(toSend);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public String getCurrentlyPlaying() {
		return queue.peek();
	}
}
