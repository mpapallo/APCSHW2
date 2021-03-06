import java.io.*;
import java.util.*;

public class BSTree <T extends Comparable> {

    private BSTreeNode<T> root;
    private Random rand = new Random();

    public BSTree() {
	root = null;
    }

    public boolean isEmpty() {
	return root == null;
    }
    
    /*======== public void add() ==========
      Inputs:   T c  
      Returns: 

      Wrapper for the recursive add method
      ====================*/
    public void add( T c ) {
	root = add( root, new BSTreeNode<T>(c) );
    }

    /*======== public BSTreeNode<T> add() ==========
      Inputs:  BSTreeNode<T> curr
               BSTreeNode<T> t 
      Returns: 

      Add t to the correct place in the tree rooted at curr.
      ====================*/
    private BSTreeNode<T> add(BSTreeNode<T> curr, BSTreeNode<T> t) {
	if (curr == null){
	    return t;
	}else if (curr.compareTo(t) < 0){
	    curr.setRight(add (curr.getRight(), t));
	    return curr;
	}else{
	    curr.setLeft(add (curr.getLeft(),t));
	    return curr;
	}
    }

    /*======== public void remove() ==========
      Inputs:   T c  
      Returns: 
      
      Wrapper for the recursive remove method
      ====================*/
    public void remove( T c ) {
	BSTreeNode<T> compare = new BSTreeNode<T>(c);
	root = remove( root, compare );
    }

    /*======== public BSTreeNode<T> remove() ==========
      Inputs:   BSTreeNode<T> curr
		T c
      Returns: 

      Should remove the value c from the tree rooted at
      curr, if it exists.
      ====================*/
    private BSTreeNode<T> remove( BSTreeNode<T> curr, BSTreeNode<T> c ) {
	if (curr == null){
	    return curr;
	}
	if (c.compareTo(curr) < 0){ //c is less than curr
	    curr.setLeft(remove(curr.getLeft(), c));
	}else if (c.compareTo(curr) > 0){ //c is greater than curr
	    curr.setRight(remove(curr.getRight(), c));
	}else{
	    if (curr.isLeaf()){
		curr = null;
	    }else if (curr.numChildren() == 1){
		if (curr.getLeft() == null){
		    curr.setData(getSucceeding(curr));
		}else{
		    curr.setData(getPreceeding(curr));
		}
	    }else{
		int x = rand.nextInt(2);
		if (x == 0){
		    curr.setData(getSucceeding(curr));
		}else{
		    curr.setData(getPreceeding(curr));
		}
	    }
	}
	return curr;
    }
    private T getPreceeding(BSTreeNode<T> curr){
	if (curr.getLeft().isLeaf()){
	    T data = curr.getLeft().getData();
	    curr.setLeft(null);
	    return data;
	}else{
	    BSTreeNode<T> r = curr.getLeft();
	    while(r.getRight().getRight() != null){
		r = r.getRight();
	    }
	    BSTreeNode<T> hold = r.getRight();
	    r.setRight(null);
	    return hold.getData();
	}
    }
    private T getSucceeding(BSTreeNode<T> curr){
	if (curr.getRight().isLeaf()){
	    T data = curr.getRight().getData();
	    curr.setRight(null);
	    return data;
	}else{
	    BSTreeNode<T> l = curr.getRight();
	    while(l.getLeft().getLeft() != null){
		l = l.getLeft();
	    }
	    BSTreeNode<T> hold = l.getLeft();
	    l.setLeft(null);
	    return hold.getData();
	}
    }

    /*======== public void inOrder()) ==========
      Inputs:   
      Returns: 

      Wrapper for the recursive inOrder method
      ====================*/
    public void inOrder() {
	inOrderHelper( root );
	System.out.println();
    }

