package Model;
import Liste.DATENELEMENT;

public class Cell implements DATENELEMENT{
	int size; //Zellengrößen, bei allen gleich
	int i; //Spalte im Labyrinth
	int j; //Zeile
	int number_in_stack; //nur gebraucht für Listensortierung des Stacks
	
	boolean[] walls; //fängt im Uhrzeigersinn oben (TOP) zu zählen an und gibt an, ob sich hier ein Wand befindet (true)
	
	public static enum WALL {
	    TOP,
	    RIGHT,
	    LEFT,
	    BOTTOM
	}
	
	public Cell(int _i, int _j, int s) {
		i = _i;
		j = _j;
		size = s;
		number_in_stack = 0;
	}
	
	public Cell(int _i, int _j, int s, int num) {
		i = _i;
		j = _j;
		size = s;
		number_in_stack = num;
	}
	
	public int getX() {
		return i * size;
	}
	
	public int getY() {
		return j * size;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean getWall(WALL wall) {
		switch(wall) {
		case TOP:
			return walls[0];
		case RIGHT:
			return walls[1];
		case BOTTOM:
			return walls[2];
		case LEFT:
			return walls[3];
		default:
			return true;
		}
	}
	
	public void removeWall(WALL wall) {
		switch(wall) {
		case TOP:
			walls[0] = false;
			break;
		case RIGHT:
			walls[1] = false;
			break;
		case BOTTOM:
			walls[2] = false;
			break;
		case LEFT:
			walls[3] = false;
			break;
		}
	}

	public void InformationAusgeben() {
		System.out.println("Zelle: " + number_in_stack + " Spalte: " + i + " Zeile: " + j + " Größe: " + size);
	}

	public boolean SchluesselIstGleich(int i) {
		return (number_in_stack == i);
	}

	public boolean IstGleich(DATENELEMENT d) {
		return (number_in_stack == d.getNumber());
	}

	public boolean IstGroesser(DATENELEMENT d) {
		return (number_in_stack > d.getNumber());
	}

	public int getNumber() {
		return number_in_stack;
	}
}
