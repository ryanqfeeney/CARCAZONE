package Board;

public class Tile {
        /*For Middle Feature Int
        0, Nothing Special
        4, Buffalo
        5, Crocodile
        6, Deer
        7, Boar
        8, Den
        */
        boolean hasCrocodile;
        int numTigers;
        int tigerSection; //-1 if no tiger
        int middleFeature;
        int rotation;
	public Edge l, r, t, b;
        
	public Tile(int r, int t, int l, int b, int m){
		this.l=new Edge(l);
		this.r=new Edge(r);
		this.t=new Edge(t);
		this.b=new Edge(b);
                rotation = 0;
                middleFeature = m;
                hasCrocodile = false;
                numTigers = 0;
                tigerSection = -1;
                
	}
        
	public void rotate(){
            if(rotation == 270)
                rotation = 0;
            else
                rotation += 90;
            Edge temp = t;
            t = r;
            r = b;
            b = l;
            l = temp;
	}
        
        public int getMiddle() {
            return middleFeature;
        }
        
        public int tigerLocation(){
            return tigerSection;
        }
        
        public void placeTiger(int section) {
            numTigers++;
            tigerSection = section;
        }
        
        public void placeCroc(){
            hasCrocodile = true;
        }
}   
