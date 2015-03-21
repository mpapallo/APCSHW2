public class LNode<T>{
    private T data;
    private LNode<T> next;

    public LNode(T d){
	data = d;
    }
    public LNode(){}

    public void setData(T d){
	data = d;
    }
    public T getData(){
	return data;
    }
    public void setNext(LNode<T> n){
	next = n;
    }
    public LNode<T> getNext(){
	return next;
    }
    
}
