package Button_builders;

import javax.swing.*;

public class ButtonEngineer {

    private ButtonBuilder buttonBuilder;

    public ButtonEngineer(ButtonBuilder buttonBuilder)
    {
        this.buttonBuilder = buttonBuilder;
    }

    public JButton getButton()
    {
        return this.buttonBuilder.getButton();
    }

    public void constructButton()
    {
        this.buttonBuilder.buildButton();
    }
}