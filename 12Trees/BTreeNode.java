public class BTreeNode<T>{

    private T data;
    private BTreeNode<T> left, right;

    public BTreeNode(T data){
	setData(data);
    }
    
    public void setData(T data){
	this.data = data;
    } 
    public T getData(){
	return data;
    }

    public void setLeft(BTreeNode l){
	left = l;
    }
    public void setRight(BTreeNode r){
	right = r;
    }
    public BTreeNode<T> getLeft(){
	return left;
    }
    public BTreeNode<T> getRight(){
	return right;
    }
    
    public String toString(){
	return "" + data;
    }

}
