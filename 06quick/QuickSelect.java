import java.util.*;
public class QuickSelect{
    
    private static Random rand = new Random();

    public static void select(int[] ary, int n){
	
    }

    public static void partition(int[] ary, int si, int ei){
	//randomly pick a pivot point, save its value
	int ri = rand.nextInt(ei + 1 - si) + si;
	int pivot = ary[ri];
	//make new array
	int[] d = new int[ary.length];
	int end = ei;
	//for elements between si and ei:
	for (int i = si; i <= end; i ++){
	    if (ary[i] < pivot){
		d[si] = ary[i];
		si ++;
	    }else if (ary[i] > pivot){
	        d[ei] = ary[i];
		ei --;
	    }
	}
	d[si] = pivot;
	//copy over elements that aren't in range [si, ei]
	//before:
	for (int i = si - 1; i >= 0; i --){
	    d[i] = ary[i];
	}
	//after:
	for (int i = ei + 1; i < ary.length; i ++){
	    d[i] = ary[i];
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
	for (int i = 0; i < ary.length; i ++){
	    System.out.print(ary[i] + ", ");
	}
	System.out.println();
	System.out.println();

	partition(ary, 0, 9);
	
    }
    
}
