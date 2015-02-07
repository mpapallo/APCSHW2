public class Recursion{
    
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
	if (n == 0){
	    return 1;
	}
	return fibHelper(n, 1, 1);
    }

    public int fibHelper(int n, int a, int b){
	if (n == 1){
	    return b;
	}
	return fibHelper(n - 1, b, b + a);
    }

    //public double sqrt(double n){
	
    //}
}
