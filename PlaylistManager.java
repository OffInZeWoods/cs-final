import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PlaylistManager {
	private ArrayList<String> playlist;
	private final String playlistFileName = "Playlist.txt";
	private AirwaveManager awManager = new AirwaveManager();

	public PlaylistManager() {
		playlist = new ArrayList<>();
	}

	public void runPlayer() {

	}

	public void addToPlaylist(String songName, int placement) {
		int playSize = playlist.size();
		if(placement > playSize) {
			placement = playSize-1;
		}

		playlist.add(placement, songName);
	}

	public void addAll(boolean shuffle) {
		try {
			FileReader readIn = new FileReader(new File("" + playlistFileName));
			Scanner read = new Scanner(readIn);
			ArrayList<String> temp = new ArrayList<>();
			while(read.hasNextLine()) {
				temp.add(read.nextLine());
			}

			if(shuffle) {
				Collections.shuffle(temp);
				Collections.shuffle(temp); //I always like to shuffle twice to ensure randomness
			}

			playlist = temp;
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public void removeFromPlaylist(String songName) {
		playlist.remove(songName);
	}

	public void removeFromPlaylist(int place) {
		playlist.remove(place);
	}

	public void removeAll() {
		playlist = new ArrayList<>();
	}

	public void moveSong(String songToMove, int moveTo) {
		this.removeFromPlaylist(songToMove);
		this.addToPlaylist(songToMove, moveTo);
	}

	public void moveSong(int start, int end) {
		this.moveSong(playlist.get(start), end);
	}

	public void replaySong() {
		awManager.sendToAirwave(awManager.getCurrentlyPlaying());

	}

	public ArrayList<String> getPlaylist() {
		return playlist;
	}
}

