package uppgifter;

import java.util.*;

public class LifeBoard {
	/**
	 * Skapar en spelplan med rows rader och cols kolonner. Spelplanen är från
	 * början tom, dvs alla rutorna är tomma och generationsnumret är 1.
	 */
	public LifeBoard(int rows, int collumns) {
    m_board = new boolean[rows][collumns];
		m_generation = 1;
	}

	/**
	 * Ger true om det finns en individ i rutan med index row, col, false annars. Om
	 * index row, col är utanför spelplanen returneras false
	 */
	public boolean get(int row, int col) {
    return 
        row >= 0 && row < getRows() ?
            (col >= 0 && col < getCols() ?
                m_board[row][col] :
                false) :
            false;
	}

	/** Lagrar värdet val i rutan med index row, col */
	public void put(int row, int col, boolean val) {
    m_board[row][col] = val;
	}

	/** Tar reda på antalet rader */
	public int getRows() {
		return m_board.length;
	}

	/** Tar reda på antalet kolonner */
	public int getCols() {
		return getRows() > 0 ? m_board[0].length : 0;
	}

	/** Tar reda på aktuellt generationsnummer */
	public int getGeneration() {
		return m_generation;
	}

	/** Ökar generationsnumret med ett */
	public void increaseGeneration() {
		m_generation++;
	}

  private boolean[][] m_board; //row major
	private int m_generation;
}
