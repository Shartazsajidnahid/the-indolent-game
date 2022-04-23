import javax.swing.*;

public class yellowIcon implements Icons {

    @Override
    public Icon createIcon() {
        Icon yellowicon = new ImageIcon(getClass().getResource("yellow.png"));
        return yellowicon;
    }
}
