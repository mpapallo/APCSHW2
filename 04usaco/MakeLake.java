import java.io.*;
import java.util.*;
public class MakeLake{

    private File input;
    private Scanner scan;
    private int[][] pasture;
    private int[][] instructions;
    private int elevation;
    
    public MakeLake(){
	try{
	    input = new File("makelake.txt");
	    scan = new Scanner(input);
	}catch(Exception e){}
	pasture = new int[scan.nextInt()][scan.nextInt()];
	elevation = scan.nextInt();
	instructions = new int[scan.nextInt()][3];
	
	for (int r = 0; r < pasture.length; r ++){
	    for (int c = 0; c < pasture[0].length; c ++){
		pasture[r][c] = scan.nextInt();
	    }
	}

	for (int n = 0; n < instructions.length; n ++){
	    for (int i = 0; i < 3; i ++){
		instructions[n][i] = scan.nextInt();
	    }
	}
	
    }
    
    public int go(){
	for (int line = 0; line < instructions.length; line ++){
	    int max = 0;
	    int starty = instructions[line][0];
	    int startx = instructions[line][1];
	    int e = instructions[line][2];
	    for (int y = starty - 1; y < starty + 2; y ++){
		for (int x = startx - 1; x < startx + 2; x ++){
		    if (pasture[y][x] > max){
			max = pasture[y][x];
		    }
		}
	    }
	    for (int y = starty - 1; y < starty + 2; y ++){
		for (int x = startx - 1; x < startx + 2; x ++){
		    if (pasture[y][x] > max - e){
			pasture[y][x] = max - e;
		    }
		}
	    }
	}
        int vol = 0;
	for (int y = 0; y < pasture.length; y ++){
	    for (int x = 0; x < pasture[0].length; x ++){
		if (pasture[y][x] < elevation){
		    vol += elevation - pasture[y][x];
		}
	    }
	}
	return vol;
    }
    
    public String toString(){
	String ans = "";
	for (int r = 0; r < pasture.length; r ++){
	    for (int c = 0; c < pasture[0].length; c ++){
		ans += pasture[r][c] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }

    public static void main(String[]args){
	MakeLake m = new MakeLake();
	System.out.println(m);
	System.out.println(m.go());
	System.out.println();
	System.out.println(m);
    }

}
