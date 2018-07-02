package Model;
//Model of the Program

public class Model extends java.util.Observable {	

	private Maze maze;
	public Model(){
		maze = new Maze(0, 0, 0); //leeres Platzhalter Maze für getMaze(), damit im Notfall keine NullPointer entstehen
	} 
	
	public void createMaze(int cols, int rows, int cSize) {
		Maze_Generator mG = new Maze_Generator();
		maze = mG.createMaze(cols, rows, cSize);
	}
	
	public Maze getMaze() {
		return maze;
	}
}
