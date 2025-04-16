// Name: Qiming Lyu

import java.util.Random;

/**
 * This AI player attempts to make columns of cards with the same number,
 * or rows of cards that are increasing/decreasing in value.
 */
public class RankRunner implements Player {
  Random random;

  /**
   * constructor that initializes the random number generator.
   */
  public RankRunner() {
    random = new Random();
  }

  /**
   * This function should return 0 for all Aces, 1 for all Twos, 2 for all Threes,
   * 3 for all Fours, 0 for all Fives, 1 for all Sixes, 2 for all Sevens, etc.
   *
   * This function is not expected to check if the play is valid.
   *
   * @param card  the card that was drawn from the deck.
   * @param board the current game board.
   *
   * @return the player's choice of columns. If the returned column is invalid
   *         then we assume this `Player` intended to discard the card.
   */
  public int nextMove(Card card, Board board) {
    return (card.getRankNum() - 1) % 4;
  }
}
