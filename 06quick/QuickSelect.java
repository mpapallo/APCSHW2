import java.util.*;
public class QuickSelect{
    
    private static Random rand = new Random();

    public static int select(int[] ary, int n){
	return partitionInPlace(ary, n, 0, ary.length - 1);
    }

    public static int partitionInPlace(int[] ary, int n, int si, int ei){
	//randomly pick a pivot point, save its value
	int ri = rand.nextInt(ei + 1 - si) + si;
	int pivot = ary[ri];
	int start = si;
	int end = ei;
	//for elements between si and ei:
	for (int i = si; i <= ei; i ++){
	    if (ary[i] < pivot){
		int x = ary[start];
		ary[start] = ary[i];
		ary[i] = ary[start];
		start ++;
	    }else if (ary[i] > pivot){
	        int x = ary[end];
		ary[end] = ary[i];
		ary[i] = x;
		end --;
	    }
	}
	ary[start] = pivot;
	System.out.println(pivot);
	System.out.println(Arrays.toString(ary));
	if (start == n - 1){
	    return ary[start];
	}
	else if(start < n - 1){
	    return partitionInPlace(ary, n, start, ei);
	}else{
	    return partitionInPlace(ary, n, si, start);
	}
    }

    public static int partition(int[] ary, int n, int si, int ei){
	//randomly pick a pivot point, save its value
	int ri = rand.nextInt(ei + 1 - si) + si;
	int pivot = ary[ri];
	//make new array
	int[] d = new int[ary.length];
	int start = si;
	int end = ei;
	//for elements between si and ei:
	for (int i = si; i <= ei; i ++){
	    if (ary[i] < pivot){
		d[start] = ary[i];
		start ++;
	    }else if (ary[i] > pivot){
	        d[end] = ary[i];
		end --;
	    }
	}
	d[start] = pivot;
	//copy over elements that aren't in range [si, ei]
	//before:
	for (int i = si - 1; i >= 0; i --){
	    d[i] = ary[i];
	}
	//after:
	for (int i = ei + 1; i < ary.length; i ++){
	    d[i] = ary[i];
	}

	//System.out.println(pivot);
	//System.out.println(Arrays.toString(d)); 
	if (start == n - 1){
	    return d[start];
	}
	else if(start < n - 1){
	    return partition(d, n, start, ei);
	}else{
	    return partition(d, n, si, start);
	}
	
    }

    public static void main(String[]args){

	int[] ary = new int[10];
	for (int i = 0; i < ary.length; i ++){
	    ary[i] = i;
	}
	for (int i = 0; i < ary.length; i ++){
	    int x = ary[i];
	    int index = rand.nextInt(ary.length - 1);
	    ary[i] = ary[index];
	    ary[index] = x;
	}
	System.out.println(Arrays.toString(ary));
	System.out.println();

        System.out.println(select(ary, 5));
	
    }
    
}