    /*======== public void inOrderHelper() ==========
      Inputs:   BSTreeNode<T> t  
      Returns: 
      
      Performs an in-order traversal for the tree with 
      root t.
      ====================*/
    public void inOrderHelper( BSTreeNode<T> t ) {
	if (t == null) 
	    return;
	inOrderHelper( t.getLeft() );
	System.out.print( t.getData() + " ");
	inOrderHelper( t.getRight() );
    }

    ////////// DONATED BY DENNIS YATUNIN //////////
    public int getHeight(){
	return getHeight(root);
    }

    private int getHeight(BSTreeNode<T> r ){
	if(r == null){
	    return 0;
	}else{
	    //System.out.println("recursion height");
	    return 1 + Math.max(getHeight(r.getLeft()),
				getHeight(r.getRight()));
	}
    }

    private int maxLength() {
	// returns the minimum number of characters required
	// to print the data from any node in the tree
	if (root == null)
	    return 0;
	return maxLength(root);
    }

    private int maxLength(BSTreeNode<T> curr) {
	int max = curr.toString().length();
	int temp;
	if (curr.getLeft() != null) {
	    temp = maxLength(curr.getLeft());
	    if (temp > max)
		max = temp;
	}
	if (curr.getRight() != null) {
	    temp = maxLength(curr.getRight());
	    if (temp > max)
		max = temp;
	}
	return max;
    }

    private String spaces(double n) {
	// returns a String of n spaces
	String result = "";
	for (int i = 0; i < n; i++)
	    result += " ";
	return result;
    }

    /*
      getLevel will produce a String for each level of the tree.
      The resulting Strings will look like this:

      ._______________________________
      ._______________._______________
      ._______._______._______._______
      .___.___.___.___.___.___.___.___
      ._._._._._._._._._._._._._._._._

      toString will combine those Strings and provide an output that
      will look like this:

      _______________.
      _______._______________.
      ___._______._______._______.
      _.___.___.___.___.___.___.___.
      ._._._._._._._._._._._._._._._.
      In these diagrams, each dot represents wordLength characters,
      each underscore represents wordLength spaces, and, for any nodes
      that are null, the dots will be "replaced" by underscores.
    */

    private String getLevel(BSTreeNode<T> curr, int currLevel, int targetLevel, int height, int wordLength) {
	if (currLevel == 1){
	    return curr.toString() + 
		spaces(wordLength - curr.toString().length()) +
		spaces(wordLength * 
		       Math.pow(2, height - targetLevel + 1) - 
		       wordLength);
	}
	String result = "";
	if (curr.getLeft() != null){
	    result += getLevel(curr.getLeft(), currLevel - 1, targetLevel, height, wordLength);
	}else{
	    result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
	}
	if (curr.getRight() != null){
	    result += getLevel(curr.getRight(), currLevel - 1, targetLevel, height, wordLength);
	}else{ 
	    result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
	}
	return result;
    }
		
    public String toString() {
	if (root == null)
	    return "";
	String result = "";
	int height = getHeight();
	int wordLength = maxLength();
	// add the every level of the tree except the last one
	for (int level = 1; level < height; level++){
	    // remove extra spaces from the end of each level's String to prevent lines from
	    // getting unnecessarily long and add spaces to the front of each level's String
	    // to keep everything centered
	    result += spaces(wordLength * Math.pow(2, height - level) - wordLength) +
		getLevel(root, level, level, height, wordLength).replaceFirst("\\s+$", "") +
		"\n";
	}
	// now add the last level (level = height)
	result += getLevel(root, height, height, height, wordLength).replaceFirst("\\s+$", "");
				
	return result;
    }

    public static void main( String[] args ) {
	BSTree<String> tree = new BSTree<String>();
	
	tree.add("m");
	tree.add("f");
	tree.add("a");
	tree.add("r");
	tree.add("c");
	tree.add("z");
	tree.add("g");
	System.out.println();
	System.out.println(tree);
	System.out.println();
	tree.inOrder();
	System.out.println();

	tree.remove("f");
	System.out.println(tree);
	System.out.println();
	tree.inOrder();

    }

}
