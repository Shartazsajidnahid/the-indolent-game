import java.io.File;
import java.io.IOException;

public class Main {
	private static File lastTimeData;
	private static  File playerData;
	private static LastTimePlayed lastTimePlayed;
	private static Player player;
	private static GUI gui;


	private static void readLastData(){
		try{ lastTimeData = new File("lastTimeData.txt");
			if (lastTimeData.createNewFile()) {}
		}
		catch (IOException e){
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	private static void readPlayerData(){
		try{ playerData = new File("playerData.txt");
			if (playerData.createNewFile()) {}
		}
		catch (IOException e){
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}



	private static void setupGUI() {
		gui = new GUI();
		gui.buttonCreator();
		gui.displayImage();
		gui.guiCreator();
		gui.displayText();
		gui.buttonListenerCreator();
	}

	private static void setupPlayer() {
		player = new Player(0, 10, 1, 1);
		player.readPlayerData();
		if (player.getScore() < 70) {
			player.processPlayerData_I(lastTimePlayed.totalSecondDiff());
		}
	}

	private static void setupLastTimePlayer() {
		lastTimePlayed = new LastTimePlayed();
		lastTimePlayed.checkFirstTime();
		lastTimePlayed.getSystemTime();
		lastTimePlayed.getLastTime();
		lastTimePlayed.timeDiff();
	}

	public static void main(String[] args) {

		readLastData();
		readPlayerData();
		setupLastTimePlayer();
		setupPlayer();
		setupGUI();

		Threads threads = new Threads(player, gui, lastTimePlayed);
		threads.runThreads();
	}
}
