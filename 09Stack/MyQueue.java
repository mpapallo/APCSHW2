public class MyQueue<T>{
    
    private MyLinkedList<T> queue;
    
    public MyQueue(){
	queue = new MyLinkedList<T>();
    }

    public String name(){
	return "papallo.michaela";
    }

    public void enqueue(T value){
	queue.add(value);
    }

    public T dequeue(){
	return queue.remove(0);
    }

    public static void main(String[] args){
	
    }

}