import javax.swing.*;

public class redIcon implements Icons {

    @Override
    public Icon createIcon() {
        Icon redicon = new ImageIcon(getClass().getResource("red.png"));
        return redicon;
    }
}

