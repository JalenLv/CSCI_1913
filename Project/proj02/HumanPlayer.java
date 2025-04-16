// Name: Qiming Lyu

import java.util.Scanner;

/**
 * This class allows a human to play the game.
 */
public class HumanPlayer implements Player {
  private Scanner scanner;

  /**
   * Constructor that initializes the scanner for user input.
   */
  public HumanPlayer() {
    scanner = new Scanner(System.in);
  }

  /**
   * This function first print the `card` and `board` to the user, and then use
   * the scanner to get an integer from the user, which is returned without any
   * validation.
   *
   * @param card  the card that was drawn from the deck.
   * @param board the current game board.
   *
   * @return the player's choice of columns. If the returned column is invalid
   *         then we assume this `Player` intended to discard the card.
   */
  @Override
  public int nextMove(Card card, Board board) {
    System.out.println(card.toFancyString());
    System.out.println(board.toString());
    return scanner.nextInt();
  }

  /**
   * This main function allows you to play a game of ConnectFwar using the
   * `HumanPlayer`. (Testing purposes only)
   */
  public static void main(String[] args) {
    Player player = new HumanPlayer();
    ConnectFwar.play(player);
  }
}
