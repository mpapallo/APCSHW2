import java.util.*;
import java.io.*;

public class CowTravelling{

    private File input;
    private Scanner scan;
    private String[][] map;
    private int time, x1, y1, x2, y2, numWays;

    public CowTravelling(){
	try{
	    input = new File("ctravel.txt");
	    scan = new Scanner(input);
	}catch(Exception e){}

	map = new String[scan.nextInt()][scan.nextInt()];
	time = scan.nextInt();

	for (int y = 0; y < map.length; y ++){
	    for (int x = 0; x < map[0].length; x ++){
		map[y][x] = scan.next();
	    }
	}

	x1 = scan.nextInt() - 1;
	y1 = scan.nextInt() - 1;
	x2 = scan.nextInt() - 1;
	y2 = scan.nextInt() - 1;

	numWays = 0;
    }

    public int go(){
	go(x1, y1, time);
	return numWays;
    }
    
    public void go(int x, int y, int t){
	if (x < 0 || x >= map[0].length || y < 0 || y >= map.length){
	    return;
	}
	if (t == 0 && x == x2 && y == y2){
	    numWays ++;
	    return;
	}
	if (map[y][x].equals("*") || t == 0){
	    return;
	}
	go(x + 1, y, t - 1);
	go(x - 1, y, t - 1); 
	go(x, y + 1, t - 1);
	go(x, y - 1, t - 1);
    }

    public String toString(){
	String ans = "";
	for (int r = 0; r < map.length; r ++){
	    for (int c = 0; c < map[0].length; c ++){
		ans += map[r][c] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }

    public static void main(String[]args){
	CowTravelling c = new CowTravelling();
	System.out.println(c);
	System.out.println(c.go());
    }

}
