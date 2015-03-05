import java.util.*
public class QuickSelect{
    
    private Random rand = new Random();

    public static void partition(int[] ary, int si, int ei){
	int pivot = rand.nextInt(ei - si) + si;
	System.out.println(pivot);
    }

    public static void main(String[]args){
	int[] ary = new int[10];
	
    }
    
}