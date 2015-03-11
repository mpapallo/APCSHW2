import java.util.*;
import java.io.*;
public class Sorts{

    public static int[] merge(int[] a, int[] b){
	int[] c = new int[a.length + b.length];
        return mergeh(a, b, c, 0, 0, 0);
    }
    public static int[] mergeh(int[] a, int[] b, int[] c, int ia, int ib, int ic){
	if (ic == c.length){
	    return c;
	}
	if (ia == a.length){
	    c[ic] = b[ib];
	    return mergeh(a, b, c, ia, ib + 1, ic + 1);
	}
	if (ib == b.length){
	    c[ic] = a[ia];
	    return mergeh(a, b, c, ia + 1, ib, ic + 1);
	}
	if (a[ia] < b[ib]){
	    c[ic] = a[ia];
	    return mergeh(a, b, c, ia + 1, ib, ic + 1);
	}else{
	    c[ic] = b[ib];
	    return mergeh(a, b, c, ia, ib + 1, ic + 1);
	}
    }

    public static void mergesort(int[] m){
	int[] sorted = new int[m.length];
	sorted = msh(m);
        for (int i = 0; i < m.length; i ++){
	    m[i] = sorted[i];
	}
    }
    public static int[] msh(int[] m){
	if (m.length == 1){
	    return m;
	}
	int[] first = new int[m.length / 2];
	int[] second = new int[m.length - first.length];
	for (int i = 0; i < first.length; i ++){
	    first[i] = m[i];
	}
	for (int i = 0; i < second.length; i ++){
	    second[i] = m[first.length + i];
	}
	return merge(msh(first), msh(second));
    }

    public static void quicksort(int[] a){
	quicksort(a, 0, a.length - 1);
    }
    public static void quicksort(int[] a, int si, int ei){
        if (si < ei){
	    int index = parition(a, si, ei);
	    quicksort(a, si, index - 1);
	    quicksort(a, index + 1, ei);
	}
    }

    public static int parition(int[] a, int si, int ei){
	int pi = rand.nextInt(ei + 1 - si) + si;
	int pivot = ary[pi];
	int end = ei;
	int i = si;
	while(i<=end && si!=ei){
	    if(ary[i]<pivot){
		int x = ary[i];
		ary[i] = ary[si];
		ary[si] = x;
		si++;
		if(x==pivot){
		    pi = si;
		}else if(ary[i]==pivot){
		    pi = i;
		}
		i++;
	    }else if(ary[i]>pivot){
		int x = ary[i];
		ary[i] = ary[ei];
		ary[ei] = x;
		ei--;
		if(x==pivot){
		    pi = ei;
		}else if(ary[i]==pivot){
		    pi = i;
		}
	    }else{
		i++;
	    }
	}
	int x = ary[si];
	ary[si] = pivot;
	ary[pi] = x;
	//System.out.println(pivot);
	//System.out.println(Arrays.toString(ary));
	return pi;
    }

    public static void main(String[] args){
	/*
	int[] test = new int[100];
	for (int i = 0; i < 100; i ++){
	    test[i] = 100 - i;
	}
        mergesort(test);
	for (int i = 0; i < test.length; i ++){
	    System.out.print(test[i] + ",");
	}
	*/


    }

}
