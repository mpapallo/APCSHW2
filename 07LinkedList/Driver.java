public class Driver{

    public static void main(String[] args){
	MyLinkedList l = new MyLinkedList();
	
	System.out.println(l);
	
	l.add(3);
	l.add(4);
	l.add(5);

	System.out.println(l);
	
	System.out.println(l.get(0));
	System.out.println(l.get(2));

	l.set(2, 6);
	System.out.println(l);

	System.out.println(l.indexOf(6));
	
    }
}
