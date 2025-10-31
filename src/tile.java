import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class tile {

    static ArrayList<Integer> tiles = new ArrayList<>();
    static ArrayList<Integer> numerical = new ArrayList<>();



    public static void startTiles(){
        tiles.clear();
        for (int i = 0; i < 16; i++) {
            tiles.add(i);
            numerical.add(i);
        }
        Collections.shuffle(tiles);
    }



    public void numericalOrder(){




    }

}
