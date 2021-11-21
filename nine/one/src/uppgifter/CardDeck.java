package uppgifter;

import java.util.Random;

public class CardDeck {
	private static final int rankOne = 1;
	private static final int rankThirteen = 13;
	private static final Random rng = new Random();

	private static int constructionPos(int suit, int rank) {
		return (rank - 1) * 4 + suit - 1;
	}

	public CardDeck() {
		m_cards = new Card[52];
		m_deckPos = m_cards.length - 1;

		for (int rank = rankOne; rank <= rankThirteen; ++rank) {
			for (int suit = Card.SPADES; suit <= Card.CLUBS; ++suit) {
				m_cards[constructionPos(suit, rank)] = new Card(suit, rank);
			}
		}
	}

	public void shuffle() {
		m_deckPos = m_cards.length - 1;

		for (int i = 0; i < m_cards.length; ++i) {
			Card cardOne = m_cards[i];

			int shufflePos = rng.nextInt(m_cards.length);
			m_cards[i] = m_cards[shufflePos];

			m_cards[shufflePos] = cardOne;
		}
	}

	public boolean moreCards() {
		return m_deckPos >= 0;
	}

	public Card getCard() {
		if (!moreCards()) {
			return null;
		}

		return m_cards[m_deckPos--];
	}

	private Card[] m_cards;
	private int m_deckPos;
};
