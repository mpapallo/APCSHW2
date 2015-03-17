import java.util.*;
public class MyLinkedList<T> implements Iterable<T>{
    
    private class MyLLIterator<T> implements Iterator{

	private LNode<T> now;

	public MyLLIterator(LNode<T> start){
	    now = start;
	}

	public boolean hasNext(){
	    return (now != null);
	}

	public T next(){
	    if (hasNext()){
		LNode<T> r = now;
		now = now.getNext();
		return r.getData();
	    }else{
		throw new NoSuchElementException();
	    }
	}
	
	public void remove(){
	    throw new UnsupportedOperationException();
	}

    }

    public Iterator<T> iterator(){
	return new MyLLIterator<T>(head);
    }

    private LNode<T> head, tail, now;
    private int size;

    public MyLinkedList(){
    	head = new LNode<T>();
    	tail = new LNode<T>();
    	now = new LNode<T>();
    	size = 0;
    }

    public String name(){
	return "papallo.michaela";
    }

    public String toString(){
	String list = "[ ";
	now = head;
	for (int i = 0; i < size; i ++){
	    list += now.getData() + " ";
	    now = now.getNext();
	}
	list += "]";
	return list;
    }

    public boolean add(T value){
	LNode<T> next = new LNode<T>(value);
	if (size == 0){
	    head = next;
	    tail = head;
	    now = head;
	}else{
	    tail.setNext(next);
	    tail = next;
	}
       	size ++;
	return true;
    }

    public boolean add(int index, T value){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode<T> add = new LNode<T>(value);
	if (index == 0){
	    add.setNext(head);
	    head = add;
	}else if(index == size() - 1){
	    add(value);
	}else{
	    now = head;
	    for (int i = 0; i < index - 1; i ++){
		now = now.getNext();
	    }
	    LNode<T> next = now.getNext();
	    now.setNext(add);
	    add.setNext(next);
	}
	size ++;
	return true;
	
    }

    public void set(int index, T value){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	now = head;
	for (int i = 0; i < index; i ++){
	    now = now.getNext();
	}
	now.setData(value);
    }

    public T get(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	now = head;
	for (int i = 0; i < index; i ++){
	    now = now.getNext();
	}
	return now.getData();
    }

    public int indexOf(T value){
	now = head;
	for (int i = 0; i < size; i ++){
	    if (now.getData().equals(value)){
		return i;
	    }else{
		now = now.getNext();
	    }
	}
	return -1;
    }

    public T remove(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode<T> rem;
	if (index == 0){
	    rem = head;
	    head = rem.getNext();
	}else if (index == size() - 1){
	    now = head;
	    for (int i = 0; i < size() - 2; i ++){
		now = now.getNext();
	    }
	    rem = tail;
	    tail = now;
	}else{
	    now = head;
	    for (int i = 0; i < index - 1; i ++){
		now = now.getNext();
	    }
	    rem = now.getNext();
	    now.setNext(rem.getNext());
	}
	size --;
	return rem.getData();
    }

    public int size(){
	return size;
    }

    public void clear(){
	size = 0;
    }

    public static void main(String[] args){
	/*
	MyLinkedList<Integer> l = new MyLinkedList<Integer>();
	
	System.out.println(l);
	
	l.add(3);
	l.add(4);
	l.add(5);

	System.out.println(l);
	
	System.out.println("get(0) " + l.get(0));
	System.out.println("get(2) " + l.get(2));

	l.set(2, 6);
	System.out.println("set(2, 6) " + l);

	System.out.println("indexOf(6) " + l.indexOf(6));
	
	l.add(1, 9);
	System.out.println("add(1, 9) "  + l);

	System.out.println("remove(1) " + l.remove(1));
	System.out.println(l);

	System.out.println("remove(0)" + l.remove(0));
	System.out.println(l);

	System.out.println("remove(1)" + l.remove(1));
	System.out.println(l);
	*/

	MyLinkedList<String> l = new MyLinkedList<String>();
	
	System.out.println(l);
	
	l.add("a");
	l.add("b");
	l.add("c");

	System.out.println(l);
	
	System.out.println("get(0) " + l.get(0));
	System.out.println("get(2) " + l.get(2));

	l.set(2, "d");
	System.out.println("set(2, d) " + l);

	System.out.println("indexOf(d) " + l.indexOf("d"));
	
	l.add(1, "e");
	System.out.println("add(1, e) "  + l);

	System.out.println("remove(1) " + l.remove(1));
	System.out.println(l);

	System.out.println("remove(0)" + l.remove(0));
	System.out.println(l);

	System.out.println("remove(1)" + l.remove(1));
	System.out.println(l);

    }

}
