// Name: Qiming Lyu

/**
 * `ConnectFwar` is a class that represents a game of ConnectFwar.
 */
public class ConnectFwar {
  /**
   * This function plays a full game of ConnectFwar using the given Player
   * object to decide what move to make each turn. This function will implement
   * the whole game workflow, including creating a deck and a board.
   *
   * @param player the Player object that will be used to decide what move to make
   *               each turn.
   *
   * @return the score earned when the game ends.
   */
  public static int play(Player player) {
    // create a board
    Board board = new Board();

    // create a deck
    Deck deck = new Deck();

    // main game loop
    while (!(board.isWinState() || deck.isEmpty())) {
      // draw a card
      Card card = deck.draw();

      // place the card in one of four columns
      int move = player.nextMove(card, board);
      if (move >= 0 && move < 4 && board.canPlay(card, move)) {
        board.play(card, move);
      }
    }

    return deck.cardsRemaining();
  }
}
