import javax.swing.*;

public class whiteIcon implements Icons {

    @Override
    public Icon createIcon() {
        Icon whiteicon = new ImageIcon(getClass().getResource("whitepng"));
        return whiteicon;
    }
}
