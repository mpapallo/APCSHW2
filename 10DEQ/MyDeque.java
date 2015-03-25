public class MyDeque<T>{

    private Object[] deq;
    private int head;
    private int tail;  
    private int size;

    public MyDeque(){
	deq = new Object[100];
	head = 50;
	tail = 51;
	size = 0;
    }

    public void addFirst(T value){
	if (size == deq.length){
	    resize();
	}
	deq[head] = value;
	head --;
	if (head == -1){
	    head = deq.length - 1;
	}
    }
    public void addLast(T value){
	if (size == deq.length){
	    resize();
	}
	deq[tail] = value;
	tail ++;
	if (tail == deq.length){
	    tail = 0;
	}
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
	//now copy D:
    }

    public T removeFirst(){
	
    }
    public T removeLast(){
	
    }
}
