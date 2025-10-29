import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NumberLogic {

    ArrayList<Integer> tiles = new ArrayList<>();
    ArrayList<Integer> numerical = new ArrayList<>();

    public void startTiles(){
        tiles.clear();
        tiles.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,0));
        Collections.shuffle(tiles);
        for(Integer i : tiles){
            System.out.println(i);
        }
    }

    public void numericalOrder(){




    }

}
