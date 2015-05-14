import java.util.*;
public class MyHeap{

    private int[] heap;
    private boolean isMax;

    public MyHeap(){
	this(true);
    }
    public MyHeap(boolean isMax){
	heap = new int[5];
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

    private int getLeft(int i){
	return i * 2;
    }
    private int getRight(int i){
	return i * 2 + 1;
    }
    private int getParent(int i){
	return i / 2;
    }

    public void add(int n){

	if (heap[0] == heap.length - 1){
	    resize();
	}

	int size = heap[0] + 1; //new size
	heap[size] = n; //add int to the end of the values
	heap[0] = size; //update size
	int i = size;
	while (getParent(i) > 0){ //while it has a parent
	    int parentIn = getParent(i);
	    if (heap[i] > heap[parentIn]){
		//if it is greater than its parent, swap them (maxHeap)
		swap(i, parentIn);
	    }
	    i = parentIn;
	}
    }

    public int remove(){
	int size = heap[0];
	if (size == 0){
	    throw new NoSuchElementException();
	}else{
	    int ret = heap[1];
	    heap[1] = heap[size]; //replace root with last value
	    heap[0] = --size; //reduce size
	    //do the swap down thing
	    int i = 1;
	    while (getLeft(i) <= size){ //while value has a left child
		int l = getLeft(i);
		int r = getRight(i);
	        if (r <= size){ //if value has a right child
		    if (heap[i] < heap[l] || heap[i] < heap[r]){
			//if value is less than one of its children,
			//swap with the bigger one (maxHeap)
			int dif = heap[l] - heap[r];
			if (dif > 0){
			    swap(i, l);
			    i = l;
			}else if (dif < 0){
			    swap(i, r);
			    i = r;
			}
		    }else{
			return ret;
		    }
		}else if (heap[i] < heap[l]){
		    swap(i, l);
		    i = l;
		}else{
		    return ret;
		}
	    }
	    return ret;
	}
	
    }

    public int peek(){
	if (heap[0] == 0){
	    throw new NoSuchElementException();
	}else{
	    return heap[1];
	}
    }

    private void resize() {
        heap = Arrays.copyOf(heap, heap[0] * 2);
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
	h.add(4);
	h.add(7);
	h.add(9);
	h.add(1);
	System.out.println(h);
	System.out.println(h.remove());
	System.out.println(h);
	
    }

}
