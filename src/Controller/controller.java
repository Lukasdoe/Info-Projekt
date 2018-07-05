package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;

import Model.Maze;
import Model.Model;
import View.View;
import java.awt.Component;

public class controller implements java.awt.event.ActionListener {

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
			MakeMaze(cols);
			view.setWindowsHeight(height);
			view.setWindowWidth(width);
			view.createDrawing();
			break;
		case "width_input":
			width = Integer.parseInt(((JTextField) e.getSource()).getText());	
			break;
		case "height_input":
			height = Integer.parseInt(((JTextField) e.getSource()).getText());	
			break;
		case "cols_input":
			cols = Integer.parseInt(((JTextField) e.getSource()).getText());	
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
