// Name: Qiming Lyu

/**
 * The `Card` class represents a single playing card.
 *
 * We use two integers to represent rank and suit.
 *
 * We use 1 for Ace, 2 for Two, and so-forth.
 * We use 11 for Jack, 12 for Queen, and 13 for King.
 *
 * We 1 for Spades, 2 for Hearts, 3 for Clubs, and 4 for Diamonds.
 *
 * A `Card` object should be immutable.
 */
public class Card {
  private final int rank;
  private final int suit;

  /**
   * The `RANKS` array contains the string representation of the ranks.
   */
  private static final String[] RANKS = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
      "Jack", "Queen", "King" };

  /**
   * The `SUITS` array contains the string representation of the suits.
   */
  private static final String[] SUITS = { "Spades", "Hearts", "Clubs", "Diamonds" };

  /**
   * Constructor of the `Card` class.
   * It validates the input parameters.
   * An error message will be displayed if any parameter is invalid.
   *
   * @param rank indicates the rank of the card.
   * @param suit indicates the suit of the card.
   */
  public Card(int rank, int suit) {
    if (!(rank >= 1 && rank <= 13 && suit >= 1 && suit <= 4)) {
      System.out.println("Invalid Card");
      this.rank = 1;
      this.suit = 1;
    } else {
      this.rank = rank;
      this.suit = suit;
    }
  }

  /**
   * Returns the number representation of the card's rank.
   */
  public int getRankNum() {
    return rank;
  }

  /**
   * Returns the number representation of the card's suit.
   */
  public int getSuitNum() {
    return suit;
  }

  /**
   * Returns the string representation of the card's suit.
   */
  public String getRankName() {
    return RANKS[rank - 1];
  }

  /**
   * Returns the string representation of the card's suit.
   */
  public String getSuitName() {
    return SUITS[suit - 1];
  }

  /**
   * Returns the human readable name of the card.
   */
  @Override
  public String toString() {
    return getRankName() + " of " + getSuitName();
  }

  /**
   * Overrides the equals function to compare two `Card` objects.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }
    Card other = (Card) obj;
    return (this.rank == other.rank && this.suit == other.suit);
  }

  public String toVeryFancyString() {
    // we're getting into some deep magic with this one.
    // Don't be too worried if it doesn't work on your computer.

    // user getSuitNum and getRankNum so we don't assume any specific private
    // variable name.
    char letter_part_one = '\uD83C';
    char letter_part_two = (char) ('\uDCA0' + getRankNum());
    if (getSuitNum() == 2) {
      letter_part_two += 16;
    } else if (getSuitNum() == 4) {
      letter_part_two += 32;
    } else if (getSuitNum() == 3) {
      letter_part_two += 48;
    }
    if (getRankNum() >= 12) {
      letter_part_two++; // skip "Knight".
    }

    String retval;
    if (getSuitNum() % 2 == 1) {
      // black card
      retval = "\u001B[30m\u001B[47m";
    } else {
      // red card
      retval = "\u001B[31m\u001B[47m";
    }

    return retval + letter_part_one + letter_part_two + " \u001B[0m";
  }

  public String toFancyString() {
    String suits = "♠♥♣♦";
    String ranks = "A23456789⑩JQK";
    // user getSuitNum and getRankNum so we don't assume any specific private
    // variable name.
    return "" + suits.charAt(getSuitNum() - 1) + ranks.charAt(getRankNum() - 1);
  }

}
