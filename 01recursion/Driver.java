public class Driver{
    public static void main(String[]args){
	Recursion r = new Recursion();

	System.out.println(r.name());
	System.out.println();
	System.out.println(r.fact(0));
	System.out.println(r.fact(1));
	System.out.println(r.fact(5));
	System.out.println();
	System.out.println(r.fib(0));
	System.out.println(r.fib(1));
	System.out.println(r.fib(5));
	System.out.println();
	System.out.println(r.sqrt(0));
	System.out.println(r.sqrt(9));
	System.out.println(r.sqrt(100));

	System.out.println(r.sqrt(0.00000001));

    }
}
