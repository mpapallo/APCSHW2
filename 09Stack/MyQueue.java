public class MyQueue<T>{
    
    private MyLinkedList<T> queue;
    
    public MyQueue(){
	queue = new MyLinkedList<T>();
    }

    public String name(){
	return "papallo.michaela";
    }

    public boolean enqueue(T value){
	return queue.add(value);
	
    }

    public T dequeue(){
	return queue.remove(0);
    }


    public static void main(String[] args){
	MyQueue<String> q = new MyQueue<String>();
	q.enqueue("a");
	q.enqueue("b");
	q.enqueue("c");
	System.out.println(q.dequeue());
	System.out.println(q.dequeue());
	System.out.println(q.dequeue());
    }

}