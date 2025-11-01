import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class VisualFrame extends JFrame implements ActionListener {

    int previousNumber = 0;
    boolean numberSelected = false;
    int index;

    JPanel Buttons = new JPanel();
    JPanel Game = new JPanel();
    JButton newGame = new JButton("New Game");

    JButton previousButton = null;
    JButton currentButton = null;

    JButton n0 = new JButton("0");
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

    Border border = n0.getBorder();

    public VisualFrame() {
        this.add(Buttons, BorderLayout.NORTH);
        Buttons.setLayout(new BoxLayout(Buttons, BoxLayout.X_AXIS));
        Buttons.setBorder(new EmptyBorder(10, 0, 5, 0));
        Buttons.add(newGame);

        this.add(Game, BorderLayout.CENTER);
        Game.setLayout(new GridLayout(4, 4, 5, 5));

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

        buttonList.add(n0);
        buttonList.add(n1);
        buttonList.add(n2);
        buttonList.add(n3);
        buttonList.add(n4);
        buttonList.add(n5);
        buttonList.add(n6);
        buttonList.add(n7);
        buttonList.add(n8);
        buttonList.add(n9);
        buttonList.add(n10);
        buttonList.add(n11);
        buttonList.add(n12);
        buttonList.add(n13);
        buttonList.add(n14);
        buttonList.add(n15);

        newGame.addActionListener(this);

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
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setAll();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == newGame) {
            showConfirmWindow();
        }

        if (source == n0) buttonPress(0, n0);
        if (source == n1) buttonPress(1, n1);
        if (source == n2) buttonPress(2, n2);
        if (source == n3) buttonPress(3, n3);
        if (source == n4) buttonPress(4, n4);
        if (source == n5) buttonPress(5, n5);
        if (source == n6) buttonPress(6, n6);
        if (source == n7) buttonPress(7, n7);
        if (source == n8) buttonPress(8, n8);
        if (source == n9) buttonPress(9, n9);
        if (source == n10) buttonPress(10, n10);
        if (source == n11) buttonPress(11, n11);
        if (source == n12) buttonPress(12, n12);
        if (source == n13) buttonPress(13, n13);
        if (source == n14) buttonPress(14, n14);
        if (source == n15) buttonPress(15, n15);
    }

    public boolean isBlank(int index) {
        return tile.tiles.get(index) == 0;
    }

    public boolean isBlankNear(int index) {
        int size = tile.tiles.size();
        return (index - 1 >= 0 && tile.tiles.get(index - 1) == 0)
                || (index + 1 < size && tile.tiles.get(index + 1) == 0)
                || (index - 4 >= 0 && tile.tiles.get(index - 4) == 0)
                || (index + 4 < size && tile.tiles.get(index + 4) == 0);
    }

    public void buttonPress(int index, JButton currentButton) {
        if (!isBlank(index)) {
            if (isBlankNear(index)) {
                int blankIndex = tile.tiles.indexOf(0);
                JButton blankButton = buttonList.get(blankIndex);

                Collections.swap(tile.tiles, index, blankIndex);

                currentButton.setText("");
                setColor(true, currentButton);
                blankButton.setText(String.valueOf(tile.tiles.get(blankIndex)));
                setColor(false, blankButton);

                tile.numericalOrder();
            }
        } else {
            previousButton = currentButton;
            previousNumber = index;
            numberSelected = true;
        }
    }

    public void setColor(boolean darkOrRegular, JButton button) {
        button.setOpaque(true);
        if (darkOrRegular) {
            button.setText("");
            button.setBorder(null);
            button.setContentAreaFilled(false);
            button.setFocusPainted(false);
        } else {
            button.setContentAreaFilled(true);
            button.setBorder(border);
        }
    }

    ArrayList<JButton> buttonList = new ArrayList<>();

    public JButton find0Button() {
        int index = tile.tiles.indexOf(0);
        return buttonList.get(index);
    }

    public void setAll() {
        for (int i = 0; i < buttonList.size(); i++) {
            int value = tile.tiles.get(i);
            JButton button = buttonList.get(i);
            button.setText(value == 0 ? "" : String.valueOf(value));
        }
        setColor(true, find0Button());
    }

    public void showConfirmWindow() {
        JFrame confirmWindow = new JFrame();
        JPanel buttons = new JPanel();
        JPanel text = new JPanel(new BorderLayout());
        confirmWindow.setResizable(false);
        JLabel startNew = new JLabel("Start new game?", SwingConstants.CENTER);
        JButton positive = new JButton("Yes");
        JButton negative = new JButton("No");
        confirmWindow.add(text, BorderLayout.NORTH);
        confirmWindow.add(buttons);
        text.add(startNew);
        buttons.add(positive);
        buttons.add(negative);
        buttons.setBorder(new EmptyBorder(15, 15, 15, 15));
        text.setBorder(new EmptyBorder(15, 5, 0, 5));
        confirmWindow.pack();
        confirmWindow.setLocationRelativeTo(null);
        confirmWindow.setVisible(true);
        positive.addActionListener(e -> {
            tile.startTiles();
            setAll();
            repaint();
            confirmWindow.dispose();
        });
        negative.addActionListener(e -> confirmWindow.dispose());
    }
}
