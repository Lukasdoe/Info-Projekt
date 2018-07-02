package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.JComponent;

public class CanvasX extends JComponent{
	int i;
	int j;
	public CanvasX(){}
	private ArrayList<Shape> shapes = new ArrayList<Shape> ();
            
	void AddLine(int i, int j, int k, int l){
		shapes.add(new Line2D.Double(new Point(i,j),new Point(k,l)));
	}
	
	void reDraw() {
		repaint();
	}

	protected void paintComponent ( Graphics g ){
		Graphics2D g2d = ( Graphics2D ) g;
		g2d.setPaint ( Color.BLACK );
		for (Shape shape : shapes){
			g2d.draw(shape);
		}
	}
} 