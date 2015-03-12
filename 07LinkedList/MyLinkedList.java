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
	    now = head;
	    for (int i = 0; i < size - 1; i ++){
		now = now.getNext();
	    }
	    now.setNext(next);
	}
	size ++;
    }

    public void set(int index, int value){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}
	now = head;
	for (int i = 0; i < index; i ++){
	    now = now.getNext();
	}
	now.setData(value);
    }

    public int get(int index){
	if (index < 0 || index > size){
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

    //REMOVE

    public int size(){
	return size;
    }

    public void clear(){
	size = 0;
    }

}
