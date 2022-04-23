import javax.swing.*;

public class IconFactory {

    public Icons getIcons(int type){
        if(type ==1) return  new redIcon();
        else if (type == 2) return  new orangeIcon();
        else if (type == 3) return  new yellowIcon();
        else if (type == 4) return  new greenIcon();
        else if (type == 5) return  new blueIcon();
        else if (type == 6) return  new indigoIcon();
        else if (type == 7) return  new violetIcon();

        return new whiteIcon();
    }


    public class redIcon implements Icons {

        @Override
        public Icon createIcon() {
            Icon redicon = new ImageIcon(getClass().getResource("IconFact/red.png"));
            return redicon;
        }
    }
    public class orangeIcon implements Icons{

        @Override
        public Icon createIcon() {
            Icon orange = new ImageIcon(getClass().getResource("IconFact/orange.png"));
            return orange;
        }
    }

    public class yellowIcon implements Icons {

        @Override
        public Icon createIcon() {
            Icon yellowicon = new ImageIcon(getClass().getResource("IconFact/yellow.png"));
            return yellowicon;
        }
    }

    public class blueIcon implements Icons{

        @Override
        public Icon createIcon() {
            Icon orange = new ImageIcon(getClass().getResource("IconFact/blue.png"));
            return orange;
        }
    }

    public class greenIcon implements Icons{

        @Override
        public Icon createIcon() {
            Icon orange = new ImageIcon(getClass().getResource("IconFact/green.png"));
            return orange;
        }
    }
    public class indigoIcon implements Icons{

        @Override
        public Icon createIcon() {
            Icon orange = new ImageIcon(getClass().getResource("IconFact/indigo.png"));
            return orange;
        }
    }

    public class violetIcon implements Icons{

        @Override
        public Icon createIcon() {
            Icon orange = new ImageIcon(getClass().getResource("IconFact/violet.png"));
            return orange;
        }
    }

    public class whiteIcon implements Icons {

        @Override
        public Icon createIcon() {
            Icon whiteicon = new ImageIcon(getClass().getResource("IconFact/violet.png"));
            return whiteicon;
        }
    }
}
