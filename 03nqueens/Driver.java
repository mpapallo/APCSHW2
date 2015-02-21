public class Driver{
    public static void main(String[]args){
	
	int size = 4;

	if (args.length > 0){
	    int s = Integer.parseInt(args[0]);
	    if (s > 0){
		size = s;
	    }
	}

	NQueens board = new NQueens(size);
	if (board.solve()){
	    System.out.println(board);
	}else{
	    System.out.println("No Solution");
	}
    }
}
