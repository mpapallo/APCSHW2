import java.util.*;
public class MyDeque<T>{

    private Object[] deq;
    private int[] priorities;
    private int head;
    private int tail;  
    private int size;
    private boolean shrink;

    public MyDeque(){
	this(false);
    }
    public MyDeque(boolean b){
	deq = new Object[10];
	priorities = new int[10];
	head = 5;
	tail = 4;
	size = 0;
	shrink = b;
    }

    public String name(){
	return "michaela.papallo";
    }

    public boolean isEmpty(){
	return size == 0;
    }

    /////Stack and Queue Methods/////
    public void addFirst(T value){
	if (size == deq.length){
	    grow();
	}	
	head --;
	if (head == -1){
	    head = deq.length - 1;
	}
	deq[head] = value;
	size ++;
    }
    public void addLast(T value){
	if (size == deq.length){
	    grow();
	}	
	tail ++;
	if (tail == deq.length){
	    tail = 0;
	}
	deq[tail] = value;
	size ++;
    }
       
    public T removeFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}

	if (shrink && size <= deq.length / 4){
	    shrink();
	}

	size --;
	T ret = (T)deq[head];
	head ++;
	if (head == deq.length){
	    head = 0;
	}
	return ret;
    }
    public T removeLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}

	if (shrink && size <= deq.length / 4){
	    shrink();
	}

	size --;
	T ret = (T)deq[tail];
	tail --;
	if (tail == -1){
	    tail = deq.length - 1;
	}
	return ret;
    }

    public T getFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return (T)deq[head];
    }
    public T getLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return (T)deq[tail];
    }
    //////////

    public void grow(){
	Object[] ret = new Object[deq.length * 2];
	if (head < tail){
	    for (int i = head; i <= tail; i ++){
		ret[i] = deq[i];
	    }
	}else{
	    for (int i = head; i < deq.length; i ++){
		ret[i] = deq[i];
	    }
	    for (int i = 0; i <= tail; i ++){
		ret[i + deq.length] = deq[i];
	    }
	    tail += deq.length;
	}
        deq = ret;
    }

    public void shrink(){
	Object[] ret = new Object[deq.length / 2];
	int c = 0;
	if (head < tail){
	    for (int i = head; i <= tail; i ++){
		ret[c] = deq[i];
		c ++;
	    }
	}else{
	    for (int i = head; i < deq.length; i ++){
		ret[c] = deq[i];
		c ++;
	    }
	    for (int i = 0; i <= tail; i ++){
		ret[c] = deq[i];
		c ++;
	    }
	}
	head = 0;
	tail = c - 1;
	deq = ret;
    }

    /////Priority Queue Methods/////
    public void add(T value, int priority){
	if (size == deq.length){
	    grow();
	    growInt();
	}
	addLast(value);
	priorities[tail] = priority;	
    }

    public T removeSmallest(){
	if (size == 0){
	    throw new NoSuchElementException();
	}

	if (shrink && size <= deq.length / 4){
	    shrink();
	}
	
	int index = head;
	if (head <= tail){
	    for (int i = head + 1; i <= tail; i ++){
		if (priorities[i] < priorities[index]){
		    index = i;
		}
	    }
	}else{
	    for (int i = head + 1; i < priorities.length; i ++){
		if (priorities[i] < priorities[index]){
		    index = i;
		}
	    }
	    for (int i = 0; i <= tail; i ++){
		if (priorities[i] < priorities[index]){
		    index = i;
		}
	    }
	}
	//System.out.println("index: " + index);
	//System.out.println("tail: " + tail);
	//System.out.println("head: " + head);
	Object ret = deq[index];
	priorities[index] = priorities[head];
	priorities[head] = 0;
	deq[index] = removeFirst();
	return (T)ret;
    }

    public void growInt(){
	int[] ret = new int[priorities.length * 2];
	if (head <= tail){
	    for (int i = head; i <= tail; i ++){
		ret[i] = priorities[i];
	    }
	}else{
	    for (int i = head; i < priorities.length; i ++){
		ret[i] = priorities[i];
	    }
	    for (int i = 0; i <= tail; i ++){
		ret[i + priorities.length] = priorities[i];
	    }
	}
        priorities = ret;
    }
    ///////////

    public String toString(){
	String ret = "[ ";
	if (size > 0){
	    if (head <= tail){
		for (int i = head; i <= tail; i ++){
		    ret += deq[i] + " ";
		}
	    }else{
		for (int i = head; i < deq.length; i ++){
		    ret += deq[i] + " ";
		}
		for (int i = 0; i <= tail; i ++){
		    ret += deq[i] + " ";
		}
	    }
	}
	return ret + "]";
    }

    public String toStringPriorities(){
	String ret = "[ ";
	if (size > 0){
	    if (head <= tail){
		for (int i = head; i <= tail; i ++){
		    ret += priorities[i] + " ";
		}
	    }else{
		for (int i = head; i < priorities.length; i ++){
		    ret += priorities[i] + " ";
		}
		for (int i = 0; i <= tail; i ++){
		    ret += priorities[i] + " ";
		}
	    }
	}
	return ret + "]";
    }
    
    public String seeDeq(){
	return Arrays.toString(deq);
    }
    public String seePriorities(){
	return Arrays.toString(priorities);
    }

    public static void main(String[]args){
	
	MyDeque<String> d = new MyDeque<String>();
	
	d.add("hello", 4);
	d.add("goodbye", 3);
	d.add("what", 2);
	System.out.println("Order should be what, goodbye, hello\n");
	System.out.println(d.removeSmallest());
	System.out.println(d.removeSmallest());
	System.out.println(d.removeSmallest());

    }

}
