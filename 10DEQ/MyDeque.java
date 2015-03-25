public class MyDeque<T>{

    private Object[] deq;
    private int head;
    private int tail;  
    private int size;

    public MyDeque(){
	deq = new Object[100];
	head = 51;
	tail = 50;
	size = 0;
    }

    public void addFirst(T value){
	if (size == deq.length){
	    resize();
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
	    resize();
	}	
	tail ++;
	if (tail == deq.length){
	    tail = 0;
	}
	deq[tail] = value;
	size ++;
    }

    public void resize(){
	Object[] ret = new Object[deq.length * 2];
	if (head < tail){
	    for (int i = head; i < tail; i ++){
		ret[i] = deq[i];
	    }
	}else{
	    for (int i = head; i < deq.length; i ++){
		ret[i] = deq[i];
	    }
	    for (int i = 0; i < tail; i ++){
		ret[i + deq.length] = deq[i];
		tail += deq.length;
	    }
	}
	//now copy into deq D:
    }

    public void copy(int[] a, int[] b){
	
    }

    public T removeFirst(){
	size --;
	T ret = (T)deq[head];
	head ++;
	if (head == deq.length){
	    head = 0;
	}
	return ret;
    }
    public T removeLast(){
	size --;
	T ret = (T)deq[tail];
	tail --;
	if (tail == -1){
	    tail = deq.length - 1;
	}
	return ret;
    }

    public T getFirst(){
	return (T)deq[head];
    }
    public T getLast(){
	return (T)deq[tail];
    }

    public static void main(String[]args){
	
	MyDeque<String> d = new MyDeque<String>();
	

    }

}
