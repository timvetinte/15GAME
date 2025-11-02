import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class tile {

    //THE ARRAY FOR THE TILES
    static ArrayList<Integer> tiles = new ArrayList<>();

    //THE ARRAY FOR CORRECT ORDER
    static ArrayList<Integer> numerical = new ArrayList<>();

    static int counter = 0;

    //START THE GAME
    public static void startTiles() {
        tiles.clear();
        numerical.clear();
        for (int i = 0; i < 16; i++) {
            tiles.add(i);
            numerical.add(i);
        }
        numerical.removeFirst();
        Collections.shuffle(tiles);
    }

    //SETS THE TILES TO EASILY WINNABLE
    public static void testWin() {
        tiles.clear();
        numerical.clear();
        for (int i = 0; i < 16; i++) {
            tiles.add(i);
            numerical.add(i);
        }
        numerical.removeFirst();
        tiles.set(4, 1);
        tiles.set(0, 2);
        tiles.set(1, 0);
        tiles.set(2, 3);
        tiles.set(3, 4);
    }


    //CHECKER TO SEE IF CORRECT ORDER
    public static boolean numericalOrder() {
        int numIndex = 0;
        for (int i = 0; i < tiles.size(); i++) {
            if (tiles.get(i) == 0) continue;
            if (!tiles.get(i).equals(numerical.get(numIndex))) {
                return false;
            }
            numIndex++;
        }
        return true;
    }

    public static int moveCounter(boolean clear) {
        if (clear) counter = 0;
        else counter++;
        return counter;
    }
}


