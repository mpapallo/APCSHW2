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
    }
    public void add(Coord c, int priority){
	deq.add(c, priority);
    }
    
    public Coord remove(){
        if (mode == BFS || mode == DFS){
	    return deq.removeFirst();
	}else{
	    return deq.removeSmallest();
	}
    }

    public boolean isEmpty(){
	return deq.isEmpty();
    }

}
