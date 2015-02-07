public class Driver{
    public static void main(String[]args){
	Recursion r = new Recursion();

	System.out.println(r.name());

	System.out.println(r.fact(0));
	System.out.println(r.fact(1));
	System.out.println(r.fact(2));
	System.out.println(r.fact(5));

	System.out.println(r.fib(0));
	System.out.println(r.fib(1));
	System.out.println(r.fib(5));
    }
}
