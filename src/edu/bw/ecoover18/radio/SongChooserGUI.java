import java.io.File;
import javax.swing.FileNameExtensionFilter;
import javax.swing.JFileChooser;

public class SongChooserGUI {
	public SongChooserGUI() {

	}

	public void runDisplay() {

	}

	public void addSong() {
		JFIleChooser fileChoose = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("WAV only", "wav");
		fileChoose.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File selected = fileChoose.getSelectedFile();
			java.nio.file.Files.readAllBytes(Paths.get(selected.getAbsolutePath()));
		}
	}
}