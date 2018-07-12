package View;

import Model.Maze;
import Model.Cell;
import Controller.Keys;
import Controller.controller;
import Model.Model;
import Model.Pacman;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.lang.Integer;
import java.util.Observable;
import javax.swing.*;
import View.CanvasX;

@SuppressWarnings("deprecation")
public class View implements java.util.Observer {

	private CanvasX canvas;
	private Model m;
	private controller c;
	private JFrame frame;
	private int width;
	private int height;
	private Pacman pac;

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
        
        cols = new JTextField("Integer: 2 entspricht 2x2", 1);  
        cols.setBounds(100,50,150,20);  
        cols.addActionListener(c);
        cols.setActionCommand("cols_input");
        cols.addFocusListener(new FocusListener() {
        	
            public void focusGained(FocusEvent e) {
            	cols.setText("");
            }

            public void focusLost(FocusEvent e) {
	            if(cols.getText().trim().equals("")) {
	            	cols.setText("Integer: 2 entspricht 2x2"); 
	            }
            }
        });

        JLabel spalte = new JLabel();
        spalte.setText("Geben Sie hier die Anzahl an Kästchen an");
        spalte.setBounds(100-70,50-25, 300, 20);
        
        input_width = new JTextField("Integer: z.B. 800", 1);  
        input_width.setBounds(100,100,150,20);
        input_width.addActionListener(c);
        input_width.setActionCommand("input_width");
        input_width.addFocusListener(new FocusListener() {
        	
            public void focusGained(FocusEvent e) {
            	input_width.setText("");
            }
            
            public void focusLost(FocusEvent e) {
	            if(input_width.getText().trim().equals("")) {
	            	input_width.setText("Integer: z.B. 800"); 
	            }
            }
        });
 
        JLabel weite = new JLabel();
        weite.setText("Geben Sie hier die Weite des Labyrinths an");
        weite.setBounds(100-70,100-25, 300, 20);
        
        input_height = new JTextField("Integer: z.B. 800", 1);  
        input_height.setBounds(100,150,150,20); 
        input_height.addActionListener(c);
        input_height.setActionCommand("input_height");
        input_height.addFocusListener(new FocusListener() {
        	
            public void focusGained(FocusEvent e) {
            	input_height.setText("");
            }

            public void focusLost(FocusEvent e) {
	            if(input_height.getText().trim().equals("")) {
	            	input_height.setText("Integer: z.B. 800"); 
	            }
            }
        });

        JLabel hoehe = new JLabel();
        hoehe.setText("Geben Sie hier die Hoehe des Labyrinths an");
        hoehe.setBounds(100-70,150-25, 300, 20);
        
        f.add(cols);
        f.add(input_width);
        f.add(input_height); 
        f.add(weite);
        f.add(hoehe);
        f.add(spalte);
        f.add(goButton);
        f.setSize(400, 400);  
        f.setLayout(null);  
        f.setVisible(true);  
	}
	
	public void update() {
		canvas.repaint();
		frame.repaint();
	}
	
	public void createDrawing(Keys keys) {
		frame = new JFrame("MazeRunner");
		frame.addKeyListener(keys); //key controls aktivieren
		m = new Model();
		frame.addWindowListener(new Controller.controller.CloseListener());	
		frame.setSize(width, height);
		frame.setLocation(100,100);
		frame.setVisible(true);
		canvas = new CanvasX();
		frame.add(canvas);
		canvas.repaint();
		frame.repaint();
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
		pac = new Pacman(m.getMaze().getSize()); //pacman initialisieren
		canvas.addPacman(pac);
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
	
	public void updatePacman(Pacman.dir dir, Cell newCell) {
		canvas.updatePacman(dir, newCell); //pacman updaten
	}
	
	public  Pacman getPac() {
		return pac;
	}
}
 