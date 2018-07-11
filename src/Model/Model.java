package Model;

import Graph.GRAPH_MATRIX;

//Model of the Program

public class Model extends java.util.Observable {	

	private Maze maze;
	private GRAPH_MATRIX gm;
	
	public Model(){
		maze = new Maze(0, 0, 0); //leeres Platzhalter Maze für getMaze(), damit im Notfall keine NullPointer entstehen
	} 
	
	public void createMaze(int cols, int rows, int cSize) {
		Maze_Generator mG = new Maze_Generator();
		gm = new GRAPH_MATRIX(cols * rows);
		for(int i = 0; i < cols; i++) {
			for(int j = 0; j < rows; j++) {
				gm.KnotenEinfuegen(i+";"+j); //Matrix mit Knoten für jede Zelle füllen
			}
		}
		maze = mG.createMaze(cols, rows, cSize, gm);
	}
	
	public Maze getMaze() {
		return maze;
	}
	
	public void setGraph(GRAPH_MATRIX g) {
		gm = g;
	}
	
	public GRAPH_MATRIX getGraph() {
		return gm;
	}
}
