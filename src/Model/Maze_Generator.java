package Model;

import Liste.LISTE;

import java.util.ArrayList;
import java.util.Random;

public class Maze_Generator {
	
	static LISTE stack;
	
	Maze_Generator(){
		stack = new LISTE();
	}
	
	static Maze createMaze(int cols, int rows, int cSize) {
		Maze maze = new Maze(cols, rows, cSize);
		for(int x = 0; x < cols; x++){
	      for(int y = 0; y < rows; y++){
	        maze.setCell(x, y, new Cell(x, y, cSize));
	      }
		}
		
		boolean[][] visited = new boolean[cols][rows];
		
		Cell next;
		Cell current;
		
	    current = maze.getCell(0, 0);
	    
	    
	    visited[0][0] = true;

	    stack.HintenEinfuegen(current);
	    
	    while(stack.LaengeGeben() > 0){
	        next = pickNext(maze, current, cols, rows, visited);
	        if(next != null){
	          visited[next.getX()][next.getY()] = true;
	          stack.HintenEinfuegen(current);
	          removeWalls(current, next);
	          current = next;
	        }
	        else if (stack.LaengeGeben() > 0) {
	          current = (Cell) stack.EndeEntfernen();
	        }
	      }
	    
		return maze;
	}
	
	private static Cell pickNext(Maze maze, Cell now, int cols, int rows, boolean[][] visited) {
		ArrayList<Cell> neighbors = new ArrayList<Cell>(); //leider keine LISTE, da wir aus einer variablen Liste einen random Index nehmen müssen, und hierfür Arraylist besser ist, wegen dem get(index)
	    Random rand = new Random();
	    
	    if(getIndex(now.getX(), now.getY() - 1, cols, rows, visited)) neighbors.add(maze.getCell(now.getX(), now.getY() - 1));
	    if(getIndex(now.getX() + 1, now.getY(), cols, rows, visited)) neighbors.add(maze.getCell(now.getX() + 1, now.getY())); 
	    if(getIndex(now.getX(), now.getY() + 1, cols, rows, visited)) neighbors.add(maze.getCell(now.getX(), now.getY() + 1));
	    if(getIndex(now.getX() - 1, now.getY(), cols, rows, visited)) neighbors.add(maze.getCell(now.getX() - 1, now.getY()));
	    if(neighbors.size() > 0) return neighbors.get((int) Math.floor(rand.nextInt((neighbors.size() - 0) + 1)));
	    else return null;
	}
	
	private static boolean getIndex(int i, int j, int cols, int rows, boolean[][] visited) { //nur mal schauen, ob die Nachbarzelle überhaupt n gute Kandidat für die nächste Zelle ist!
		if (i < 0 || j < 0 || i > cols - 1 || j > rows - 1 || visited[i][j]) { //alles Ausschlusskriterien
		      return false;
		}
		return true;
	}
	
	private static void removeWalls(Cell cell1, Cell cell2) {
	   int x = cell1.getX() - cell2.getX(); //welche Wände entfernt werden können
	   int y = cell1.getY() - cell2.getY();
	   
	   if(x == 1){
	     cell1.removeWall(Cell.WALL.LEFT);
	     cell2.removeWall(Cell.WALL.RIGHT);
	   }
	   else if(x == -1){
	     cell1.removeWall(Cell.WALL.RIGHT);
	     cell2.removeWall(Cell.WALL.LEFT);
	   }
	   else if(y == 1){
	     cell1.removeWall(Cell.WALL.TOP);
	     cell2.removeWall(Cell.WALL.BOTTOM);
	   }
	   else if(y == -1){
	     cell1.removeWall(Cell.WALL.BOTTOM);
	     cell2.removeWall(Cell.WALL.TOP);
	   }	  
	}
}
