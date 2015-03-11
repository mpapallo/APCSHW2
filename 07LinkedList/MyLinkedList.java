public class MyLinkedList{
    
    LNode head;
    LNode now;
    int size;

    public MyLinkedList(){
	head = new LNode(0);
	now = new LNode(0);
	size = 0;
    }

    public String toString(){
	String list = "[";
	now = head;
	for (int i = 0; i < size; i ++){
	    list += now.getData() + " ";
	    now = now.getNext();
	}
	list += "]";
	return list;
    }

    public void add(int value){
	LNode next = new LNode(value);
	if (size == 0){
	    head = next;
	    now = head;
	}else{
	    for (int i = 0; i < size; i ++){
		now = now.getNext();
	    }
	    now.setNext(next);
	}
    }

    public int size(){
	return size;
    }

}
