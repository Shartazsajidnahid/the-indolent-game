import javax.swing.*;
import java.lang.Thread;
import java.util.concurrent.TimeUnit;

public class Threads {

    private Player player;
    private GUI gui;
    private LastTimePlayed lastTimePlayed;

    public Threads(Player p, GUI g, LastTimePlayed lt) {
        this.player = p;
        this.gui = g;
        this.lastTimePlayed = lt;
    }

    public void runThreads(){

        Thread t1 = new Thread() // update info in display
        {
            public void run()
            { // update info in display
                System.out.println("thread1");
                while(true)
                {
                    if (player.getScore() > 7000) break;
                    player.rate_up();
                    gui.changeText(player);
                }
            }
        };
        t1.start();

        Thread t2 = new Thread() // increase score over time
        {
            public void run()
            {  //increase score over time
                while(true)
                {
                    System.out.println("thread2");
                    if (player.getScore() > 7000) break;
                    player.processPlayerData_A();
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
            { // animations of square
                IconFactory iconFactory = new IconFactory();
                System.out.println("thread3");
                while(true)
                {
                    IconFactory.Icons icons = iconFactory.getIcons(player.getScore());
                    Icon newicon = icons.createIcon();
                    gui.changeImage(newicon);
                }
            }
        };
        t3.start();

        Thread t4 = new Thread() // update info in files
        {

            public void run()
            { // update info in files
                System.out.println("thread4");
                while(true)
                {
                    if (gui.getB5Clicked()>= 1)
                    {
                        break;
                    }
                    lastTimePlayed.getSystemTime();
                    lastTimePlayed.archiveData();
                    player.archivePlayerData();
                    if (player.getScore() > 7000) break;
                }
            }
        };
        t4.start();

        Thread t5 = new Thread() // buttons
        {
            public void run()
            { // buttons
                System.out.println("thread5");
                while(true)
                {
                    if (gui.getB1Clicked() >= 1)
                    {
                        player.processPlayerData_C();
                        gui.setB1Clicked(0);
                    }
                    if (gui.getB2Clicked() >= 1)
                    {
                        player.lvl_TI_up();
                        gui.setB2Clicked(0);
                    }
                    if (gui.getB3Clicked() >= 1)
                    {
                        player.lvl_APTI_up();
                        gui.setB3Clicked(0);
                    }
                    if (gui.getB4Clicked() >= 1)
                    {
                        player.lvl_APC_up();
                        gui.setB4Clicked(0);
                    }
                    if (gui.getB5Clicked() >= 1)
                    {
                        lastTimePlayed.getSystemTime();
                        lastTimePlayed.archiveData();
                        player.archivePlayerData();
                        gui.setB5Clicked(0);
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
