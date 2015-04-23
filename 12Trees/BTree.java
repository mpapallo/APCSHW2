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

    public void add(T d){
	TreeNode<T> a = new TreeNode<T>(d);
	add(root, a);
    }
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

}