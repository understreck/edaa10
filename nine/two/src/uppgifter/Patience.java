package uppgifter;

public class Patience {
  public static void main(String[] args) {
    final Game game = new Game();

    final int timesToRun = 1000000;
    int timesWon = 0;
    for (int i = 0; i < timesToRun; ++i) {
      if (game.run()) {
        ++timesWon;
      }
    }

    final double winChance = (double) timesWon / (double) timesToRun;
    final double winPercentage = winChance * 100.0;

    System.out.println("Run " + timesToRun + " times.");
    System.out.println("Won " + timesWon + " times.");
    System.out.println(winPercentage + "% won!");
  }
}
