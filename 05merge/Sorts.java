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
	
    }

    public static void main(String[] args){
	int[] a = {1, 3, 5, 7, 7, 9, 20};
	int[] b = {1, 2, 4, 6, 8, 56};
	int[]c = merge(a, b);
        for (int x = 0; x < c.length; x ++){
	    System.out.print(c[x] + ",");
	}
    }

}
