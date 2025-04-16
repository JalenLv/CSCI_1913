// Name: Qiming Lyu

/**
 * This AI player simply makes the first legal choice it sees.
 */
public class BasicPlayer implements Player {
  /**
   * This function checks each column in order, returning the first column that
   * the card can be legally played to. This function returns -1 when no valid
   * column is found.
   *
   * @param card  the card that was drawn from the deck.
   * @param board the current game board.
   *
   * @return the player's choice of columns. If the returned column is invalid
   *         then we assume this `Player` intended to discard the card.
   */
  public int nextMove(Card card, Board board) {
    for (int i = 0; i < 4; i++) {
      if (board.canPlay(card, i)) {
        return i;
      }
    }

    return -1;
  }
}
