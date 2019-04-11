package edu.bw.ecoover18.radio;

public class AirwaveManager {
	private double frequency = 102.0;
	private String currentlyPlaying = "";

	public AirwaveManager() {

	}

	public AirwaveManager(double freq) {
		frequency = freq;
	}

	public AirwaveManager(double freq, String startPlay) {
		frequency = freq;
		sendToAirwave(startPlay);
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
	
	public void runStation() {
		Runtime run = Runtime.getRuntime();
		
	}

	public void setCurrentlyPlaying(String setAs) {
		currentlyPlaying = setAs;
	}

	public String getCurrentlyPlaying() {
		return currentlyPlaying;
	}
}
