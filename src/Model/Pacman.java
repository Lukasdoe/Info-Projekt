package Model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Pacman {
	private Cell currCell;
	private int x;
	private int y;
	private dir direction;
	private int size;
	
	private BufferedImage pacman;
	
	public enum dir{
		UP,
		LEFT,
		RIGHT,
		DOWN
	}
	
	public Pacman(int _size){
		currCell = new Cell(0,0,0);
		try{
			pacman = ImageIO.read(new File("images/pacman.png"));
		}
		catch(Exception e){}
		size = _size;
	}
	
	public int getX() {
		return currCell.getX();
	}
	
	public int getY() {
		return currCell.getY();
	}
	
	public BufferedImage getImage() {
		return pacman;
	}
	
	public void setCell(Cell curr) {
		currCell = curr;
	}
	
	public void setGraphics(int cellsize, JFrame view) {
		x = currCell.getX();
		y = currCell.getY() * cellsize + cellsize / 2;
//			
//		if (direction == dir.LEFT) {
//            drawPacmanLeft(g, view);
//        } else if (direction == dir.RIGHT) {
//            drawPacmanRight(g, view);
//        } else if (direction == dir.UP) {
//            drawPacmanUp(g, view);
//        } else {
//            drawPacmanDown(g, view);
//        }
	}
	
	public void changeDir(dir d) {
		direction = d;
	}

	private void drawPacmanDown(Graphics g, ImageObserver view) {
		g.drawImage(pacman, x, y, view);	
		
	}

	private void drawPacmanUp(Graphics g, ImageObserver view) {
		g.drawImage(pacman, x, y, view);	
	}

	private void drawPacmanRight(Graphics g, ImageObserver view) {
		g.drawImage(pacman, x, y, view);	
		
	}

	private void drawPacmanLeft(Graphics g, ImageObserver view) {
		g.drawImage(pacman, x, y, view);	
		
	}
	
	public int getSize() {
		return size;
	}

}
