package uppgifter;

import java.util.*;

public class LifeBoard {
	private Integer index(int row, int column) {
		return row * m_columns + column;
	}

	/**
	 * Skapar en spelplan med rows rader och cols kolonner. Spelplanen är från
	 * början tom, dvs alla rutorna är tomma och generationsnumret är 1.
	 */
	public LifeBoard(int rows, int cols) {
		m_rows = rows;
		m_columns = cols;
		m_limit = index(m_rows - 1, m_columns - 1);

		m_generation = 1;
		m_cells = new HashMap<Integer, Boolean>();
	}

	/**
	 * Ger true om det finns en individ i rutan med index row, col, false annars. Om
	 * index row, col är utanför spelplanen returneras false
	 */
	public boolean get(int row, int col) {
		return m_cells.getOrDefault(index(row, col), false);
	}

	/** Lagrar värdet val i rutan med index row, col */
	public void put(int row, int col, boolean val) {
		final boolean outOfBounds = row < 0 || col < 0 || index(row, col) >= m_limit;
		if (outOfBounds) {
			return;
		}

		m_cells.put(index(row, col), val);
	}

	/** Tar reda på antalet rader */
	public int getRows() {
		return m_rows;
	}

	/** Tar reda på antalet kolonner */
	public int getCols() {
		return m_columns;
	}

	/** Tar reda på aktuellt generationsnummer */
	public int getGeneration() {
		return m_generation;
	}

	/** Ökar generationsnumret med ett */
	public void increaseGeneration() {
		m_generation++;
	}

	private final int m_rows;
	private final int m_columns;
	private final Integer m_limit;

	private int m_generation;
	private Map<Integer, Boolean> m_cells;
}
