public class Coord{
    private int x;
    private int y;
    private Coord prev;
    private int steps; 
	
    public Coord(int x, int y){
	this.x = x;
	this.y = y;
    }
    public Coord(int x, int y, int s){
	this.x = x;
	this.y = y;
	steps = s;
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
    public void setSteps(int s){
	steps = s;
    } 
    public int getSteps(){
	return steps;
    }
    
}
