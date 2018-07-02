package Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Model.Maze;
import Model.Model;

import View.View;

public class controller implements java.awt.event.ActionListener {

	Model model;
	View view;

	public controller() {	
		System.out.println ("Controller()");
		model = new Model();
		model.createMaze();
	} 
	/*public void actionPerformed(java.awt.event.ActionEvent e){
		switch(((Component) e.getSource()).getName()) {
		case "button1":
			model.createMaze();
			System.out.println("Model");
			System.out.println("Controller: acting on Model");
			break;
		}
	} */
	
	public void addModel(Model m){
		System.out.println("Controller: adding model");
		this.model = m;
	} 

	public void addView(View v){
		System.out.println("Controller: adding view");
		this.view = v;
	} 
	public void MazeDrawApply(Model m){
          m.getMaze();
		View.MazeDraw(m);
		
		
	}
	public static class CloseListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			System.exit(0);
		} 
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	} 
} 
