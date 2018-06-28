package Controller;

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
		//model.incrementValue();

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
		//model.setValue(x);
	} 


} 
