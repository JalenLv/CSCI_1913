// Name: Qiming Lyu

import java.util.Random;

/**
 * This AI player simply makes random moves.
 */
public class RandomPlayer implements Player {
  private Random randon;

  /**
   * constructor that initializes the random number generator.
   */
  public RandomPlayer() {
    randon = new Random();
  }

  /**
   * This function simply returns a random column without validating it.
   *
   * @param card  the card that was drawn from the deck.
   * @param board the current game board.
   *
   * @return the player's choice of columns. If the returned column is invalid
   *         then we assume this `Player` intended to discard the card.
   */
  public int nextMove(Card card, Board board) {
    return randon.nextInt(4);
  }
}
