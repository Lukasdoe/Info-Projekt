package Controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Model.Model;

import View.View;

public class controller implements java.awt.event.ActionListener {

	Model model;
	View view;

	public controller() {	
		System.out.println ("Controller()");
	} 
	public void actionPerformed(java.awt.event.ActionEvent e){
		model.createMaze();
		System.out.println("Model");
		System.out.println("Controller: acting on Model");
	} 
	public void addModel(Model m){
		System.out.println("Controller: adding model");
		this.model = m;
	} 

	public void addView(View v){
		System.out.println("Controller: adding view");
		this.view = v;
	} 

	public void initModel(int x){
	} 
	
	public static class CloseListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			System.exit(0);
		} 
	} 
} 
