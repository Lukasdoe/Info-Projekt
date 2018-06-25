//Model of the Program

public class Model extends java.util.Observable {	

	Maze maze;
	public Model(){
		
	} 
	
	public void createMaze() {
		maze = Maze_Generator.createMaze();
	}
	
	public Maze getMaze() {
		return maze;
	}
	
	//Cell.WALL.TOP;
	
}
