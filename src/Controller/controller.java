package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import Graph.GRAPH_MATRIX;
import Model.Model;
import View.View;

public class controller implements java.awt.event.ActionListener{

	Model model;
	View view;
	int cols;
	int width;
	int height;

	public controller() {	
		System.out.println ("Controller()");
		cols = 10; //standart Wert, falls nichts eingegeben wird
		width = 800;
		height = 800;
	} 
		
	public void actionPerformed(java.awt.event.ActionEvent e){
		switch(e.getActionCommand()) {
		case "go":
			view.setWindowWidth(view.getWidthTF());
			view.setWindowsHeight(view.getHeightTF());
			MakeMaze(view.getColsTF());
			view.createDrawing();
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
} 
