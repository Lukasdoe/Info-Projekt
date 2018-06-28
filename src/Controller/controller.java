package Controller;

import Model.Model;
import View.View;
<<<<<<< HEAD
public class controller implements java.awt.event.ActionListener {
=======

class Controller implements java.awt.event.ActionListener {
>>>>>>> 1d88597171a24272eb40cf5eb6a7bf571023c997

	
	Model model;
	View view;

	controller() {	
		System.out.println ("Controller()");
	} 
	public void actionPerformed(java.awt.event.ActionEvent e){
		model.createMaze();
		System.out.println("Model");
		
<<<<<<< HEAD
=======
		System.out.println("Controller: acting on Model");
		//model.incrementValue();
>>>>>>> 1d88597171a24272eb40cf5eb6a7bf571023c997
	} 
	public void addModel(Model m){
		System.out.println("Controller: adding model");
		this.model = m;
	} 

	public void addView(View v){
		System.out.println("Controller: adding view");
		this.view = v;
	} 

<<<<<<< HEAD
=======
	public void initModel(int x){
		//model.setValue(x);
	} 

>>>>>>> 1d88597171a24272eb40cf5eb6a7bf571023c997
} 
