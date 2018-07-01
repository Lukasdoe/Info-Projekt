package Display;
import View.View;
import Controller.controller;
import Model.Model;
public class Display {
 static View v;
 static controller c;
 static Model m;

 	public static void main(String[] args) {
		m = new Model();
		v = new View();
		c = new controller();
		m.addObserver(v);
		v.addController(c);	
		c.addModel(m);
		c.addView(v);
	}
}
