import java.util.*;
public class Driver{

    public static void main(String[]args){
	
	int[] arr = new int[] {8, 9, 3, 1, 6, 4, 2, 7};
	System.out.println(Arrays.toString(arr));
	Sorts.heapsort(arr);
	System.out.println(Arrays.toString(arr));
    
    }
}
