package uppgifter;

public class Life {
  public Life(LifeBoard board) {
    m_board = board;
  }

  private static void copyState(LifeBoard from, LifeBoard to) {
    for (int row = 0; row < from.getRows(); row++) {
      for (int col = 0; col < from.getCols(); col++) {
        to.put(row, col, from.get(row, col));
      }
    }
  }

  public void newGeneration() {
    LifeBoard tempBoard = new LifeBoard(m_board.getRows(), m_board.getCols());

    for (int row = 0; row < m_board.getRows(); row++) {
      for (int col = 0; col < m_board.getCols(); col++) {
        switch (getNeighbours(m_board, row, col)) {
          case 0:
          case 1:
          case 4: {
            tempBoard.put(row, col, false);
          }
            break;

          case 2: {
            tempBoard.put(row, col, m_board.get(row, col));
          }
            break;

          case 3: {
            tempBoard.put(row, col, true);
          }
            break;
        }
      }
    }

    copyState(tempBoard, m_board);
    m_board.increaseGeneration();
  }

  public void flip(int row, int col) {
    m_board.put(row, col, !m_board.get(row, col));
  }

  private int getNeighbours(LifeBoard board, int row, int col) {
    int nrNeighbours = 0;

    for (int i = -1; i <= 1; i++) {
      for (int j = -1; j <= 1; j++) {
        if (i == 0 && j == 0)
          continue;

        if (board.get(row + i, col + j)) {

          nrNeighbours++;
        }
      }
    }

    return nrNeighbours;
  }

  private final LifeBoard m_board;

}
