package Model;
import Liste.LISTE;

public class Maze {
	Cell grid[][];
	int numCols;
	int numRows;
	int cellSize;
		
	public Maze(int cols, int rows, int cSize) {
		numCols = cols;
		numRows = rows;
		cellSize = cSize;
		grid = new Cell[cols][rows];
	}
	
	public void setCell(int x, int y, Cell value) {
		grid[x][y] = value;
	}
	
	public Cell getCell(int x, int y) {
		return grid[x][y];
	}
	
	public String toString() {
		String ret = "";
		for(int i = 0; i < numCols; i++) {
			for(int j = 0; j < numRows; j++) {
				ret += "Cell " + i + ", " + j;
			}
		}
		return ret;
	}
	
	public int getSize() {
		return cellSize;
	}
}
