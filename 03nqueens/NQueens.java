public class NQueens{
    //constants for the class

    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
    //instance variable
    private char[][]board;
    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String name(){
	return "papallo.michaela";
    }

    public String toString(){
	String ans = "\n";
	for (int y = 0; y < board.length; y ++){
	    for (int x = 0; x < board[0].length; x ++){
		ans += " " + board[y][x];
	    }
	    ans += "\n";
	}
	return hide + clear + go(0,0) + ans + "\n" + show;
    }

    public NQueens(int size){
	board = new char[size][size];
	for (int y = 0; y < size; y ++){
	    for (int x = 0; x < size; x ++){
		board[y][x] = '_';
	    }
	}
    }
    
    public boolean solve(){
	return solve(0, board.length);
    }
    
    public boolean solve(int x){
	if (x < 0 || x > board.length){
	    return false;
	}
	board[0][x] = 'Q';
	return solve(1, board.length - 1);
    }

    public boolean solve(int y, int numQueens){
	if (y == board.length && numQueens == 0){
	    return true;
	}
	for (int x = 0; x < board.length; x ++){
	    if (canPlaceQueen(x, y)){
	        board[y][x] = 'Q';
		if (solve(y + 1, numQueens - 1)){
		    return true;
		}
		board[y][x] = 'Q';
	    }
	}
	return false;
    }

    public boolean canPlaceQueen(int startx, int starty){
	for (int x = 0; x < startx; x ++){
	    if (board[starty][x] = 'Q'){
		return false;
	    }
	}
	for (int y = 0; y < starty; y ++){
	    if (board[y][startx] = 'Q'){
		return false;
	    }
	}
	//check diagonal
	return true;;
    }
}

