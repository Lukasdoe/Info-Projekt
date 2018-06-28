package View;     //Model Nutzen
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import java.util.Observable;
import Controller.controller;
import javax.swing.JFrame;
import Model.Maze_Generator;


 

 public	class View implements java.util.Observer{
		
		private TextField myTextField;
		private Button button; 
	    private Line2D D; 
	    
	   
	    
 
	    
		public View() {
			
			System.out.println("View()");	
			paint(1,2,1,2);
			Line2D D = new Line2D.Double(3,3,3,3);
			Frame frame 		= new Frame("simple MVC");
			frame.add("North", new Label("Maze Runner"));

			myTextField 		= new TextField();
			frame.add("Center", myTextField);

			
			Panel panel 		= new Panel();
			button	 		= new Button("PressMe");
			panel.add(button);
			frame.add("South", panel);		

			frame.addWindowListener(new CloseListener());	
			frame.setSize(400,400);
			frame.setLocation(300,300);
			frame.setVisible(true);

		} 
		 
		public void paint( int x, int y, int x1, int y2) {
		    
		    Graphics2D g2 = (Graphics2D)g;
		    Line2D line = new Line2D.Double(30,30,80,80);
		    g2.setStroke(new BasicStroke(4));
		    g2.draw(line);
		  }
		     
		 

	    	public void update(Observable obs, Object obj) {

			myTextField.setText("" + ((Integer)obj).intValue());	//obj is an Object, need to cast to an Integer

	    	} 
		public void setValue(int v){
	    		myTextField.setText("" + v);
		} 
	    	
		public void addController(controller controller){
			System.out.println("View      : adding controller");
			button.addActionListener(controller);	//need controller before adding it as a listener 
		} 
		
		public static class CloseListener extends WindowAdapter {
			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);
				System.exit(0);
			}
			} 
		} 

	}
