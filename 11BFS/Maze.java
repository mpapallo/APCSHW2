import java.util.*;
import java.io.*;
public class Maze{

    private char[][]maze;
    private int maxx, maxy;
    private int startx,starty;
    private Frontier solver;
    private Coord end;

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

	maze = new char[maxx][maxy];
	for(int i=0;i<ans.length();i++){
	    char c = ans.charAt(i);
	    maze[i%maxx][i/maxx]= c;
	    if(c=='S'){
		startx = i%maxx;
		starty = i/maxx;
	    }
	}
    }

    private String go(int x,int y){
	return ("["+x+";"+y+"H");
    }    
    private String clear(){
	return  "[2J";
    }
    private String hide(){
	return  "[?25l";
    }
    private String show(){
	return  "[?25h";
    }
    private String invert(){
	return  "[37";
    }
    public void clearTerminal(){
	System.out.println(clear());
    }

    public String toString(){
	String ans = ""+maxx+","+maxy+"\n";
	for(int i=0;i<maxx*maxy;i++){
	    if(i%maxx ==0 && i!=0){
		ans+="\n";
	    }
	    ans += maze[i%maxx][i/maxx];
	}
	return ans;
    }
    public String toString(boolean animate){
	if (animate){
	    String ans = ""+maxx+","+maxy+"\n";
	    for(int i=0;i<maxx*maxy;i++){
		if(i%maxx ==0 && i!=0){
		    ans+="\n";
		}
		ans += maze[i%maxx][i/maxx];
	    }
	    return hide()+invert()+go(0,0)+ans+"\n"+show();
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

    public boolean solveBFS(){
	return solveBFS(false);
    }
    public boolean solveBFS(boolean animate){
	solver = new Frontier(1);
	Coord c = new Coord(startx, starty);
	return BFS(solver, c);
    }    
    public boolean BFS(Frontier f, Coord current){
	f.add(current);
	if (inRange(x, y) && isValidSpace(x, y)){
	    if (maze[y][x] == 'E'){
		end = current;
		return true;
	    }else if (maze[y][x] == 'S' || maze[y][x] == ' '){
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
		
		return BFS(f, f.remove()); 
	    }
	}else{
	    return false;
	}
    }
    /*
    public boolean solveDFS(){
	return solveDFS(false);
    }
    public boolean solveDFS(boolean animate){
	solver = new Frontier(0);
	return DFS(solver, startx, starty);
    }
    public boolean DFS(Frontier f, int x, int y){
	
    }
    */
    public boolean inRange(int x, int y){
	return !(x < 0 || y < 0 || x > maxx || y > maxy);
    }
    public boolean isValidSpace(int x, int y){
	return !(maze[y][x] == '#');
    }

    public static void main(String[]args){
	
	Maze m = new Maze("data1.dat");
	System.out.println(m);
	
    }

}
