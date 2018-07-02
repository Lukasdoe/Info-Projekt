package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Model.Maze;
import Model.Model;
import View.View;
import java.awt.Component;

public class controller implements java.awt.event.ActionListener {

	Model model;
	View view;

	public controller() {	
		System.out.println ("Controller()");
	} 
		
	public void actionPerformed(java.awt.event.ActionEvent e){
		switch(((Component) e.getSource()).getName()) {

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
		model.createMaze(cols, (view.getWindowsHeight() - 50) / ((view.getWindowWidth() - 50) / cols), ((view.getWindowWidth() - 50) / cols));
	}
	public void MazeDrawApply(){
		view.MazeDraw(model);
	}
	public static class CloseListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		} 
	}
} 
