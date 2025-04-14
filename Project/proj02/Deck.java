// Name: Qiming Lyu

import java.util.Random;

/**
 * The `Deck` class represents a deck of cards.
 * It has 52 cards and uses an array to store them and their order.
 */
public class Deck {
  private Card[] deck;
  private int topCard;

  public Deck() {
    // Init `topCard`
    topCard = 0;

    // Init `deck` array
    deck = new Card[52];
    for (int suit = 1; suit <= 4; suit++) {
      for (int rank = 1; rank <= 13; rank++) {
        deck[(suit - 1) * 13 + (rank - 1)] = new Card(rank, suit);
      }
    }

    // Shuffle `deck` array
    shuffle(deck);
  }

  /*
   * Shuffles the deck of cards using the Fisher-Yates shuffle algorithm.
   *
   * @param deck the array of cards to shuffle.
   */
  public void shuffle(Card[] deck) {
    // Use Fisher-Yates shuffle algorithm to shuffle the deck
    Random random = new Random();
    for (int i = deck.length - 1; i >= 1; i--) {
      int j = random.nextInt(i + 1);
      Card temp = deck[i];
      deck[i] = deck[j];
      deck[j] = temp;
    }

    // Reset `topCard`
    topCard = 0;
  }

  /*
   * Draws and returns the next card.
   */
  public Card draw() {
    if (!isEmpty()) {
      return deck[topCard++];
    } else {
      return null;
    }
  }

  /*
   * Returns the number of cards left in the deck.
   */
  public int cardsRemaining() {
    return deck.length - topCard;
  }

  /*
   * Checks if the deck is empty.
   *
   * @return true if the deck is empty, false otherwise.
   */
  public boolean isEmpty() {
    return topCard >= deck.length;
  }
}
