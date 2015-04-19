import java.util.*;
import java.io.*;
public class Frontier{
    
    private MyDeque<Coord> deq;
    private int DFS = 0;
    private int BFS = 1;
    private int Best = 2;
    private int AStar = 3;
    private int mode;
    private int endx, endy;
    
    public Frontier(int mode){
	this.mode = mode;
	if (mode < 0 || mode > 3){
	    this.mode = 0;
	}
	deq = new MyDeque<Coord>();
    }
    public Frontier(int mode, int ex, int ey){
	this.mode = mode;
	if (mode < 0 || mode > 3){
	    this.mode = 0;
	}
	deq = new MyDeque<Coord>();
	endx = ex;
	endy = ey;
    }

    public void add(Coord c){
	int ex = c.getX();
	int why = c.getY();
	if (mode == DFS){
	    deq.addFirst(c);
	}else if(mode == BFS){
	    deq.addLast(c);
	}else if (mode == Best){
	    deq.add(c, Math.abs(endx - ex) + Math.abs(endy - why));
	}else{
	    deq.add(c, Math.abs(endx - ex) + Math.abs(endy - why) + c.getSteps());
	}
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
