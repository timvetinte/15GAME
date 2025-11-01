import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class tile {

    static ArrayList<Integer> tiles = new ArrayList<>();
    static ArrayList<Integer> numerical = new ArrayList<>();


    public static void startTiles() {
        tiles.clear();
        for (int i = 0; i < 16; i++) {
            tiles.add(i);
            numerical.add(i);
        }
        numerical.removeFirst();
        Collections.shuffle(tiles);
    }


    public static void numericalOrder() {
        int numIndex = 0;
        for (int i = 0; i < tiles.size(); i++) {
            if (tiles.get(i) == 0) continue;
            if (!tiles.get(i).equals(numerical.get(numIndex))) {
                System.out.println("not yet");
                return;
            }
            numIndex++;
        }
        System.out.println("WIN!!!!");
    }

    }

