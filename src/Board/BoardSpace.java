package Board;

public class BoardSpace {
    int x;
    int y;
    boolean hasTile;
    boolean AIflag;
    Tile tile;
    
    public BoardSpace() {
        hasTile = false;
    }
    
    public BoardSpace(Tile tileToAdd) {
    	tile = tileToAdd;
        hasTile = true;
    }
    
    public void addTile(Tile tileToAdd){
        tile = tileToAdd;
        hasTile = true;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
}
