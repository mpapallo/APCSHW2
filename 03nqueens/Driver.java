public class Driver{
    public static void main(String[]args){
	NQueens board = new NQueens(4);
	if (board.solve()){
	    System.out.println(board);
	}
    }
}
