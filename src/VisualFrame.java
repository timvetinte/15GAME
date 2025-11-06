import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class VisualFrame extends JFrame implements ActionListener {

    JPanel Buttons = new JPanel();
    JPanel Game = new JPanel();
    JButton newGame = new JButton("New Game");
    JLabel moveCounter = new JLabel("Moves: 0");
    JLabel highScore = new JLabel("Highscore: 0");
    int hS = 0;


    JButton n0 = new JButton();
    JButton n1 = new JButton();
    JButton n2 = new JButton();
    JButton n3 = new JButton();
    JButton n4 = new JButton();
    JButton n5 = new JButton();
    JButton n6 = new JButton();
    JButton n7 = new JButton();
    JButton n8 = new JButton();
    JButton n9 = new JButton();
    JButton n10 = new JButton();
    JButton n11 = new JButton();
    JButton n12 = new JButton();
    JButton n13 = new JButton();
    JButton n14 = new JButton();
    JButton n15 = new JButton();

    Border border = n0.getBorder();

    public VisualFrame() {

        this.add(Buttons, BorderLayout.NORTH);
        Buttons.setLayout(new BoxLayout(Buttons, BoxLayout.X_AXIS));
        Buttons.setBorder(new EmptyBorder(10, 0, 5, 0));
        Buttons.add(newGame);
        Buttons.add(Box.createHorizontalStrut(15));
        Buttons.add(highScore);
        Buttons.add(Box.createHorizontalStrut(20));
        Buttons.add(moveCounter);
        Buttons.setBackground(Color.WHITE);


        this.add(Game, BorderLayout.CENTER);
        Game.setLayout(new GridLayout(4, 4, 5, 5));


        //ADDING ALL BUTTONS TO THEIR RESPECTIVE PANEL
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
        Game.setBorder(new EmptyBorder(5, 5, 5, 5));

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

        for(JButton button : buttonList){
            button.setFont(button.getFont().deriveFont(30f));
        }

        //ACTION LISTENERS
        newGame.addActionListener(this);
        n0.addActionListener(this);
        n1.addActionListener(this);
        n2.addActionListener(this);
        n3.addActionListener(this);
        n4.addActionListener(this);
        n5.addActionListener(this);
        n6.addActionListener(this);
        n7.addActionListener(this);
        n8.addActionListener(this);
        n9.addActionListener(this);
        n10.addActionListener(this);
        n11.addActionListener(this);
        n12.addActionListener(this);
        n13.addActionListener(this);
        n14.addActionListener(this);
        n15.addActionListener(this);

        setVisible(true);
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setAll();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        //NEW GAME
        if (source == newGame) {
            showConfirmWindow();
        }

        //EACH BUTTONS ACTION, LINKS TO BUTTONPRESS WITH BUTTON NAME AND ARRAYLIST INDEX
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

    //CHECKER FOR IF BUTTON IS BLANK
    public boolean isBlank(int index) {
        return tile.tiles.get(index) == 0;
    }


    //CHECKER FOR IF BLANK IS NEAR
    public boolean isBlankNear(int index) {
        int size = tile.tiles.size();
        return (index - 1 >= 0 && tile.tiles.get(index - 1) == 0)
                || (index + 1 < size && tile.tiles.get(index + 1) == 0)
                || (index - 4 >= 0 && tile.tiles.get(index - 4) == 0)
                || (index + 4 < size && tile.tiles.get(index + 4) == 0);
    }


    //WHAT HAPPENS WHEN EACH BUTTON IS PRESSED
    public void buttonPress(int index, JButton currentButton) {
        if (!isBlank(index)) {
            if (isBlankNear(index)) {

                //INDEX OF BLANK TILE
                int blankIndex = tile.tiles.indexOf(0);
                //BUTTON OF BLANK TILE
                JButton blankButton = buttonList.get(blankIndex);

                //SWAPS TEXT
                blankButton.setText(String.valueOf(tile.tiles.get(index)));

                //SWAPS INDEX OF TILE SELECTED AND BLANK
                Collections.swap(tile.tiles, index, blankIndex);

                //CHANGES "BLANKNESS" AND TEXT
                setColor(true, currentButton);
                setColor(false, blankButton);

                //UPDATE MOVES
                moveCounter.setText("Moves: " + tile.moveCounter(false));

                //WIN CONDITION
                if (tile.numericalOrder()) {
                    setHighScore();
                    showWinWindow();
                    Buttons.setBackground(Color.ORANGE);
                    setUnavailable(true);
                }
            }
        }
    }


    //SETS A BUTTON TO EITHER BLANK OR REGULAR
    public void setColor(boolean darkOrRegular, JButton button) {
        button.setOpaque(true);
        if (darkOrRegular) {
            button.setText("");
            button.setBorder(null);
            button.setContentAreaFilled(false);
        } else {
            button.setContentAreaFilled(true);
            button.setBorder(border);
        }
    }

    static ArrayList<JButton> buttonList = new ArrayList<>();

    //SETS THE 0 TO BLANK
    public void setAll() {

        for (int i = 0; i < buttonList.size(); i++) {
            int value = tile.tiles.get(i);
            JButton button = buttonList.get(i);

            if (value == 0) {
                setColor(true, button);
            } else {
                button.setText(String.valueOf(value));
                setColor(false, button);
            }
        }
    }


    //YES OR NO WINDOW
    public void showConfirmWindow() {

        //ELEMENTS
        JFrame confirmWindow = new JFrame();
        JPanel buttons = new JPanel();
        JPanel text = new JPanel(new BorderLayout());
        JLabel startNew = new JLabel("Start new game?", SwingConstants.CENTER);
        JButton positive = new JButton("Yes");
        JButton negative = new JButton("No");
        confirmWindow.add(text, BorderLayout.NORTH);
        confirmWindow.add(buttons);
        text.add(startNew);
        buttons.add(positive);
        buttons.add(negative);

        //FORMATING OF WINDOW
        buttons.setBorder(new EmptyBorder(15, 15, 15, 15));
        text.setBorder(new EmptyBorder(15, 5, 0, 5));
        confirmWindow.pack();
        confirmWindow.setResizable(false);
        confirmWindow.setLocationRelativeTo(null);
        confirmWindow.setVisible(true);

        //ACTIONS OF BUTTONS
        positive.addActionListener(e -> {
            setUnavailable(false);
            tile.moveCounter(true);
            moveCounter.setText("Moves: 0");
            tile.startTiles();
            setAll();
            Buttons.setBackground(Color.WHITE);
            confirmWindow.dispose();
        });
        negative.addActionListener(e -> confirmWindow.dispose());
    }

    //TRIGGERS UPON WINNING, PROMPT NEW GAME
    public void showWinWindow() {
        JFrame winWindow = new JFrame();
        JPanel buttons = new JPanel();
        JPanel text = new JPanel(new BorderLayout());
        winWindow.setResizable(false);
        JLabel startNew = new JLabel("YOU WON! New Game?", SwingConstants.CENTER);
        JButton positive = new JButton("Yes");
        JButton negative = new JButton("No");
        winWindow.add(text, BorderLayout.NORTH);
        winWindow.add(buttons);
        text.add(startNew);
        buttons.add(positive);
        buttons.add(negative);
        buttons.setBorder(new EmptyBorder(15, 15, 15, 15));
        text.setBorder(new EmptyBorder(15, 5, 0, 5));
        winWindow.pack();
        winWindow.setLocationRelativeTo(null);
        winWindow.setVisible(true);

        //YES
        positive.addActionListener(e -> {
            setUnavailable(false);
            tile.moveCounter(true);
            moveCounter.setText("Moves: 0");
            tile.startTiles();
            Buttons.setBackground(Color.WHITE);
            setAll();

            winWindow.dispose();
        });
        //NO
        negative.addActionListener(e -> winWindow.dispose());
    }

    //AFTER WIN, BUTTONS CANT BE PRESSED
    public void setUnavailable(boolean enable) {
        if (enable) {
            for (JButton button : buttonList) {
                button.setEnabled(false);
            }
        } else {
            for (JButton button : buttonList) {
                button.setEnabled(true);
            }
        }
    }
    public void setHighScore(){
        int moves = tile.moveCounter(false);
        if(hS == 0 || hS>moves){
            hS=moves-1;
        }
        highScore.setText("Highscore: " + hS);
    }

}


