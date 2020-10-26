package uppgifter;

public class Game {
  public Game() {
    deck = new CardDeck();
  }

  public boolean run() {
    deck.shuffle();

    for (int i = 0; deck.moreCards(); i = (i % 3) + 1) {
      Card draw = deck.getCard();
      if (draw.getRank() == (i + 1)) {
        return false;
      }
    }

    return true;
  }

  private final CardDeck deck;
}
