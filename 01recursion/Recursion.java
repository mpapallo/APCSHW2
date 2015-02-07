public class Recursion implements hw1{
    
    public String name(){
	return "Papallo,Michaela";
    }

    public int fact(int n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	if (n == 0){
	    return 1;
	}
	return n * fact(n - 1);
    }

    public int fib(int n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	return fibHelper(n, 0, 1);
    }

    public int fibHelper(int n, int a, int b){
	if (n == 0){
	    return a;
	}
	return fibHelper(n - 1, b, b + a);
    }
    
    public double sqrt(double n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	return sqrtHelper(n, n / 2);
    }

    public double sqrtHelper(double n, double guess){
	if (Math.abs(guess * guess - n) < 0.0000000001){
	    return guess;
	}
	return sqrtHelper(n, (n / guess + guess) / 2);
    }
    
}
