import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualFrame extends JFrame implements ActionListener {


    int numberToSwitchTo = 0;
    boolean numberSelected = false;
    int index;

    JPanel Buttons = new JPanel();
    JPanel Game = new JPanel();
    JButton newGame = new JButton("New Game");

    JButton previousButton = null;
    JButton n0 = new JButton("blank");
    JButton n1 = new JButton("1");
    JButton n2 = new JButton("2");
    JButton n3 = new JButton("3");
    JButton n4 = new JButton("4");
    JButton n5 = new JButton("5");
    JButton n6 = new JButton("6");
    JButton n7 = new JButton("7");
    JButton n8 = new JButton("8");
    JButton n9 = new JButton("9");
    JButton n10 = new JButton("10");
    JButton n11 = new JButton("11");
    JButton n12 = new JButton("12");
    JButton n13 = new JButton("13");
    JButton n14 = new JButton("14");
    JButton n15 = new JButton("15");


    public VisualFrame() {
        this.add(Buttons, BorderLayout.NORTH);
        Buttons.setLayout(new BoxLayout(Buttons, BoxLayout.X_AXIS));
        Buttons.setBorder(new EmptyBorder(10, 0, 5, 0));
        Buttons.add(newGame);

        this.add(Game, BorderLayout.CENTER);
        Game.setLayout(new GridLayout(4, 5));

        Game.add(n0);
        Game.add(n1);
        Game.add(n2);
        Game.add(n3);
        Game.add(n4);
        Game.add(n5);
        Game.add(n6);
        Game.add(n7);
        Game.add(n8);
        Game.add(n9);
        Game.add(n10);
        Game.add(n11);
        Game.add(n12);
        Game.add(n13);
        Game.add(n14);
        Game.add(n15);

        n0.addActionListener(this);
        n7.addActionListener(this);
        n1.addActionListener(this);
        n8.addActionListener(this);
        n2.addActionListener(this);
        n9.addActionListener(this);
        n3.addActionListener(this);
        n10.addActionListener(this);
        n4.addActionListener(this);
        n11.addActionListener(this);
        n5.addActionListener(this);
        n12.addActionListener(this);
        n6.addActionListener(this);
        n13.addActionListener(this);
        n14.addActionListener(this);
        n15.addActionListener(this);


        Game.setBorder(new EmptyBorder(5, 5, 0, 5));
        setVisible(true);
        setSize(700, 700);
        setMinimumSize(new Dimension(400, 400));
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        n0.setText(String.valueOf(tile.tiles.getFirst()));
        n1.setText(String.valueOf(tile.tiles.get(1)));
        n2.setText(String.valueOf(tile.tiles.get(2)));
        n3.setText(String.valueOf(tile.tiles.get(3)));
        n4.setText(String.valueOf(tile.tiles.get(4)));
        n5.setText(String.valueOf(tile.tiles.get(5)));
        n6.setText(String.valueOf(tile.tiles.get(6)));
        n7.setText(String.valueOf(tile.tiles.get(7)));
        n8.setText(String.valueOf(tile.tiles.get(8)));
        n9.setText(String.valueOf(tile.tiles.get(9)));
        n10.setText(String.valueOf(tile.tiles.get(10)));
        n11.setText(String.valueOf(tile.tiles.get(11)));
        n12.setText(String.valueOf(tile.tiles.get(12)));
        n13.setText(String.valueOf(tile.tiles.get(13)));
        n14.setText(String.valueOf(tile.tiles.get(14)));
        n15.setText(String.valueOf(tile.tiles.get(15)));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == n0) {
            System.out.println(tile.tiles.getFirst());
            index = 0;
            if(!isBlank(index)) {
                isBlankNear(index);
            }
        }

        if (source == n1) {
            System.out.println(tile.tiles.get(1));
            index = 1;
            if(!isBlank(index)) {
                isBlankNear(index);
            }
        }

        if (source == n2) {
            System.out.println(tile.tiles.get(2));
            index = 2;
            if(!isBlank(index)) {
                isBlankNear(index);
            }
        }

        if (source == n3) {
            System.out.println(tile.tiles.get(3));
            index = 3;
            if(!isBlank(index)) {
                isBlankNear(index);
            }
        }

        if (source == n4) {
            System.out.println(tile.tiles.get(4));
            index = 4;
            if(!isBlank(index)) {
                isBlankNear(index);
            }
        }

        if (source == n5) {
            System.out.println(tile.tiles.get(5));
            index = 5;
            if(!isBlank(index)) {
                isBlankNear(index);
            }
        }

        if (source == n6) {
            System.out.println(tile.tiles.get(6));
            index = 6;
            if(!isBlank(index)) {
                isBlankNear(index);
            }
        }

        if (source == n7) {
            System.out.println(tile.tiles.get(7));
            index = 7;
            if(!isBlank(index)) {
                isBlankNear(index);
            }
        }

        if (source == n8) {
            System.out.println(tile.tiles.get(8));
            index = 8;
            if(!isBlank(index)) {
                isBlankNear(index);
            }
        }

        if (source == n9) {
            System.out.println(tile.tiles.get(9));
            index = 9;
            if(!isBlank(index)) {
                isBlankNear(index);
            }
        }

        if (source == n10) {
            System.out.println(tile.tiles.get(10));
            index = 10;
            if(!isBlank(index)) {
                isBlankNear(index);
            }
        }

        if (source == n11) {
            System.out.println(tile.tiles.get(11));
            index = 11;
            if(!isBlank(index)) {
                isBlankNear(index);
            }
        }

        if (source == n12) {
            System.out.println(tile.tiles.get(12));
            index = 12;
            if(!isBlank(index)) {
                isBlankNear(index);
            }
        }

        if (source == n13) {
            System.out.println(tile.tiles.get(13));
            index = 13;
            if(!isBlank(index)) {
                isBlankNear(index);
            }
        }

        if (source == n14) {
            System.out.println(tile.tiles.get(14));
            index = 14;
            if(!isBlank(index)) {
                isBlankNear(index);
            }
        }

        if (source == n15) {
            System.out.println(tile.tiles.get(15));
            index = 15;
            if(!isBlank(index)) {
                isBlankNear(index);
            }
        }

    }

    public boolean isBlank(int index){
        if (tile.tiles.get(index) == 0){
            System.out.println("is blank");
            return true;
        }else return false;
    }

    public boolean isBlankNear(int index) {
        int size = tile.tiles.size();

        if (index-1 > 0 && tile.tiles.get(index - 1) == 0

                || index + 1 < size && tile.tiles.get(index + 1) == 0

                || index -4 > 0 && tile.tiles.get(index - 4) == 0

                || index + 4 < size && tile.tiles.get(index + 4) == 0) {

            System.out.println("yes");
            return true;
        } else System.out.println("no");
            return false;

    }
}




