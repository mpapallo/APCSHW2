public class RunningMedian{
    
    private MyHeap max, min;
    
    public RunningMedian(){
	max = new MyHeap();
	min = new MyHeap(false);
    }

    public double getMedian(){
        int h1 = max.size();
	int h2 = min.size();
	if (h1 > h2){
	    return max.peek();
	}else if (h1 < h2){
	    return min.peek();
	}else{
	    return max.peek() + min.peek() / 2.0;
	}
    }
    
    public void add(int n){
	if (max.size() == 0 && min.size() == 0){
	    max.add(n);
	}else{
	    double med = getMedian();
	    if (n > med){
		min.add(n);
	    }else{
		max.add(n);
	    }
	    if (min.size() > max.size() + 1){
		max.add(min.remove());
	    }
	    if (max.size() > min.size() + 1){
		min.add(max.remove());
	    }
	}
    }
    
    public static void main(String[] args){
	RunningMedian med = new RunningMedian();

	med.add(2);
	med.add(4);
	System.out.println(med.getMedian());

    }

}
