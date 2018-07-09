package Controller;

import java.awt.event.KeyEvent;

public class Keys implements java.awt.event.KeyListener{
	
	private controller c;
	
	public Keys() {}
	
	public void addController(controller controller) {
		c = controller;
	}
	
	public void keyPressed(KeyEvent arg0) {	}

	public void keyReleased(KeyEvent arg0) { }

	public void keyTyped(KeyEvent arg0) {
		System.out.println("344");
		switch(arg0.getKeyCode()) {
		
		}
	}
	
}