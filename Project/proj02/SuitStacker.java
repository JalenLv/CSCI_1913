// Name: Qiming Lyu

import java.util.Random;

/**
 * This AI player attempts to make columns of cards with the same suit.
 */
public class SuitStacker implements Player {
  /**
   * This function returns the card's suit number minus 1 without validating it.
   *
   * @param card  the card that was drawn from the deck.
   * @param board the current game board.
   *
   * @return the player's choice of columns. If the returned column is invalid
   *         then we assume this `Player` intended to discard the card.
   */
  public int nextMove(Card card, Board board) {
    return card.getSuitNum() - 1;
  }
}
