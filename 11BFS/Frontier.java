public class Frontier{
    
    private MyDeque<Coord> deq;
    private int DFS = 0;
    private int mode;

    public Frontier(int mode){
	this.mode = mode;
	deq = new MyDeque<Coord>();
    }

    public void add(Coord c){
	if (mode == DFS){
	    deq.addFirst(c);
	}else{
	    deq.addLast(c);
	}
    }
    public Coord remove(){
	return deq.removeFirst();
    }

}
