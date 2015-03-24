import java.util.*;
public class MyStack<T>{
    
    private MyLinkedList<T> stack;
    
    public MyStack(){
	stack = new MyLinkedList<T>();
    }

    public String name(){
	return "papallo.michaela";
    }

    public T push(T value){
	if (value == null){
	    throw new NullPointerException();
	}
	if (empty()){
	    stack.add(value);
	}else{
	    stack.add(0, value);
	}
	return value;
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
    

    public static void main(String[]args){
	
	MyStack<String> stack = new MyStack<String>();
	
	stack.push("C");
	stack.push("B");
	stack.push("A");
	System.out.println(stack.peek());
	System.out.println(stack.pop());
	System.out.println(stack.pop());
	System.out.println(stack.pop());
	if (stack.empty()){
	    System.out.println("empty now");
	}
	
	
	
    }

}
