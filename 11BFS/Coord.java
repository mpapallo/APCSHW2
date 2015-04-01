public class Coord{
	private int x;
	private int y;
	private Coord prev;
	
	public Coord(int x, int y){
	    this.x = x;
	    this.y = y;
	}

	public void setPrev(Coord p){
	    prev = p;
	}
	public Coord getPrev(){
	    return prev;
	}
	public int getX(){
	    return x;
	}
	public int getY(){
	    return y;
	}
	
	

    }