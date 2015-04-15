public class Frontier{
    
    private MyDeque<Coord> deq;
    private int DFS = 0;
    private int BFS = 1;
    private int Best = 2;
    private int AStar = 3;
    private int mode;

    public Frontier(int mode){
	this.mode = mode;
	deq = new MyDeque<Coord>();
    }

    public void add(Coord c){
	if (mode == DFS){
	    deq.addFirst(c);
	}else if(mode == BFS){
	    deq.addLast(c);
	}
	//else use priority queue
    }
    public Coord remove(){
	//if mode == BFS or DFS
	return deq.removeFirst();
	//else use removeSmallest
    }

    public boolean isEmpty(){
	return deq.isEmpty();
    }

}
