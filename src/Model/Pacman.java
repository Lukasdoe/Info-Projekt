package Model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Pacman {
	private Cell currCell;
	private int x;
	private int y;
	private dir direction;
	
	private Image pacman;
	
	public enum dir{
		UP,
		LEFT,
		RIGHT,
		DOWN
	}
	
	public Pacman(){
		currCell = new Cell(0,0,0);
		pacman = new ImageIcon("images/pacman.png").getImage();
	}
	
	public int getX() {
		return currCell.getX();
	}
	
	public int getY() {
		return currCell.getY();
	}
	
	public void setCell(Cell curr) {
		currCell = curr;
	}
	
	public Graphics2D getGraphics(Graphics2D g, int cellsize, ImageObserver view) {
		x = currCell.getX() * cellsize + cellsize / 2;
		y = currCell.getY() * cellsize + cellsize / 2;
		
		if (direction == dir.LEFT) {
            drawPacmanLeft(g, view);
        } else if (direction == dir.RIGHT) {
            drawPacmanRight(g, view);
        } else if (direction == dir.UP) {
            drawPacmanUp(g, view);
        } else {
            drawPacmanDown(g, view);
        }
		return g;
	}
	
	public void changeDir(dir d) {
		direction = d;
	}

	private void drawPacmanDown(Graphics2D g, ImageObserver view) {
		g.drawImage(pacman, x, y, view);	
		
	}

	private void drawPacmanUp(Graphics2D g, ImageObserver view) {
		g.drawImage(pacman, x, y, view);	
	}

	private void drawPacmanRight(Graphics2D g, ImageObserver view) {
		g.drawImage(pacman, x, y, view);	
		
	}

	private void drawPacmanLeft(Graphics2D g, ImageObserver view) {
		g.drawImage(pacman, x, y, view);	
		
	}
}
