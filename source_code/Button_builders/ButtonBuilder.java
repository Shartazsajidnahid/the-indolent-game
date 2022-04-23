package Button_builders;

import javax.swing.*;
import java.awt.*;


public interface ButtonBuilder {

    public void setbounds();

    public void setlayout();

    public void addNorth();

    public void addSouth();

    public void setActionCommand();

    public JButton getButton();


    public class button1Builder implements ButtonBuilder {
        private JButton newbutton;
        private BorderLayout newBorderlayout;

        @Override
        public void setbounds() {
            this.newbutton.setBounds(40, 300, 100, 40);
        }

        @Override
        public void setlayout() {
            this.newbutton.setLayout(newBorderlayout);
        }

        @Override
        public void addNorth() {
            this.newbutton.add(newBorderlayout.NORTH, new JLabel("Click me"));
        }

        @Override
        public void addSouth() {
            this.newbutton.add(newBorderlayout.SOUTH, new JLabel("More score"));
        }

        @Override
        public void setActionCommand() {
            this.newbutton.setActionCommand("b1");
        }

        @Override
        public JButton getButton() {
            this.newbutton = new JButton();
            this.newBorderlayout = new BorderLayout();
            setbounds();
            setlayout();
            addNorth();
            addSouth();
            setActionCommand();
            return this.newbutton;
        }
    }

    public class button2Builder implements ButtonBuilder {
        private JButton newbutton;
        private BorderLayout newBorderlayout;

        @Override
        public void setbounds() {
            this.newbutton.setBounds(180, 300, 110, 40);
        }

        @Override
        public void setlayout() {
            this.newbutton.setLayout(newBorderlayout);
        }

        @Override
        public void addNorth( ) {
            this.newbutton.add(newBorderlayout.NORTH, new JLabel("Upgrade"));
        }

        @Override
        public void addSouth() {
            this.newbutton.add(newBorderlayout.SOUTH, new JLabel("Time Interval"));
        }

        @Override
        public void setActionCommand() {
            this.newbutton.setActionCommand("b2");
        }

        @Override
        public JButton getButton() {
            this.newbutton = new JButton();
            this.newBorderlayout = new BorderLayout();
            setbounds();
            setlayout();
            addNorth();
            addSouth();
            setActionCommand();
            return this.newbutton;
        }
    }

    public class button3Builder implements ButtonBuilder {
        private JButton newbutton;
        private BorderLayout newBorderlayout;

        @Override
        public void setbounds() {
            this.newbutton.setBounds(330, 300, 180, 40);
        }

        @Override
        public void setlayout() {
            this.newbutton.setLayout(newBorderlayout);        }

        @Override
        public void addNorth( ) {
            this.newbutton.add(newBorderlayout.NORTH, new JLabel("Upgrade"));
        }

        @Override
        public void addSouth() {
            this.newbutton.add(newBorderlayout.SOUTH, new JLabel("Amount per Time Interval"));
        }

        @Override
        public void setActionCommand() {
            this.newbutton.setActionCommand("b3");
        }

        @Override
        public JButton getButton() {
            this.newbutton = new JButton();
            this.newBorderlayout = new BorderLayout();
            setbounds();
            setlayout();
            addNorth();
            addSouth();
            setActionCommand();
            return this.newbutton;
        }
    }

    public class button4Builder implements ButtonBuilder {
        private JButton newbutton;
        private BorderLayout newBorderlayout;

        @Override
        public void setbounds() {
            this.newbutton.setBounds(550, 300, 140, 40);
        }

        @Override
        public void setlayout() {
            this.newbutton.setLayout(newBorderlayout);        }

        @Override
        public void addNorth( ) {
            this.newbutton.add(newBorderlayout.NORTH, new JLabel("Upgrade"));
        }

        @Override
        public void addSouth() {
            this.newbutton.add(newBorderlayout.SOUTH, new JLabel("Amount per Click"));
        }

        @Override
        public void setActionCommand() {
            this.newbutton.setActionCommand("b4");
        }

        @Override
        public JButton getButton() {
            this.newbutton = new JButton();
            this.newBorderlayout = new BorderLayout();
            setbounds();
            setlayout();
            addNorth();
            addSouth();
            setActionCommand();
            return this.newbutton;
        }
    }

    public class button5Builder implements ButtonBuilder {
        private JButton newbutton;
        private BorderLayout newBorderlayout;

        @Override
        public void setbounds() {
            this.newbutton.setBounds(633, 0, 100, 40);
        }

        @Override
        public void setlayout() {
            this.newbutton.setLayout(newBorderlayout);        }

        @Override
        public void addNorth( ) {
            this.newbutton.add(newBorderlayout.NORTH, new JLabel("Quite"));
        }

        @Override
        public void addSouth() {
            this.newbutton.add(newBorderlayout.SOUTH, new JLabel("Save game"));
        }

        @Override
        public void setActionCommand() {
            this.newbutton.setActionCommand("b5");
        }

        @Override
        public JButton getButton() {
            this.newbutton = new JButton();
            this.newBorderlayout = new BorderLayout();
            setbounds();
            setlayout();
            addNorth();
            addSouth();
            setActionCommand();
            return this.newbutton;
        }
    }
}