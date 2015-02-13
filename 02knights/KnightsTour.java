import java.util.*;
import java.io.*;

public class KnightsTour{
    //constants for the class

    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
    //instance variable
    private int[][]board;
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
	return "Papallo,Michaela";
    }

    public String toString(){
	String ans = "\n";
	for (int y = 0; y < board.length; y ++){
	    for (int x = 0; x < board[0].length; x ++){
		if (board[y][x] < 10){
		    ans += "  " + board[y][x];
		}else{
		    ans += " " + board[y][x];
		}
	    }
	    ans += "\n";
	}
	return hide + clear + go(0,0) + ans + "\n" + show;
    }

    public KnightsTour(int size){
	board = new int[size][size];
	for (int y = 0; y < size; y ++){
	    for (int x = 0; x < size; x ++){
		board[y][x] = 0;
	    }
	}
    }

    public boolean solve(){
	return solve(0, 0);
    }

    public boolean solve(int startx, int starty){
	return solve(startx, starty, 1);
    }
		
    public boolean solve(int x,int y,int currentMoveNumber){
	//System.out.println(this);
	//wait(5);
	if (y < 0 || x < 0 || y >= board.length || x >= board[0].length){
	    return false;
	}
	if (board[y][x] == 0 && board.length * board.length == currentMoveNumber){
	    board[y][x] = currentMoveNumber;
	    return true;
	}
	if (board[y][x] == 0){
	    board[y][x] = currentMoveNumber;
	    if (solve(x + 2, y - 1, currentMoveNumber + 1) ||
		solve(x + 1, y - 2, currentMoveNumber + 1) ||
		solve(x + 2, y + 1, currentMoveNumber + 1) ||
		solve(x - 2, y + 1, currentMoveNumber + 1) ||
		solve(x - 2, y - 1, currentMoveNumber + 1) ||
		solve(x + 1, y + 2, currentMoveNumber + 1) ||
		solve(x - 1, y + 2, currentMoveNumber + 1) ||
		solve(x - 1, y - 2, currentMoveNumber + 1)){
		return true;
	    }
	    board[y][x] = 0;
	}
	return false;
    }
}
