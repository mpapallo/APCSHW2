import java.util.*;
import java.io.*;

public class BTree<T>{

    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;
    private Random rand;
    private TreeNode<T> root;

    public BTree(){
	root = null;
	rand = new Random();
    }

    /*======== public void add() ==========
      Inputs:   E d
      Returns: 
      
      Wrapper method for the recursive add()
      ====================*/
    public void add(T d){
	TreeNode<T> a = new TreeNode<T>(d);
	add(root, a);
    }
    /*======== public void add() ==========
      Inputs:   TreeNode<E> curr, TreeNode<E> bn  
      Returns: 
      
      Adds bn to the tree rooted at curr. If curr has 
      an available child space, then attach bn there.

      Otherwise, try to add at the subtree rooted at
      one of curr's children. Choose the child to be
      added to randomly.
      ====================*/
    private void add(TreeNode<T> curr, TreeNode<T> bn){
	if (curr == null){
	    curr = bn;
	}else if (curr.getLeft() == null){
	    curr.setLeft(bn);
	}else if (curr.getRight() == null){
	    curr.getRight();
	}else{
	    int x = rand.nextInt(2);
	    if (x == 0){
		add(curr.getLeft(), bn);
	    }else{
		add(curr.getRight(), bn);
	    }
	}
    }

    /*======== traverse wrapper function ========
     */
    public void traverse(int mode){
	if (mode == PRE_ORDER){
	    preOrder(root);
	}else if (mdoe == IN_ORDER){
	    inOrder(root);
	}else{
	    postOrder(root);
	}
	System.out.println();
    }

    /*======== public void preOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing an
      pre-order Traversal
      ====================*/
    public void preOrder(TreeNode<T> curr){
	if (curr != null){
	    System.out.print(curr.getData());
	    preOrder(curr.getLeft());
	    preOrder(curr.getRight());
	}
    }
    /*======== public void inOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing an
      in-order Traversal
      ====================*/
    public void inOrder(TreeNode<T> curr){
	if (curr != null){
	    inOrder(curr.getLeft());
	    System.out.print(curr.getData());
	    inOrder(curr.getRight());
	}
    }
    /*======== public void postOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing a
      post-order Traversal    
      ====================*/
    public void postOrder(TreeNode<T> curr){
	if (curr != null){
	    postOrder(curr.getLeft());
	    postOrder(curr.getRight());
	    System.out.print(curr.getData());
	}
    }

    /*======== public int getHeight()) ==========
      Inputs:   
      Returns: The height of the tree

      Wrapper for the recursive getHeight method
      ====================*/
    public int getHeight() {
	return getHeight(root);
    }
    /*======== public int getHeight() ==========
      Inputs:   TreeNode<E> curr  
      Returns:  The height of the tree rooted at node curr
      
      ====================*/
    public int getHeight(TreeNode<T> curr){
	return getHeight(curr, 0);
    }
    private int getHeight(TreeNode<T> curr, int currHeight) {
	if (curr == null){
	    return currHeight;
	}else{
	    return Math.max(getHeight(curr.getLeft(), currHeight + 1), getHeight(curr.getRight(), currHeight + 1));
	}
    }

    /*======== public String getLevel() ==========
      Inputs:   TreeNode<E> curr
                int level
                int currLevel  
      Returns: A string containing all the elements on the
               given level, ordered left -> right
      
      ====================*/
    private String getLevel( TreeNode<E> curr, int level, int currLevel ) {
	if (currLevel == level){
	    return "" + curr.getData() + " ";
	}else{
	    return getLevel(curr.getLeft(), level, currLevel + 1) + getLevel(curr.getRight(), level, currLevel + 1);
	}
    }
    
    /*======== public String toString()) ==========
      Inputs:   
      Returns: A string representation of the tree
     
      This string should display each level as a separate line.
      A simple version might look something like this:

      0
      1 2
      3 4 5

      Note that you cannot tell exactly where 3, 4 and 5 lie.
      That is ok, but if you want a CHALLENGE, you can try to
      get the output to look nicer, something like this:
             0
          1      2
            3  4   5
      ====================*/
    public String toString() {
	String ans = "";
	return ans;
    }

}