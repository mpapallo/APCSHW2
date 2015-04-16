import java.util.*;
import java.io.*;
public class Maze{

    private char[][]maze;
    private int maxx, maxy;
    private int startx,starty, endx, endy;
    private Coord end;
    private int solveLen;
    private int[] solution;
    private int DFS = 0;
    private int BFS = 1;
    private int Best = 2;
    private int Astar = 3;

    public String name(){
	return "michaela.papallo";
    }

    public Maze(String filename){
	startx = -1;
	starty = -1;
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));
	    while(in.hasNext()){
		String line= in.nextLine();
		if(maxy==0){
		    //calculate width of the maze
		    maxx=line.length();
		}
		//every new line add 1 to the height of the maze
		maxy++;
		ans+=line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: "+filename+" could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}

	maze = new char[maxy][maxx];
	int i = 0;
	for (int y = 0; y < maxy; y ++){
	    for (int x = 0; x < maxx; x ++){
		char c = ans.charAt(i);
		maze[y][x] = c;
		if (c == 'S'){
		    startx = x;
		    starty = y;
		}
		if (c == 'E'){
		    endx = x;
		    endy = y;
		}
		i ++;
	    }
	}
    }

    ////////// toString stuff //////////
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    public String toString(){
	String ans = "" + maxy + " rows by " + maxx + " columns\n";
	for (int y = 0; y < maxy; y ++){
	    for (int x = 0; x < maxx; x ++){
		ans += maze[y][x];
	    }
	    ans += "\n";
	}
	return ans;
    }
    public String toString(boolean animate){
	if (animate){
	    return hide + clear + go(0,0) + toString() + show;
	}else{
	    return toString();
	}
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }
    ////////////////////

    ////////// Solve methods //////////
    public boolean solveDFS(){
	return solve(0, false);
    }
    public boolean solveDFS(boolean animate){
	return solve(0, animate);
    }
    public boolean solveBFS(){
	return solve(1, false);
    }
    public boolean solveBFS(boolean animate){
	return solve(1, animate);
    }
    public boolean solveBest(){
	return solveBest(false);
    }
    public boolean solveBest(boolean animate){
	return solve(2, animate);
    }
    
    public boolean solve(int mode, boolean animate){
	Frontier f = new Frontier(mode);
	Coord start = new Coord(startx, starty);
	if (mode == DFS || mode == BFS){
	    f.add(start);
	}else if (mode == Best){
	    f.add(start, abs(endx-startx) + abs(endy-starty));
	}
	
	while(!f.isEmpty()){
	    if (animate){
		wait(20);
		System.out.println(toString(animate));
	    }
	    
	    Coord current = f.remove();
	    int x = current.getX();
	    int y = current.getY();

	    if (maze[y][x] == 'E'){
		end = current;
		Coord c = end;
		while(c != null){
		    solveLen ++;
		    c = c.getPrev();
		}
		//System.out.println(solveLen);
		clearPath();
		addCoordstoArray();
		System.out.println(toString());
		return true;
	    }else{
		maze[y][x] = '.';
		Coord[] candidates = new Coord[]{
		    new Coord(x-1, y),
		    new Coord(x+1, y),
		    new Coord(x, y-1),
		    new Coord(x, y+1),
		};
		for (Coord cord : candidates){
		    cord.setPrev(current);
		    int ex = cord.getX();
		    int why = cord.getY();
		    if (mode == DFS || mode == BFS){
			if (inRange(ex, why) && isValidSpace(ex, why)){
			    f.add(cord);
			}
		    }else if (mode == Best){
			if (inRange(ex, why) && isValidSpace(ex, why)){
			    f.add(cord, abs(endx-ex) + abs(endy-why));
			}
		    }	
		}
	    }  
	}
	System.out.println("No Solution\n");
	return false;
    }
      
    public boolean inRange(int x, int y){
	return !(x < 0 || y < 0 || x >= maxx || y >= maxy);
    }
    public boolean isValidSpace(int x, int y){
	return !(maze[y][x] == '#' || maze[y][x] == '.');
    }

    public int abs(int x){
	if (x < 0){
	    return x *= -1;
	}else{
	    return x;
	}
    }

    public void clearPath(){
	Coord c = end;
	while (c != null){
	    int x = c.getX();
	    int y = c.getY();
	    if (x == end.getX() && y == end.getY()){
		maze[y][x] = 'E';
	    }else if (x == startx && y == starty){
		maze[y][x] = 'S';
	    }else{
		maze[y][x] = 'P';
	    }
	    c = c.getPrev();
	}
	for (int y = 0; y < maxy; y ++){
	    for (int x = 0; x < maxx; x ++){
		if (maze[y][x] == '.'){
		    maze[y][x] = ' ';
		}
	    }
	}
    }

    public void addCoordstoArray(){
	solution = new int[solveLen * 2];
	Coord c = end;
	int i = 0;
	//add coordinates in reverse order
	while (c!= null){
	    solution[i] = c.getX();
	    solution[i+1] = c.getY();
	    i += 2;
	    c = c.getPrev();
	}
	solution = reverse(solution);
    }

    public int[] solutionCoordinates(){
	return solution;
    }
    
    public int[] reverse(int[] a){
	for (int x = 0; x < a.length / 2; x ++){
	    int temp = a[x];
	    a[x] = a[a.length - x - 1];
	    a[a.length - x - 1] = temp;
	}
	return a;
    }

}
