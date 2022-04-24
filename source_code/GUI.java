import Button_builders.*;

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

		image = new JLabel();

	}
	public void buttonCreator1(){
		for (ButtonBuilder buttonBuilder : buttonBuilders) {
			ButtonEngineer buttonEngineer = new ButtonEngineer(buttonBuilder);
			buttonEngineer.constructButton();
			this.buttons.add(buttonEngineer.getButton());
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
		setIcon();
		f.setSize(750, 422);
		f.setLayout(null);
		f.setVisible(true);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setIcon() {
		try {
		    f.setIconImage(ImageIO.read(getClass().getResourceAsStream("Iconfiles/icon.png")));
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

	public void changeImage(Icon newicon)
	{
		image.setIcon(newicon);
	}

	public void changeText(Player player)
	{
		l1.setText("Score: " + String.format("%.03f", player.getScore()));
		l2.setText("Rate: " + player.getRate());
		l3.setText("Time Interval: " + player.getTimeInterval());
		l4.setText("Amount per Time Interval: " + player.getAmountPerTimeInterval());
		l5.setText("Amount per Click: " + player.getAmountPerClick());
	}

	public void buttonListenerCreator1()
	{
		for (JButton button : buttons) {
			button.addActionListener(this);
		}
	}
	
	private int b1Clicked, b2Clicked, b3Clicked, b4Clicked, b5Clicked;

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

	public int getB2Clicked() {
	return b2Clicked;
	}

	public void setB2Clicked(int b2Clicked) {
		this.b2Clicked = b2Clicked;
	}

	public int getB3Clicked() {
		return b3Clicked;
	}

	public void setB3Clicked(int b3Clicked) {
		this.b3Clicked = b3Clicked;
	}

	public int getB4Clicked() {
		return b4Clicked;
	}

	public void setB4Clicked(int b4Clicked) {
		this.b4Clicked = b4Clicked;
	}

	public int getB5Clicked() {
		return b5Clicked;
	}

	public void setB5Clicked(int b5Clicked) {
		this.b5Clicked = b5Clicked;
	}
	public int getB1Clicked(){
		return b1Clicked;
	}
	public void setB1Clicked(int x){
		this.b1Clicked = x;
	}
}