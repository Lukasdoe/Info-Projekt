package Controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import Graph.GRAPH_MATRIX;
import Model.Maze;
import Model.Model;
import Model.Pacman;
import View.View;

public class controller implements java.awt.event.ActionListener {

	Model model;
	View view;
	int cols;
	int width;
	int height;
	Keys keys;

	public controller() {	
		System.out.println ("Controller()");
		cols = 10; //standart Wert, falls nichts eingegeben wird
		width = 800;
		height = 800;
		keys = new Keys(this);
	} 
		
	public void actionPerformed(java.awt.event.ActionEvent e){
		switch(e.getActionCommand()) {
		case "go": //maze und view klasse ein Labyrinth erzeugen lassen
			view.setWindowWidth(view.getWidthTF()); 
			view.setWindowsHeight(view.getHeightTF());
			MakeMaze(view.getColsTF());
			view.createDrawing(keys);
			view.MazeDraw(model);
			break;
		}
	} 
	
	public void addModel(Model m){
		System.out.println("Controller: adding model");
		this.model = m;
	} 

	public void addView(View v){
		System.out.println("Controller: adding view");
		this.view = v;
	} 
	
	public void MakeMaze(int cols) {
		model.setGraph(new GRAPH_MATRIX(cols * cols)); //GRAPH_MATRIX mit Maximum an Knoten entsprechend der Zellanzahl
		model.createMaze(cols, Math.round((view.getWindowsHeight() - 50) / ((view.getWindowWidth() - 50) / cols)), Math.round((view.getWindowWidth() - 50) / cols));
	}
	
	public static class CloseListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		} 
	}
	
	public static class CloseListenerSetup extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		} 
	}
	
	//alle Move Methoden suchen nach einem m�glichen Knoten in der Richtung, in die sich bewegt werden soll
	
	protected void MoveUp() {
		Pacman pac = view.getPac(); //ein paar n�tige Objekte einholen
		GRAPH_MATRIX graph = model.getGraph();
		Maze maze = model.getMaze();
		
		for(int i = pac.getY() - 1; i >= 0; i--) { //alle Knoten durchgehen, die nach Oben vom Pacman aus gehen k�nnten und schauen, ob da m�gliche kanten sind
		  //erkl�rung der abfrage: Knoten im Graphen haben immer als Namen: X-Koordinate ; Y-Koordinate
			if(graph.IstVerbunden(pac.getX() + ";" + pac.getY(), pac.getX() + ";" + i)) { //kante zwischen jetziger Position gefunden, Pacman dorthin setzen und view updaten
				pac.changeDir(Pacman.dir.UP);
				pac.setCell(maze.getCell(pac.getX(), i));
				view.update();
				return;
			}
		}
	}
	
	protected void MoveRight() {
		Pacman pac = view.getPac();
		GRAPH_MATRIX graph = model.getGraph();
		Maze maze = model.getMaze();
		
		for(int i = pac.getX() + 1; i < maze.getCols(); i++) {
			if(graph.IstVerbunden(pac.getX() + ";" + pac.getY(), i + ";" + pac.getY())) {
				pac.changeDir(Pacman.dir.RIGHT);
				pac.setCell(maze.getCell(i, pac.getY()));
				view.update();
				return;
			}
		}
	}
	
	protected void MoveDown() {
		Pacman pac = view.getPac();
		GRAPH_MATRIX graph = model.getGraph();
		Maze maze = model.getMaze();
		
		for(int i = pac.getY() + 1; i < maze.getRows(); i++) {
			if(graph.IstVerbunden(pac.getX() + ";" + pac.getY(), pac.getX() + ";" + i)) {
				pac.changeDir(Pacman.dir.DOWN);
				pac.setCell(maze.getCell(pac.getX(), i));
				view.update();
				return;
			}
		}
	}

	protected void MoveLeft() {
		Pacman pac = view.getPac();
		GRAPH_MATRIX graph = model.getGraph();
		Maze maze = model.getMaze();

		for(int i = pac.getX() - 1; i >= 0; i--) {
			if(graph.IstVerbunden(pac.getX() + ";" + pac.getY(), i + ";" + pac.getY())) {
				pac.changeDir(Pacman.dir.LEFT);
				pac.setCell(maze.getCell(i, pac.getY()));
				view.update();
				return;
			}
		}
	}
} 
