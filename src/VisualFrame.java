import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualFrame extends JFrame implements ActionListener {
    JPanel Buttons = new JPanel();
    JPanel Game = new JPanel();
    JButton newGame = new JButton("New Game");

    public VisualFrame(){
        this.add(Buttons, BorderLayout.NORTH);
        Buttons.setLayout(new BoxLayout(Buttons, BoxLayout.X_AXIS));
        Buttons.setBorder(new EmptyBorder(10, 0, 5, 0));
        Buttons.add(newGame);

        this.add(Game, BorderLayout.CENTER);
        Game.setBorder(new EmptyBorder(5, 5, 0, 5));
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
