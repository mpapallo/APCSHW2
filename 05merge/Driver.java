import java.util.*;
public class Driver{
    public static void main(String[]args){
	int which = 0;
	int size = 4000000;
	Random r = new Random();

	try{
	    which = Integer.parseInt(args[0]);
	    size = Integer.parseInt(args[1]);
	}catch(IndexOutOfBoundsException e){
	    System.out.println("Driver [which(0=merge, else=Arrays.sort)] [size]\n defaults: which=0, size=1,000,000");
	    return;
	}

	int[] a = new int[size];
	for (int i = 0; i < size; i ++){
	    a[i] = r.nextInt(size);
	}

	if (which == 0){
	    Sorts.mergesort(a);	
	}else{
	    Arrays.sort(a);
	}
	
    }
}