// Name: Qiming Lyu

/**
 * The `Player` interface defines the interface for 5 different kinds of
 * players.
 */
public interface Player {
  /**
   * This function is called to decide what column to play the card to after
   * drawing a card.
   *
   * This function will be called by the `ConnectFwar` class as part of the
   * core logic of the gameplay.
   *
   * @param card  the card that was drawn from the deck.
   * @param board the current game board.
   *
   * @return the player's choice of columns. If the returned column is invalid
   *         then we assume this `Player` intended to discard the card.
   */
  public int nextMove(Card card, Board board);
}
