import Button_builders.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GUI implements ActionListener
{
	private JFrame f;

	private JLabel image;
	private JLabel l1, l2, l3, l4, l5, l6, l7, l8;
	private List<ButtonBuilder> buttonBuilders;
	private List<JButton> buttons;

	public GUI(List<ButtonBuilder> buttonBuilders)
	{

		f = new JFrame("The indolent game");
		this.buttons = new ArrayList<>();
		this.buttonBuilders = buttonBuilders;
//
//		b1 = new JButton();
//		b2 = new JButton();
//		b3 = new JButton();
//		b4 = new JButton();
//		b5 = new JButton();
		
		image = new JLabel();
		
		b1Clicked = 0;
		b2Clicked = 0;
		b3Clicked = 0;
		b4Clicked = 0;
		b5Clicked = 0;
	}
	public void buttonCreator1(){
		for (ButtonBuilder buttonBuilder : buttonBuilders) {
			this.buttons.add(buttonBuilder.getButton());
		}
		for (JButton button : buttons){
			f.add(button);
		}

	}

	public void displayImage()
	{
		ImageIcon picRed = new ImageIcon(this.getClass().getResource("Iconfiles/red.png"));
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
		    f.setIconImage(ImageIO.read(getClass().getResourceAsStream("Iconfiles/icon.png")));
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

	public void buttonListenerCreator1()
	{
		for (JButton button : buttons) {
			button.addActionListener(this);
		}
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