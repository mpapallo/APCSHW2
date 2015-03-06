import java.util.*;
public class QuickSelect{
    
    private static Random rand = new Random();

    public static void partition(int[] ary, int si, int ei){
	//randomly pick a pivot point, save its value
	int pivot = rand.nextInt(ei + 1 - si) + si;

	//testing:
	//System.out.println(pivot);
	//System.out.println();

	//make new array
	int[] d = new int[ary.length];
	int start = si;
	int end = ei;
	//for elements bwetween si and ei:
	for (int i = si; i <= ei; i ++){
	    if (ary[i] < ary[pivot]){
		d[start] = ary[i];
		start ++;
	    }else if (ary[i] > ary[pivot]){
	        d[end] = ary[i];
		end --;
	    }
	}
	d[start] = ary[pivot];
	//copy over elements that aren't in range [si, ei]
	//before:
	for (int i = si - 1; i >= 0; i --){
	    d[i] = ary[i];
	}
	//after:
	for (int i = ei + 1; i < ary.length; i ++){
	    d[i] = ary[i];
	}
	
	//testing:
	for (int i = 0; i < d.length; i ++){
	    System.out.print(d[i] + ", ");
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
