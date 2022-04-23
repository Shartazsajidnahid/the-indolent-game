import javax.swing.*;

public class IconFactory {

    public Icons getIcons(double score){
        if (score > 0 && score <= 10) return  new redIcon();
        else if (score >= 10 && score <= 20) return  new orangeIcon();
        else if (score > 20 && score <= 30) return  new yellowIcon();
        else if (score > 30 && score <= 40) return  new greenIcon();
        else if (score > 40 && score <= 50) return  new blueIcon();
        else if (score > 50 && score <= 60) return  new indigoIcon();
        else if (score > 60 && score <= 70) return  new violetIcon();
        return new violetIcon();
    }

    public interface Icons {
        public Icon createIcon();
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
