import java.util.*;
import java.io.*;
public class Maze{

    private char[][]maze;
    private int maxx, maxy;
    private int startx,starty;
    private Coord end;
    private int solveLen;
    private int[] solution;

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
    public boolean solveBFS(){
	return solve(1, false);
    }
    public boolean solveBFS(boolean animate){
	return solve(1, animate);
    }
    public boolean solveDFS(){
	return solve(0, false);
    }
    public boolean solveDFS(boolean animate){
	return solve(0, animate);
    }

    public boolean solve(int mode, boolean animate){
	Frontier f = new Frontier(mode);
	Coord start = new Coord(startx, starty);
	f.add(start);
	
	while(!f.isEmpty()){
	    if (animate){
		wait(20);
		System.out.println(toString(animate));
	    }
	    
	    Coord current = f.remove();
	    int x = current.getX();
	    int y = current.getY();
	    
	    if (inRange(x, y) && isValidSpace(x, y)){
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
		    maze[y][x] = 'X';
		    Coord a = new Coord(x-1, y);
		    a.setPrev(current);
		    Coord b = new Coord(x+1, y);
		    b.setPrev(current);
		    Coord c = new Coord(x, y-1);
		    c.setPrev(current);
		    Coord d = new Coord(x, y+1);
		    d.setPrev(current);
		    f.add(a);
		    f.add(b);
		    f.add(c);
		    f.add(d);
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
	return !(maze[y][x] == '#' || maze[y][x] == 'X');
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
		maze[y][x] = '@';
	    }
	    c = c.getPrev();
	}
	for (int y = 0; y < maxy; y ++){
	    for (int x = 0; x < maxx; x ++){
		if (maze[y][x] == 'X'){
		    maze[y][x] = ' ';
		}
	    }
	}
    }
    ////////////////////
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

    public static void main(String[]args){
	
	Maze m = new Maze("data1.dat");
	System.out.println(m);

        m.solveBFS(false);
	System.out.println(Arrays.toString(m.solutionCoordinates()));
	
    }

}
