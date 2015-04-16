import java.util.*;
public class Driver{
    public static void main(String[]args){
	
	Maze m = new Maze("data1.dat");
	boolean b = false;
	
	if (args.length < 1){
	    System.out.println("usage: args[0] = mode (DFS, BFS, Best, Astar); args[1] = animate (true, false)");
	}else{
	    if (args[1].equals("true")){
		b = true;
	    }
	    if (args[0].equals("BFS")){
		m.solveBFS(b);
		System.out.println(Arrays.toString(m.solutionCoordinates()));
	    }else if (args[0].equals("DFS")){
		m.solveDFS(b);
		System.out.println(Arrays.toString(m.solutionCoordinates()));
	    }
	}
	
    }
}
