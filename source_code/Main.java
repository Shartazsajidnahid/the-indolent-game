import java.io.File;
import java.io.IOException;

public class Main {
	private File lastTimeData;
	private File playerData;
	private LastTimePlayed lastTimePlayed;
	private Player player;
	private GUI gui;


	private void readLastData(){
		try{ lastTimeData = new File("lastTimeData.txt");
			if (lastTimeData.createNewFile()) {}
		}
		catch (IOException e){
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	private void readPlayerData(){
		try{ playerData = new File("playerData.txt");
			if (playerData.createNewFile()) {}
		}
		catch (IOException e){
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}



	private void setupGUI() {
		gui = new GUI();
		gui.buttonCreator();
		gui.displayImage();
		gui.guiCreator();
		gui.displayText();
		gui.buttonListenerCreator();
	}

	private void setupPlayer() {
		player = new Player(0, 10, 1, 1);
		player.readPlayerData();
		if (player.getScore() < 70) {
			player.processPlayerData_I(lastTimePlayed.totalSecondDiff());
		}
	}

	private void setupLastTimePlayer() {
		lastTimePlayed = new LastTimePlayed();
		lastTimePlayed.checkFirstTime();
		lastTimePlayed.getSystemTime();
		lastTimePlayed.getLastTime();
		lastTimePlayed.timeDiff();
	}

	public void main(String[] args) {

		readLastData();
		readPlayerData();
		setupLastTimePlayer();
		setupPlayer();
		setupGUI();

		Threads threads = new Threads(player, gui, lastTimePlayed);
		threads.runThreads();
	}
}
