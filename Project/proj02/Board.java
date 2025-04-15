// Name: Qiming Lyu

/**
 * The `Board` class represents the game board for ConnectFwar.
 * 
 * This class is in charge of tracking the 4x4 grid of cards,
 * knowing the rules for what cards can be played where,
 * as well as the rules for determining if the game has ended
 * with a connected out.
 */
public class Board {
  /**
   * The `cards` array represents the 4x4 grid of cards.
   */
  private Card[][] cards;

  /**
   * The `topCards` array represents the top card in each column.
   */
  private int[] topCards;

  /**
   * Constructor which initializes the `cards` array.
   */
  public Board() {
    cards = new Card[4][4];
    topCards = new int[] { -1, -1, -1, -1 };
  }

  /**
   * Gets the top card of a given column.
   *
   * Columns are zero-indexed. This function returns null
   * if the column is empty or given an invalid column.
   * 
   * @param column The column index.
   */
  public Card getTopCard(int column) {
    if (column < 0 || column >= 4) {
      System.out.println("Invalid column index: " + column);
      return null;
    }
    return topCards[column] == -1 ? null : cards[column][topCards[column]];
  }

  /**
   * Returns the card at a given position.
   *
   * Rows are zero-indexed with row 0 being the bottom of a column.
   * This function returns null if there is no card in that position.
   *
   * @param col The column index.
   * @param row The row index.
   */
  public Card getCard(int col, int row) {
    if (col < 0 || col >= 4 || row < 0 || row >= 4) {
      System.out.println("Invalid column or row index: " + col + ", " + row);
      return null;
    }
    return topCards[col] >= row ? cards[col][row] : null;
  }

  /**
   * Check if it is legal to play a given card to a given column.
   *
   * This function returns false if given an invalid column number.
   */
  public boolean canPlay(Card c, int column) {
    if (column < 0 || column >= 4) {
      return false;
    }
    return topCards[column] == -1 ? true
        : (topCards[column] >= 3 ? false : c.getRankNum() >= cards[column][topCards[column]].getRankNum());
  }

  /**
   * Updates the board to show the result of playing a card to the given column.
   *
   * The behavior of this function is unspecified if the play is illegal.
   */
  public void play(Card c, int column) {
    cards[column][++topCards[column]] = c;
  }

  /**
   * Check if there is any connected four in any row, column, or diagonal.
   */
  public boolean isWinState() {
    for (int i = 0; i < 4; i++)
      if (isWinCol(i))
        return true;

    for (int i = 0; i < 4; i++)
      if (isWinRow(i))
        return true;

    if (isWinMainDiag() || isWinAntiDiag())
      return true;

    return false;
  }

  /**
   * Helper function to check if an adjacent pair of cards are connected.
   *
   * A pair of cards are connected if they hava:
   * - the same suit
   * - the same value
   * - adjacent values
   */
  private boolean isConnected(Card c1, Card c2) {
    return c1.getSuitNum() == c2.getSuitNum() ||
        c1.getRankNum() == c2.getRankNum() ||
        Math.abs(c1.getRankNum() - c2.getRankNum()) == 1;
  }

  /**
   * Helper function to check if there is a connected four in a given column.
   */
  private boolean isWinCol(int col) {
    if (topCards[col] < 3) {
      return false;
    }

    for (int i = 0; i < 3; i++) {
      if (!isConnected(cards[col][i], cards[col][i + 1])) {
        return false;
      }
    }
    return true;
  }

  /**
   * Helper function to check if there is a connected four in a given row.
   */
  private boolean isWinRow(int row) {
    for (int i = 0; i < 4; i++) {
      if (topCards[i] < row) {
        return false;
      }
    }

    for (int i = 0; i < 3; i++) {
      if (!isConnected(cards[i + 1][row], cards[i][row])) {
        return false;
      }
    }
    return true;
  }

  /**
   * Helper function to check if there is a connected four in the main diagonal.
   */
  private boolean isWinMainDiag() {
    for (int i = 0; i < 4; i++) {
      if (topCards[i] < 3 - i) {
        return false;
      }
    }

    for (int i = 0; i < 3; i++) {
      if (!isConnected(cards[i][3 - i], cards[i + 1][3 - (i + 1)])) {
        return false;
      }
    }
    return true;
  }

  /**
   * Helper function to check if there is a connected four in the anti diagonal.
   */
  private boolean isWinAntiDiag() {
    for (int i = 0; i < 4; i++) {
      if (topCards[i] < i) {
        return false;
      }
    }

    for (int i = 0; i < 3; i++) {
      if (!isConnected(cards[i][i], cards[i + 1][i + 1])) {
        return false;
      }
    }
    return true;
  }

  /**
   * Returns a string representation of the board.
   */
  @Override
  public String toString() {
    String retVal = new String();
    for (int row = 3; row >= 0; row--) {
      retVal += "-------------\n";
      for (int col = 0; col < 4; col++) {
        Card c = getCard(col, row);
        retVal += ("|" + (c == null ? "  " : c.toFancyString()));
      }
      retVal += "|\n";
    }
    retVal += "-------------\n";

    return retVal;
  }
}
