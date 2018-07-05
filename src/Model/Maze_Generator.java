package Model;

import Liste.LISTE;
import Graph.*;

import java.util.ArrayList;
import java.util.Random;

class Maze_Generator {
	
	private int lastX;
	private int lastY;
	private Cell lastCell;
		
	protected Maze_Generator(){
		lastX = 0;
		lastY = 0;
		lastCell = new Cell(0, 0, 1);
	}
	
	protected Maze createMaze(int cols, int rows, int cSize, GRAPH_MATRIX gm) {
		LISTE stack;

		Maze maze = new Maze(cols, rows, cSize); //neues, leeres Maze
		stack = new LISTE(); //stapel für Zellen, die bereits bearbeitet wurden, aber vl. noch Abzweigungen haben

		for(int x = 0; x < cols; x++){
	      for(int y = 0; y < rows; y++){
	        maze.setCell(x, y, new Cell(x, y, cSize)); //leeres Maze mit Zellen auffüllen
	      }
		}
		
		boolean[][] visited = new boolean[cols][rows]; //array für Zellen, welche bereits abgefrüstückt sind
		
		Cell next;	//kandidat für nächste Zelle
		Cell current = maze.getCell(0, 0); //erste Zelle zur bearbeitung ist immer link oben (0,0)
	    
	    visited[0][0] = true; //erste Zelle ist besucht

	    stack.HintenEinfuegen(current); //Zelle dem stack hinzufügen und den Index danach um 1 erhöhen
	    
	    while(stack.LaengeGeben() > 0){ //solange man nicht wieder am Anfang ist
	        next = pickNext(maze, current, cols, rows, visited); //neuer, nächster Kandidat mit pickNext Methode
	        if(next != null){	//wenn es für die jetzige current Zelle einen validen, nicht besuchten Kandidaten gibt
	          visited[next.getX()][next.getY()] = true; //diesen Besuchen
	          stack.HintenEinfuegen(current); //ihn dem stack hinzufügen
	          removeWalls(current, next, gm); //die Wänge zwischen current und next entfernen => valider Weg
	          current = next; //nächsten schritt vorbereiten
	        }
	        else if (stack.LaengeGeben() > 0) { //wenn es keinen validen nachbarn für current gibt, und current nicht bei 0,0 ist
	          current = (Cell) stack.EndeEntfernen(); //letzten Punkt nehmen, der evtl. funktionieren könnte und nochmal probieren
	        }
	    }
	    gm.Ausgeben();
		return maze;
	}
	
	private static Cell pickNext(Maze maze, Cell now, int cols, int rows, boolean[][] visited) {
		ArrayList<Cell> neighbors = new ArrayList<Cell>(); //leider keine LISTE, da wir aus einer variablen Liste einen random Index nehmen müssen, und hierfür Arraylist besser ist, wegen dem get(index)
	    Random rand = new Random();
	    
	    if(getIndex(now.getX(), now.getY() - 1, cols, rows, visited)) neighbors.add(maze.getCell(now.getX(), now.getY() - 1)); //jeweils die vier möglichen nachbarzellen von current, prüfung ob diese genommen werden können
	    if(getIndex(now.getX() + 1, now.getY(), cols, rows, visited)) neighbors.add(maze.getCell(now.getX() + 1, now.getY())); 
	    if(getIndex(now.getX(), now.getY() + 1, cols, rows, visited)) neighbors.add(maze.getCell(now.getX(), now.getY() + 1));
	    if(getIndex(now.getX() - 1, now.getY(), cols, rows, visited)) neighbors.add(maze.getCell(now.getX() - 1, now.getY()));
	    if(neighbors.size() > 0) return neighbors.get((int) Math.floor(rand.nextInt(neighbors.size()))); //random möglichkeit aus Möglichen Nachbarzellen
	    else return null;
	}
	
	private static boolean getIndex(int i, int j, int cols, int rows, boolean[][] visited) { //nur mal schauen, ob die Nachbarzelle überhaupt n gute Kandidat für die nächste Zelle ist!
		if (i < 0 || j < 0 || i > cols - 1 || j > rows - 1 || visited[i][j]) { //alles Ausschlusskriterien
		      return false;
		}
		return true;
	}
	
	private void removeWalls(Cell cell1, Cell cell2, GRAPH_MATRIX gm) {
	   int x = cell1.getX() - cell2.getX(); //welche Wände entfernt werden können => zeigt die Position der Zellen zueinander, also z.B. Zelle 1 ist bei X= 5 und Zelle2 bei X = 4 , also ist x = -1 und man muss die link wand bei 1 und rechte wand bei 2 entfernen
	   int y = cell1.getY() - cell2.getY();
	   
	   if(x != lastX && y != lastY) {
		   gm.KnotenEinfuegen(cell1.getX() + ";" + cell1.getY());
		   gm.KanteEinfuegen(cell1.getX() + ";" + cell1.getY(), lastCell.getX() + ";" + lastCell.getY(), 1);
		   lastCell = cell1;
	   }
	   
	   lastX = x;
	   lastY = y;
	   
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
