package Display;
import View.View;
import Controller.Keys;
import Controller.controller;
import Model.Model;
public class Display {
 static View v;
 static controller c;
 static Model m;
 static Keys k;

 	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
 		//standart Verteilung der enzelnen Komponenten
		m = new Model();
		v = new View();
		c = new controller();
		k = new Keys();
		v.addController(c);
		c.addModel(m);
		c.addView(v);
		m.addObserver(v);
		k.addController(c);
		
		//startdialog -> ab hier alles über Actions zwischen View und Controller und Model
		v.createChooser();
	}
}
