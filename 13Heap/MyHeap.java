public class MyHeap{

    private int[] heap;
    private boolean isMax;

    public MyHeap(){
	this(true);
    }
    public MyHeap(boolean isMax){
	heap = new int[10];
	this.isMax = isMax;
    }
    
    public String name(){
	return "papallo.michaela";
    }

    private void swap(int a, int b){
	//assumes a and b are in range
	int temp = heap[a];
	heap[a] = heap[b];
	heap[b] = temp;
    }

    public void add(int n){

	//////if heap[0]  = heap.length - 1, resize

	int size = heap[0] + 1; //new size
	heap[size] = n; //add int to the end of the values
	heap[0] = size; //update size
	int i = size;
	while (i / 2 > 0){ //while it has a parent
	    if (heap[i] > heap[i / 2]){
		//if it is greater than its parent, swap them (maxHeap)
		swap(i, i / 2);
	    }
	}
    }

    public int remove(){
	return 0;
    }

    public int peek(){
	return 0;
    }

    public String toString(){
	String ret = "";
	return ret;
    }

}
