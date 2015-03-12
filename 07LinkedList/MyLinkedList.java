public class MyLinkedList{
    
    private LNode head;
    private LNode now;
    private int size;

    public MyLinkedList(){
	head = new LNode(0);
	now = new LNode(0);
	size = 0;
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

    public boolean add(int value){
	LNode next = new LNode(value);
	if (size == 0){
	    head = next;
	    now = head;
	}else{
	    now = head;
	    for (int i = 0; i < size - 1; i ++){
		now = now.getNext();
	    }
	    now.setNext(next);
	}
	size ++;
	return true;
    }

    public boolean add(int index, int value){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode add = new LNode(value);
	now = head;
	for (int i = 0; i < index - 1; i ++){
	    now = now.getNext();
	}
	LNode next = now.getNext();
	now.setNext(add);
	add.setNext(next);
	size ++;
	return true;
	
    }

    public void set(int index, int value){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	now = head;
	for (int i = 0; i < index; i ++){
	    now = now.getNext();
	}
	now.setData(value);
    }

    public int get(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	now = head;
	for (int i = 0; i < index; i ++){
	    now = now.getNext();
	}
	return now.getData();
    }

    public int indexOf(int value){
	now = head;
	for (int i = 0; i < size; i ++){
	    if (now.getData() == value){
		return i;
	    }else{
		now = now.getNext();
	    }
	}
	return -1;
    }

    public int remove(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	now = head;
	for (int i = 0; i < index - 1; i ++){
	    now = now.getNext();
	}
	LNode rem = now.getNext();
	now.setNext(rem.getNext());
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
	MyLinkedList l = new MyLinkedList();
	
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

    }

}
