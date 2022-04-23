import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;

public class Player
{
	private double score, rate, timeInterval, amountPerTimeInterval, amountPerClick;
	private double lvl_TI, lvl_APTI, lvl_APC;

	public Player(double score, double timeInterval, double amountPerTimeInterval, double amountPerClick)
	{
		this.score = score;
		this.timeInterval = timeInterval;
		this.amountPerTimeInterval = amountPerTimeInterval;
		this.amountPerClick = amountPerClick;
		rate = amountPerTimeInterval / timeInterval;
		lvl_TI = 0;
		lvl_APTI = 0;
		lvl_APC = 0;
	}

	public void archivePlayerData()
	{
		try
		{
			FileWriter playerData = new FileWriter("playerData.txt");
			playerData.write(score + " " + rate + " " + timeInterval + " " + amountPerTimeInterval + " " + amountPerClick + " " + lvl_TI + " " + lvl_APTI + " " + lvl_APC);
			playerData.close();
			
      	}
      	catch (IOException e)
   		{
      		System.out.println("An error occurred.");
      		e.printStackTrace();
   		}
	}

	public void readPlayerData()
	{
		try
		{
			File playerData = new File("playerData.txt");
			Scanner reader = new Scanner(playerData);
			BufferedReader br = new BufferedReader(new FileReader("playerData.txt"));
			try
			{
				if (br.readLine() == null)
				{
					archivePlayerData();
				}
				else 
				{
					score = reader.nextDouble();
					rate = reader.nextDouble();
					timeInterval = reader.nextDouble();
					amountPerTimeInterval = reader.nextDouble();
					amountPerClick = reader.nextDouble();
					lvl_TI = reader.nextDouble();
					lvl_APTI = reader.nextDouble();
					lvl_APC = reader.nextDouble();
					reader.close();
				}
				br.close();
			}
			catch (IOException e)
			{
				System.out.println("An error occurred");
				e.printStackTrace();
			}
			
		}
		catch (FileNotFoundException e)
		{
			System.out.println("An error occurred.");
      		e.printStackTrace();
		}
	}

	// public void displayPlayerData()
	// {
	// 	System.out.println("Score: " + score + " Rate: " + rate + " Time interval: " + timeInterval + " Amount per time interval: " + amountPerTimeInterval + " Amount per click: " + amountPerClick);
	// }
	private boolean checkInCond(double lvl){
		if(lvl > -1 && lvl < 3) return true;
		else return false;
	}
	private boolean checkUpCond(double lvl){
		if( (score>=1000) && checkInCond(lvl)) return true;
		else return false;
	}

	public void lvl_TI_up()
	{
		if(checkUpCond(lvl_TI)){
			lvl_TI++;
			timeInterval = timeInterval / 10;
			score -= 1000;
		}
		//System.out.println("Level of time interval: " + lvl_TI);
	}

	public void lvl_APTI_up()
	{
		if(checkUpCond(lvl_APTI)){
			lvl_APTI++;
			amountPerTimeInterval = amountPerTimeInterval * 10;
			score -= 1000;
		}
		//System.out.println("Level of amount per time interval: " + lvl_APTI);
	}

	public void lvl_APC_up()
	{
		if(checkUpCond(lvl_TI)){
			lvl_APC++;
			amountPerClick = amountPerClick * 10;
			score -= 1000;
		}
		//System.out.println("Level of amount per click: " + lvl_APC);
	}
	
	public void rate_up()
	{
		rate = amountPerTimeInterval / timeInterval;
	}

	public void processPlayerData_A()
	{
		score += rate;
	}

	public void processPlayerData_C()
	{
		score += amountPerClick;
	}

	public void processPlayerData_I(long totalSecondDiff)
	{
		score = score + rate * ((double)totalSecondDiff);
	}

	public double getScore()
	{
		return score;
	}

	public double getRate()
	{
		return rate;
	}

	public double getTimeInterval()
	{
		return timeInterval;
	}

	public double getAmountPerTimeInterval()
	{
		return amountPerTimeInterval;
	}

	public double getAmountPerClick()
	{
		return amountPerClick;
	}
}