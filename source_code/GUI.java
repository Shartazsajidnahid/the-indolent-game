import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GUI implements ActionListener
{
	private JFrame f;
	private JButton b1, b2, b3, b4, b5;
	private JLabel image;
	private JLabel l1, l2, l3, l4, l5, l6, l7, l8;

	public GUI()
	{
		f = new JFrame("The indolent game");
		
		b1 = new JButton();
		b2 = new JButton();
		b3 = new JButton();
		b4 = new JButton();
		b5 = new JButton();
		
		image = new JLabel();
		
		b1Clicked = 0;
		b2Clicked = 0;
		b3Clicked = 0;
		b4Clicked = 0;
		b5Clicked = 0;
	}
	
	public void buttonCreator ()
	{
		b1.setBounds(40, 300, 100, 40);
		b1.setLayout(new BorderLayout());
		b1.add(BorderLayout.NORTH,new JLabel("Click me"));
		b1.add(BorderLayout.SOUTH,new JLabel("More score"));
		f.add(b1);
		
		b2.setBounds(180, 300, 110, 40);
		b2.setLayout(new BorderLayout());
		b2.add(BorderLayout.NORTH,new JLabel("Upgrade"));
		b2.add(BorderLayout.SOUTH,new JLabel("Time Interval"));
		f.add(b2);
		
		b3.setBounds(330, 300, 180, 40);
		b3.setLayout(new BorderLayout());
		b3.add(BorderLayout.NORTH,new JLabel("Upgrade"));
		b3.add(BorderLayout.SOUTH,new JLabel("Amount per Time Interval"));
		f.add(b3);
		
		b4.setBounds(550, 300, 140, 40);
		b4.setLayout(new BorderLayout());
		b4.add(BorderLayout.NORTH,new JLabel("Upgrade"));
		b4.add(BorderLayout.SOUTH,new JLabel("Amount per Click"));
		f.add(b4);
		
		b5.setBounds(633, 0, 100, 40);
		b5.setLayout(new BorderLayout());
		b5.add(BorderLayout.NORTH,new JLabel("Quite"));
		b5.add(BorderLayout.SOUTH,new JLabel("Save game"));
		f.add(b5);
	}
	
	public void displayImage()
	{
		ImageIcon picRed = new ImageIcon(this.getClass().getResource("IconFact/red.png"));
	    image.setIcon(picRed);
	    image.setBounds(300, 111, 100, 100);
	    f.add(image);
	}
	
	public void displayText()
	{
		l1 = new JLabel("Score: ");
		l2 = new JLabel("Rate: ");
		l3 = new JLabel("Time Interval: ");
		l4 = new JLabel("Amount per Time Interval: ");
		l5 = new JLabel("Amount per Click: ");
		l6 = new JLabel("Creator: Vu Dinh Anh");
		l7 = new JLabel("Total coding and learning time: 17 hours");
		l8 = new JLabel("Try to reach the Purple square by clicking");
		
		l1.setBounds(500, 101, 250, 25);
		l2.setBounds(500, 126, 250, 25);
		l3.setBounds(500, 151, 250, 25);
		l4.setBounds(500, 176, 250, 25);
		l5.setBounds(500, 201, 250, 25);
		l6.setBounds(10, 10, 300, 25);
		l7.setBounds(10, 35, 300, 25);
		l8.setBounds(10, 60, 300, 25);
		
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(l6);
		f.add(l7);
		f.add(l8);
		
	}
	
	public void guiCreator() 
	{
		try {
		    f.setIconImage(ImageIO.read(getClass().getResourceAsStream("IconFact/icon.png")));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		f.setSize(750, 422);
		f.setLayout(null);
		f.setVisible(true);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void changeImage(Icon newicon)
	{
		image.setIcon(newicon);
	}

	public void changeText(double num1, double num2, double num3, double num4, double num5)
	{
		l1.setText("Score: " + String.format("%.03f", num1));
		l2.setText("Rate: " + num2);
		l3.setText("Time Interval: " + num3);
		l4.setText("Amount per Time Interval: " + num4);
		l5.setText("Amount per Click: " + num5);
	}
	

	public void buttonListenerCreator()
	{	
		b1.setActionCommand("b1");
		b1.addActionListener(this);
		
		b2.setActionCommand("b2");
		b2.addActionListener(this);
		
		b3.setActionCommand("b3");
		b3.addActionListener(this);
		
		b4.setActionCommand("b4");
		b4.addActionListener(this); 
		
		b5.setActionCommand("b5");
		b5.addActionListener(this);
	}
	
	public int b1Clicked, b2Clicked, b3Clicked, b4Clicked, b5Clicked;
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String target = e.getActionCommand();
		if ( target.equals("b1") )
		{
			//System.out.println("b1");
			b1Clicked = 1;
		}	
		if ( target.equals("b2") )
		{
			//System.out.println("b2");
			b2Clicked = 1;
		}		
		if ( target.equals("b3") )
		{
			//System.out.println("b3");
			b3Clicked = 1;
		}	
		if ( target.equals("b4") )
		{
			//System.out.println("b4");
			b4Clicked = 1;
		}
		if ( target.equals("b5") )
		{
			//System.out.println("b5");
			b5Clicked = 1;
		}
	}
}
