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

    public void swap(int a, int b){
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
	    i = i /2;
	}
    }

    public int remove(){
	int size = heap[0];
	if (size == 0){
	    //?
	}else{
	    int ret = heap[1];
	    heap[1] = heap[size]; //replace root with last value
	    heap[0] = size - 1; //reduce size
	    //do the swap down thing
	   
	    

	    return ret;
	}
	
    }

    public int peek(){
	if (heap[0] == 0){
	    //?
	}else{
	    return heap[1];
	}
    }

    public String toString(){
	String ret = "";
	
	//temp
	ret += "[";
	for (int i = 1; i <= heap[0]; i ++){
	    ret += " " + heap[i];
	}
	ret += " ]";
	
	return ret;
    }

    public static void main(String[]args){
	MyHeap h = new MyHeap();
	
	System.out.println(h);
	h.add(3);
	h.add(1);
	h.add(5);
	System.out.println(h);
	
    }

}
