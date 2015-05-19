import java.util.*;
public class Sorts{
    
    public static void heapsort(int[] arr){
	System.out.println(Arrays.toString(arr));
	for (int i = arr.length - 1; i >= 0; i --){
	    swapDown(arr, i);
	}
	System.out.println(Arrays.toString(arr));
    }

    private static void swapDown(int[] arr, int i){
	int size = arr.length;
	while (getLeft(i) < size){ //while value has a left child
	    int l = getLeft(i);
	    int r = getRight(i);

	    if (r < size){ //if value has a right child
		if (!inOrder(arr, i, l) || !inOrder(arr, i, l)){
		    int dif = arr[l] - arr[r];
		    if (dif > 0){
			swap(arr, i, l);
			i = l;
		    }else if (dif < 0){
			swap(arr, i, r);
			i = r;
		    }
		}else{
		    return;
		}
	    }else if (!inOrder(arr, i, l)){
		swap(arr, i, l);
		i = l;
	    }else{
		return;
	    }
	}
    }
    private static void swap(int[] arr, int a, int b){
	int temp = arr[a];
	arr[a] = arr[b];
	arr[b] = temp;
    }
    private static boolean inOrder(int[] arr, int a, int b){
	//a is the parent, b is the child
	return arr[a] > arr[b];
    }
    private static int getLeft(int i){
	return i * 2 +  1;
    }
    private static int getRight(int i){
	return i * 2 + 2;
    }
    private static int getParent(int i){
	return i / 2 - 1;
    }
    
}
