import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class tile {

    ArrayList<tile> tiles = new ArrayList<>();
    ArrayList<Integer> numerical = new ArrayList<>();

    private int index;
    private int number;

    public tile(){
    }

    public tile(int index, int number){
        this.index=index;
        this.number=number;
    }

    public int getIndex() {
        return index;
    }

    public void startTiles(){
        tiles.clear();
        for (int i = 0; i < 15; i++) {
            tile newTile = new tile(i, i);
            tiles.add(newTile);
            Collections.shuffle(tiles);
        }
    }

    public void printTilesList(){
        for(tile t : tiles){
            System.out.println(t.getIndex());
        }
    }

    public void numericalOrder(){




    }

}
