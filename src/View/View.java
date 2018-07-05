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
public class View implements java.util.Observer {

	private CanvasX canvas;
	private Model m;
	private controller c;
	private JFrame frame;
	private int width;
	private int height;
	
	public View() {
		
	}
	
	public void createChooser() {
		JButton goButton = new JButton("Labyrinth erstellen und anzeigen");
	    goButton.setActionCommand("go");
	    goButton.addActionListener(c);
	    goButton.setSize(50, 50);
	    goButton.setLocation(0, 350);
	    
        JFrame f= new JFrame();
        
        JTextField cols = new JTextField("10", 1);  
        cols.setBounds(50,50,150,20);  
        
        JTextField input_width = new JTextField("800", 1);  
        input_width.setBounds(50,100,150,20);
        
        JTextField input_height = new JTextField("800", 1);  
        input_height.setBounds(50,150,150,20); 
         
        f.add(cols);
        f.add(input_width);
        f.add(input_height); 
        f.setSize(300,300);  
        f.setLayout(null);  
        f.setVisible(true);  
	}
	
	public void createDrawing() {
		frame = new JFrame("MazeRunner");
		m = new Model();
		frame.addWindowListener(new Controller.controller.CloseListener());	
		frame.setSize(width, height);
		frame.setLocation(100,100);
		frame.setVisible(true);
		canvas = new CanvasX();
		frame.add(canvas);
	}
	
	public void MazeDraw(Model m){
		Maze maze = m.getMaze();
		int x = 0;
		int y = 0;
		int size = 1;
		for(int i = 0; i<m.getMaze().getCols(); i++) {
			for(int j = 0; j<m.getMaze().getRows(); j++) {
				Cell c = maze.getCell(i, j);
				size = c.getSize();
				x = c.getX() * size;
				y = c.getY() * size;
				
				if(c.getWall(Cell.WALL.TOP)) {
					canvas.AddLine(x, y, x + size, y);
				}
				if(c.getWall(Cell.WALL.RIGHT)) {
					canvas.AddLine(x + size, y, x + size, y + size);
				}
				if(c.getWall(Cell.WALL.BOTTOM)) {
					canvas.AddLine(x, y + size, x + size, y + size);
				}
				if(c.getWall(Cell.WALL.LEFT)) {
					canvas.AddLine(x, y, x, y + size);
				}
			}
		}
	} 
	
	public void addController(controller controller){
		System.out.println("View      : adding controller");
		c = controller;
	}
	
	public int getWindowWidth() {
		return frame.getWidth();
	}
	
	public int getWindowsHeight() {
		return frame.getHeight();
	}
	
	public void setWindowWidth(int _width) {
		width = _width;
	}
	
	public void setWindowsHeight(int _height) {
		height = _height;
	}
 
	public void update(Observable arg0, Object arg1) {
		
	}
}
 