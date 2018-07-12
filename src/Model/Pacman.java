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
	
	private BufferedImage pacmanUP;
	private BufferedImage pacmanDOWN;
	private BufferedImage pacmanLEFT;
	private BufferedImage pacmanRIGHT;
	
	public enum dir{ //verschieden Richtungen
		UP,
		LEFT,
		RIGHT,
		DOWN
	}
	
	public Pacman(int _size){
		currCell = new Cell(0,0,0);
		try{ //verschiedene Bilder laden
			pacmanUP = ImageIO.read(new File("images/pacmanUP.png"));
			pacmanDOWN = ImageIO.read(new File("images/pacmanDOWN.png"));
			pacmanLEFT = ImageIO.read(new File("images/pacmanLEFT.png"));
			pacmanRIGHT = ImageIO.read(new File("images/pacmanRIGHT.png"));
		}
		catch(Exception e){}
		size = _size;
		direction = dir.DOWN;
	}
	
	public int getX() {
		return currCell.getX();
	}
	
	public int getY() {
		return currCell.getY();
	}
	
	public BufferedImage getImage() { //Bilder zum darstellen geben
	    switch(direction){
	      case UP:
	        return pacmanUP;
	      case DOWN:
	        return pacmanDOWN;
	      case LEFT:
	        return pacmanLEFT;
	      case RIGHT:
	        return pacmanRIGHT;
	    }
		return null;
	}
	
	public void setCell(Cell curr) {
		currCell = curr;
	}

	
	public void changeDir(dir d) {
		direction = d;
	}

	
	public int getSize() {
		return size;
	}

}
