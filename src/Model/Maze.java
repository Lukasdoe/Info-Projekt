package Model;

public class Maze {
	private Cell grid[][];
	private int numCols;
	private int numRows;
	private int cellSize;
		
	protected Maze(int cols, int rows, int cSize) {
		numCols = cols;
		numRows = rows;
		cellSize = cSize;
		grid = new Cell[cols][rows]; //leeres Maze generieren
	}
	
	protected void setCell(int x, int y, Cell value) { //Zelle editieren
		grid[x][y] = value;
	}
	
	public Cell getCell(int x, int y) { //Zelle ausgeben
		return grid[x][y];
	}
	
	public String toString() { //Maze ausgeben für debugging
		String ret = "";
		for(int i = 0; i < numCols; i++) {
			for(int j = 0; j < numRows; j++) {
				ret += "Cell X:" + i + ", Y:" + j + "; ";
			}
		}
		return ret;
	}
	
	public int getSize() { //gette Methoden für das Zeichnen
		return cellSize;
	}
	
	public int getCols() {
		return numCols;
	}
	
	public int getRows() {
		return numRows;
	}
}
