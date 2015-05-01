public class TreeNode<T>{

    private T data;
    private TreeNode<T> left, right;

    public TreeNode(T data){
	setData(data);
    }
    
    public void setData(T data){
	this.data = data;
    } 
    public T getData(){
	return data;
    }

    public void setLeft(TreeNode l){
	left = l;
    }
    public void setRight(TreeNode r){
	right = r;
    }
    public TreeNode<T> getLeft(){
	return left;
    }
    public TreeNode<T> getRight(){
	return right;
    }
    
}