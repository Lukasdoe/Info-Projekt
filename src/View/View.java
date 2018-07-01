package View;

import Controller.controller;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Canvas; 
import java.awt.Graphics;
import java.awt.geom.Line2D;


public class View implements java.util.Observer {

	private JTextField myTextField;
	private JButton button; 
	
	public View() {
		
		System.out.println("View()");	
		
		JFrame frame 		= new JFrame("MazeRunner");

		frame.addWindowListener(new Controller.controller.CloseListener());	
		frame.setSize(600,600);
		frame.setLocation(100,100);
		frame.setVisible(true);

		frame.add(new JComponent ()
	    {
	        private ArrayList<Shape> shapes = new ArrayList<Shape> ();
	        private Shape currentShape = null;
            
	        {
	        MouseAdapter mouseAdapter = new MouseAdapter ()
	        {
	            public void mousePressed ( MouseEvent e )
	            {
	            currentShape = new Line2D.Double ( e.getPoint (), e.getPoint () );
	            shapes.add ( currentShape );
	            repaint ();
	            }

	            public void mouseDragged ( MouseEvent e )
	            {
	            Line2D shape = ( Line2D ) currentShape;
	            shape.setLine ( shape.getP1 (), e.getPoint () );
	            repaint ();
	            }

	            public void mouseReleased ( MouseEvent e )
	            {
	            currentShape = null;
	            repaint ();
	            }
	        };
	        addMouseListener ( mouseAdapter );
	        addMouseMotionListener ( mouseAdapter );
	        }
		
	        protected void paintComponent ( Graphics g )
	        {
		        Graphics2D g2d = ( Graphics2D ) g;
		        g2d.setPaint ( Color.BLACK );
		        for ( Shape shape : shapes )
		        {
		            g2d.draw ( shape );
		        }
	        }
	    } ); 
		frame.pack(); 
	} 

	public void update(Observable obs, Object obj) {
		myTextField.setText("" + ((Integer)obj).intValue());	
	} 

	public void setValue(int v){
    	myTextField.setText("" + v);
	} 
	
	public void paint(Graphics g) { 
		g.fillOval(100, 100, 200, 200); 
	}

    	
	public void addController(controller controller){
		System.out.println("View      : adding controller");
		//button.addActionListener(controller);
	}
}