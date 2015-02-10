public class MazeSolver{
    public char[][] solveMaze(char[][] maze){
	int xcor = 0;
	int ycor = 0;
	for (int y = 0; y < maze.length; y ++){
	    for (int x = 0; x < maze[0].length; x ++){
		if (maze[y][x].equals('S')){
		    xcor = x;
		    ycor = y;
		}
	    }
	}
	return solver(maze, xcor, ycor);
    }

    public char[][] solver(char[][] maze, int x, int y){
	
    }

}
