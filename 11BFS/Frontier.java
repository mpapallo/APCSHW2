public class Frontier{
    
    private MyDeque deq;
    private int DFS = 0;
    private int BFS = 1;
    private int mode;

    public Frontier(int mode){
	this.mode = mode;
	if (mode < 0 || mode > 1){
	    this.mode = 1;
	}
    }

}