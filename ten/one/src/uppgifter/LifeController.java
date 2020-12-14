package uppgifter;

public class LifeController {
  public static void main(String[] args) {
    LifeBoard board = new LifeBoard(15, 15);
    Life rules = new Life(board);
    LifeView window = new LifeView(board);
    window.drawBoard();

    while (true) {
      switch (window.getCommand()) {
        case 1: {
          rules.flip(window.getRow(), window.getCol());
        }
          break;

        case 2: { // Next
          rules.newGeneration();
        }
          break;

        case 3: { // Quit
          System.exit(0);
        }
          break;
      }
      window.update();
    }
  }
}
