package Model;
//Model of the Program

public class Model extends java.util.Observable {	

	private Maze maze;
	public Model(){
		
	} 
	
	public void createMaze() {
		maze = Maze_Generator.createMaze(5, 5, 5);
		System.out.println(maze.toString());
	}
	
	public Maze getMaze() {
		return maze;
	}
}
