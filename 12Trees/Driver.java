public class Driver{
    
    public static void main(String[]args){
	
	BTree<String> tree = new BTree<String>();

	tree.add("a");
	tree.add("b");
	tree.add("c");
	System.out.println();
	System.out.println(tree);
	System.out.println();
        tree.traverse(0);
	System.out.println();
        tree.traverse(1);
	System.out.println();
        tree.traverse(2);
	System.out.println();	

    }
  
}
