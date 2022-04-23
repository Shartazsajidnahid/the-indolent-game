import java.io.File;
import java.io.IOException;
import java.lang.Thread;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) 
	{
		//here yre
		try{File lastTimeData = new File("lastTimeData.txt"); if (lastTimeData.createNewFile()) {} }catch (IOException e){System.out.println("An error occurred.");e.printStackTrace();}
		
		try{File playerData = new File("playerData.txt"); if (playerData.createNewFile()) {} } catch (IOException e){System.out.println("An error occurred.");e.printStackTrace();}
		
		LastTimePlayed lt = new LastTimePlayed();
		lt.checkFirstTime();
		lt.getSystemTime();
		lt.getLastTime();
		lt.timeDiff();
		
		Player p = new Player(0, 1000, 1, 1);
		p.readPlayerData();
		if (p.getScore() < 7000000) 
		{
			p.processPlayerData_I(lt.totalSecondDiff());
		}
		
		GUI g = new GUI();
		g.buttonCreator();
		g.displayImage();
		g.guiCreator();
		g.displayText();
		g.buttonListenerCreator();
		
		Thread t1 = new Thread() // update info in display
		{ 	
			public void run()
			{	
				while(true)
				{
					if (p.getScore() > 7000000) break;
					p.rate_up();
					g.changeText(p.getScore(), p.getRate(), p.getTimeInterval(), p.getAmountPerTimeInterval(), p.getAmountPerClick());
				}
			}
		};
		t1.start();
		
		Thread t2 = new Thread() // increase score over time
		{ 	
			public void run()
			{	
				while(true)
				{
					if (p.getScore() > 7000000) break;
					p.processPlayerData_A();
					try
					{
						TimeUnit.SECONDS.sleep(1);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		};
		t2.start();
		
		Thread t3 = new Thread() // animations of square
		{ 	
			public void run()
			{	
				while(true)
				{
					if (p.getScore() > 0 && p.getScore() <= 1000000)
					{
						g.changeImage(1);
					}
					if (p.getScore() > 1000001 && p.getScore() <= 2000000)
					{
						g.changeImage(2);
					}
					if (p.getScore() > 2000001 && p.getScore() <= 3000000)
					{
						g.changeImage(3);
					}
					if (p.getScore() > 3000001 && p.getScore() <= 4000000)
					{
						g.changeImage(4);
					}
					if (p.getScore() > 4000001 && p.getScore() <= 5000000)
					{
						g.changeImage(5);
					}
					if (p.getScore() > 5000001 && p.getScore() <= 6000000)
					{
						g.changeImage(6);
					}
					if (p.getScore() > 6000001 && p.getScore() <= 7000000)
					{
						g.changeImage(7);
					}
					if (p.getScore() > 7000000) 
					{	
						g.changeImage(7);
						break;
					}
				}
			}
		};
		t3.start();
		
		Thread t4 = new Thread() // update info in files
		{ 	
			public void run()
			{	
				while(true)
				{
					if (g.b5Clicked >= 1)
					{
						break;
					}
					lt.getSystemTime();
					lt.archiveData();
					p.archivePlayerData();
					if (p.getScore() > 7000000) break;
				}
			}
		};
		t4.start();

		Thread t5 = new Thread() // buttons
				{ 	
					public void run()
					{	
						while(true)
						{
							System.out.println(g.b1Clicked);
							System.out.println(g.b2Clicked);
							System.out.println(g.b3Clicked);
							System.out.println(g.b4Clicked);
							System.out.println(g.b5Clicked);
							if (g.b1Clicked >= 1)
							{
								p.processPlayerData_C();
								g.b1Clicked = 0;
							}
							if (g.b2Clicked >= 1)
							{
								p.lvl_TI_up();
								g.b2Clicked = 0;
							}
							if (g.b3Clicked >= 1)
							{
								p.lvl_APTI_up();
								g.b3Clicked = 0;
							}
							if (g.b4Clicked >= 1)
							{
								p.lvl_APC_up();
								g.b4Clicked = 0;
							}
							if (g.b5Clicked >= 1)
							{
								lt.getSystemTime();
								lt.archiveData();
								p.archivePlayerData();
								g.b5Clicked = 0;
								System.exit(0);
							}
							System.out.flush();
							System.out.close();
						}
					}
				};
		t5.start();
	}

}
