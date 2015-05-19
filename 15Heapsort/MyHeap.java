import java.util.*;
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

    private int getLeft(int i){
	return i * 2;
    }
    private int getRight(int i){
	return i * 2 + 1;
    }
    private int getParent(int i){
	return i / 2;
    }

    private boolean inOrder(int a, int b){
	//assumes a and b are in range
	//a is parent, b is child
	if (isMax){
	    return (heap[a] > heap[b]); //for maxHeap, true if parent is greater
	}else{
	    return (heap[a] < heap[b]); //for minHeap, true if parent is less
	}
    }

    public void add(int n){
	if (heap[0] == heap.length - 1){
	    resize();
	}
	int size = heap[0] + 1; //new size
	heap[size] = n; //add int to the end of the values
	heap[0] = size; //update size
	swapUp(size);	
    }
    private void swapUp(int i){
	while (getParent(i) > 0){ //while it has a parent
	    int parentIn = getParent(i);
	    if (!inOrder(parentIn, i)){
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
	    swapDown(1);
	    return ret;
	}	
    }
    private void swapDown(int i){
	int size = heap[0];
	while (getLeft(i) <= size){ //while value has a left child
	    int l = getLeft(i);
	    int r = getRight(i);
	    if (r <= size){ //if value has a right child
		if (!inOrder(i, l) || !inOrder(i, l)){
		    int dif = heap[l] - heap[r];
		    if (isMax){
			if (dif > 0){
			    swap(i, l);
			    i = l;
			}else if (dif < 0){
			    swap(i, r);
			    i = r;
			}
		    }else{
			if (dif < 0){
			    swap(i, l);
			    i = l;
			}else{
			    swap(i, r);
			    i = r;
			}
		    }
		}else{
		    return;
		}
	    }else if (!inOrder(i, l)){
		swap(i, l);
		i = l;
	    }else{
		return;
	    }
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

    public int size(){
	return heap[0];
    }

    public String toString(){
	String ret = "";

	/*
	//temp
	ret += "[";
	for (int i = 1; i <= heap[0]; i ++){
	    ret += " " + heap[i];
	}
	ret += " ]";
	*/
	
	int numLevels = (int)(Math.log((double)heap[0]) / Math.log(2.0)) + 1;
        System.out.println("numLevels: " + numLevels);
	int index = 1;
	for (int x = 0; x < numLevels; x ++){
	    int thisLine = (int)Math.pow(2, x);
	    for (int i = 0; i < thisLine; i ++){
		ret += heap[index] + " ";
		index ++;
	    }
	    ret += "\n";
	}

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
	
	System.out.println();
	MyHeap j = new MyHeap(false);
	j.add(3);
	j.add(1);
	j.add(5);
	j.add(4);
	j.add(7);
	j.add(9);
	j.add(1);
	System.out.println(j);
	System.out.println(j.remove());
	System.out.println(j);

    }

}
