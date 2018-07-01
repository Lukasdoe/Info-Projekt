package View;

import Model.Model;
import Controller.controller;
import java.awt.Button;
import java.awt.Panel;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.lang.Integer;
import java.util.Observable;

public class View implements java.util.Observer {

	private TextField myTextField;
	private Button button; 
	
	public View() {
		
		System.out.println("View()");	
		
		Frame frame 		= new Frame("simple MVC");
		frame.add("North", new Label("counter"));

		myTextField 		= new TextField();
		frame.add("Center", myTextField);

		Panel panel 		= new Panel();
		button	 		= new Button("PressMe");
		panel.add(button);
		frame.add("South", panel);		

		frame.addWindowListener(new Controller.controller.CloseListener());	
		frame.setSize(200,100);
		frame.setLocation(100,100);
		frame.setVisible(true);

	} 

	public void update(Observable obs, Object obj) {
		myTextField.setText("" + ((Integer)obj).intValue());	
	} 

	public void setValue(int v){
    	myTextField.setText("" + v);
	} 
    	
	public void addController(controller controller){
		System.out.println("View      : adding controller");
		button.addActionListener(controller);
	}

}
