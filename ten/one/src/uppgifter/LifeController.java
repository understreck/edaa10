package uppgifter;

public class LifeController {
  public static void main(String[] args) {
    LifeBoard board = new LifeBoard(15, 15);
    LifeView window = new LifeView(board);
    window.drawBoard();

    while (true) {
      if (window.getCommand() == 3) {
        System.exit(0);
      }
    }
  }
}
