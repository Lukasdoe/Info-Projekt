package View;

import Model.Maze;
import Model.Cell;
import Controller.controller;
import Model.Model;

import java.lang.Integer;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import View.CanvasX;
import javafx.scene.control.Cell;
public class View implements java.util.Observer {

	private JTextField myTextField;
	private JButton button; 
	private static CanvasX canvas;
	private Model m;
	
	public View() {
		
		System.out.println("View()");	
		
		JFrame frame 		= new JFrame("MazeRunner");
		Model m = new Model();
		m.createMaze();
		frame.addWindowListener(new Controller.controller.CloseListener());	
		frame.setSize(600,600);
		frame.setLocation(100,100);
		frame.setVisible(true);
		canvas = new CanvasX();
		
		frame.add(canvas);
		
				
		
	        
		
	       
	
		frame.pack(); 
	} 
	public static void MazeDraw(Model m){
		Maze maze = m.getMaze();
		for(int i = 0; i<m.getMaze().getCols(); i++) {
			for(int j = 0; j<m.getMaze().getRows(); j++) {
				Cell c = maze.getCell(i, j);
			if(c.getWall(Cell.WALL.TOP)) {
				canvas.AddLine(i,j , i+s, j);
			}
			System.out.println(i + "+" + j);	
			
				
			}
		}
		
	
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
 