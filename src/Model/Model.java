package Model;
//Model of the Program

public class Model extends java.util.Observable {	

	private Maze maze;
	public Model(){
		maze = new Maze(0, 0, 0); //leeres Platzhalter Maze für getMaze(), damit im Notfall keine NullPointer entstehen
	} 
	
	public void createMaze() {
		maze = Maze_Generator.createMaze(5, 5, 5);
	}
	
	public Maze getMaze() {
		return maze;
	}
}
