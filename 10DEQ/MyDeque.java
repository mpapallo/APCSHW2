import java.util.*;
public class MyDeque<T>{

    private Object[] deq;
    private int head;
    private int tail;  
    private int size;

    public MyDeque(){
	deq = new Object[10];
	head = 5;
	tail = 4;
	size = 0;
    }

    public String name(){
	return "michaela.papallo";
    }

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

    public T removeFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}

	if (size <= deq.length / 4){
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

	if (size <= deq.length / 4){
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

    public static void main(String[]args){
	
	MyDeque<String> d = new MyDeque<String>();
	System.out.println(d);
	
    }

}
