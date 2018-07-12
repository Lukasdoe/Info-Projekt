package Controller;

import java.awt.event.KeyEvent;

public class Keys implements java.awt.event.KeyListener{
	
	private controller c;
	
	public Keys(controller control) {
		c = control;
	}
	
	public void addController(controller controller) {
		c = controller;
	}
	
	public void keyPressed(KeyEvent arg0) {	
		
	}

	public void keyReleased(KeyEvent arg0) { 
		setEvent(arg0.getKeyChar());
	}

	public void keyTyped(KeyEvent arg0) {

	}
	
	public void setEvent(char e) {
		switch(e) {
		case 'a':
			c.MoveLeft();
			break;
		case 'w':
			c.MoveUp();
			break;
		case 'd':
			c.MoveRight();
			break;
		case 's':
			c.MoveDown();
			break;
		}
	}
}