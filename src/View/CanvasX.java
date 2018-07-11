package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;

import Model.Pacman;

public class CanvasX extends JComponent{

	private static final long serialVersionUID = 1L;
	private int i;
	private int j;
	private ArrayList<Shape> shapes;
	private Pacman pac;
	
	public CanvasX(){	
		shapes = new ArrayList<Shape> ();
	}
            
	void AddLine(int i, int j, int k, int l){
		shapes.add(new Line2D.Double(new Point(i,j),new Point(k,l)));
	}
	
	void reDraw(Graphics g) {
		repaint();
	}
	
	void addPacman(Pacman pac_) {
		pac = pac_;
	}

	protected void paintComponent ( Graphics g ){
		Graphics2D g2d = ( Graphics2D ) g;
		g2d.setPaint ( Color.BLACK );
		for (Shape shape : shapes){
			g2d.draw(shape);
		}
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(pac.getImage(), pac.getX(), pac.getY(), pac.getSize(), pac.getSize(), this);
	}
} 