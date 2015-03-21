import java.util.*;
public class MyStack<T>{
    
    private MyLinkedList<T> stack;
    
    public MyStack(){
	stack = new MyLinkedList<T>();
    }

    public String name(){
	return "papallo.michaela";
    }

    public void push(T value){
	stack.add(value, 0);
    }

    public T pop(){
	if (empty()){
	    throw new EmptyStackException();
	}
	return stack.remove(0);
    }

    public T peek(){
	if (empty()){
	    throw new EmptyStackException();
	}
	return stack.get(0);
    }

    public boolean empty(){
	return stack.size() == 0;
    }
    

}
