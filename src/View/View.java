package View;

import Model.Maze;
import Model.Cell;
import Controller.Keys;
import Controller.controller;
import Model.Model;

import java.awt.event.KeyListener;
import java.lang.Integer;
import java.util.Observable;
import javax.swing.*;
import View.CanvasX;

public class View implements java.util.Observer {

	private CanvasX canvas;
	private Model m;
	private controller c;
	private JFrame frame;
	private int width;
	private int height;
	
	private JTextField cols, input_width, input_height;
	
	public View() {
		
	}
	
	public void createChooser() {
		JButton goButton = new JButton("Labyrinth erstellen und anzeigen");
	    goButton.setActionCommand("go");
	    goButton.addActionListener(c);
	    goButton.setSize(50, 50);
	    goButton.setBounds(50, 300, 300, 20);
	    
        JFrame f= new JFrame();
        
        cols = new JTextField("10", 1);  
        cols.setBounds(100,50,150,20);  
        cols.addActionListener(c);
        cols.setActionCommand("cols_input");
        
        input_width = new JTextField("800", 1);  
        input_width.setBounds(100,100,150,20);
        input_width.addActionListener(c);
        input_width.setActionCommand("input_width");
        
        input_height = new JTextField("800", 1);  
        input_height.setBounds(100,150,150,20); 
        input_height.addActionListener(c);
        input_height.setActionCommand("input_height");
         
        f.add(cols);
        f.add(input_width);
        f.add(input_height); 
        f.add(goButton);
        f.setSize(400, 400);  
        f.setLayout(null);  
        f.setVisible(true);  
	}
	
	public void createDrawing() {
		frame = new JFrame("MazeRunner");
		frame.addKeyListener(new Keys());
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
		return width;
	}
	
	public int getWindowsHeight() {
		return height;
	}
	
	public int getWidthTF() {
		try {
			return Integer.parseInt(input_width.getText());
		}
		catch (Exception e) {
			return 800;
		}
	}
	
	public int getHeightTF() {
		try {
			return Integer.parseInt(input_height.getText());
		}
		catch (Exception e) {
			return 800;
		}
	}
	
	public int getColsTF() {
		try {
			return Integer.parseInt(cols.getText());
		}
		catch (Exception e) {
			return 10;
		}
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
 