/**
 * A class that tests the Board class.
 * After implementing the Board and Card classes this file should behave as described
 */
public class BoardTest {

    /** A really basic printing function for a board. This uses only behavior that _is_ specified in the PDF for simplicity. */
    public static void lazy_print_board(Board board) {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                Card c = board.getCard(col, row);
                if (c != null) {
                    System.out.println("("+col+", "+row+") = "+c);
                }
            }
        }
    }
    

    public static void main(String[] args) {
        // tests for basic state management

        Board board = new Board();
        // first things first -- let's a new board should be empty.
        lazy_print_board(board);
        // no output expected at this point.

        // and of course -- an empty board should have no topCard in all 4 places
        System.out.println(board.getTopCard(0)); // null
        System.out.println(board.getTopCard(1)); // null
        System.out.println(board.getTopCard(2)); // null
        System.out.println(board.getTopCard(3)); // null
        
        // OK, let's play a few cards.
        board.play(new Card(1,1),0);
        board.play(new Card(2,3),0);
        board.play(new Card(10,2),1);
        // all 3 plays are legal, so we would expect no error.

        lazy_print_board(board);
        // expected
        // (0, 0) = Ace of Spades
        // (1, 0) = Ten of Hearts
        // (0, 1) = Two of Clubs
        System.out.print(board);
        // your toString should be shown here.
        // this might not be a perfect match 
        // depending on which card print you used.
        /*
        -------------
        |  |  |  |  |
        -------------
        |  |  |  |  |
        -------------
        |♣2|  |  |  |
        -------------
        |♠A|♥⑩|  |  |
        -------------
         */
        System.out.println(board.getTopCard(0)); // Two of Clubs
        System.out.println(board.getTopCard(1)); // Ten of Hearts
        System.out.println(board.getTopCard(2)); // null
        System.out.println(board.getTopCard(3)); // null

        Card c = new Card(7, 4);
        System.out.println(board.canPlay(c, 0)); // true
        System.out.println(board.canPlay(c, 1)); // false
        System.out.println(board.canPlay(c, 2)); // true
        System.out.println(board.canPlay(c, 3)); // true

        // let's fill the board up more.
        board.play(new Card(4, 4), 0);
        board.play(new Card(6, 4), 0);
        board.play(new Card(10, 1), 1);
        board.play(new Card(10, 4), 1);
        board.play(new Card(3, 2), 2);
        lazy_print_board(board);
        // expected
        // (0, 0) = Ace of Spades
        // (1, 0) = Ten of Hearts
        // (2, 0) = Three of Hearts
        // (0, 1) = Two of Clubs
        // (1, 1) = Ten of Spades
        // (0, 2) = Four of Diamonds
        // (1, 2) = Ten of Diamonds
        // (0, 3) = Six of Diamonds

        System.out.println(board);
        /*
        -------------
        |♦6|  |  |  |
        -------------
        |♦4|♦⑩|  |  |
        -------------
        |♣2|♠⑩|  |  |
        -------------
        |♠A|♥⑩|♥3|  |
        -------------
        */

        System.out.println(board.getTopCard(0)); // Six of Diamonds
        System.out.println(board.getTopCard(1)); // Ten of Diamonds
        System.out.println(board.getTopCard(2)); // Three of Hearts
        System.out.println(board.getTopCard(3)); // null

        c = new Card(9,1);
        System.out.println(board.canPlay(c, 0)); // false
        System.out.println(board.canPlay(c, 1)); // false
        System.out.println(board.canPlay(c, 2)); // true
        System.out.println(board.canPlay(c, 3)); // true

        // invalid numbers should be fine here too
        System.out.println(board.canPlay(c, -1)); // false
        System.out.println(board.canPlay(c, 4)); // false
        System.out.println(board.canPlay(c, -100)); // false
        System.out.println(board.canPlay(c, 41)); // false

        board.play(c, 2);
        System.out.println(board.isWinState()); // false
        board.play(new Card(10, 3),3); // false
        // this should create a connected 4 across the diagonal
        // Six of Diamond connects to ten of Diamond (same suit)
        // Ten of Diamond connects to Nine of Spades (adjacent numbers)
        // Nie of Spades connects to Ten of Clubs (adjacent numbers)
        System.out.println(board.isWinState()); // true
        System.out.println(board);
        /*
        -------------
        |♦6|  |  |  |
        -------------
        |♦4|♦⑩|  |  |
        -------------
        |♣2|♠⑩|♠9|  |
        -------------
        |♠A|♥⑩|♥3|♣⑩|
        -------------
        */
      

        //  Test column connect-4
        Board board_col = new Board();
        Card three_spades = new Card(3, 1);
        Card queen_spades = new Card(12, 1);
        Card king_hearts = new Card(13, 2);
        Card king_clubs = new Card(13, 3);

        board_col.play(three_spades, 1);
        board_col.play(queen_spades, 1);
        board_col.play(king_hearts, 1);
        System.out.println(board_col.isWinState()); // false
        board_col.play(king_clubs, 1);
        System.out.println(board_col.isWinState()); // true
        System.out.println(board_col);

        // Test row connect-4
        Board board_row = new Board();
        Card ace_diamonds = new Card(1, 4);
        Card ace_hearts = new Card(1, 2);
        Card ace_clubs = new Card(1, 3);
        Card three_clubs = new Card(3, 3);
        Card five_spades = new Card(5, 1);
        Card seven_hearts = new Card(7, 2);

        Card two_diamonds = new Card(2, 4);
        Card four_diamonds = new Card(4, 4);
        Card six_diamonds = new Card(6, 4);
        Card seven_clubs = new Card(7, 3);

        board_row.play(ace_hearts, 0);
        board_row.play(three_clubs, 1);
        board_row.play(five_spades, 2);
        board_row.play(seven_hearts, 3);
        System.out.println(board_row.isWinState()); // false
        board_row.play(two_diamonds, 0);
        board_row.play(four_diamonds, 1);
        board_row.play(six_diamonds, 2);
        System.out.println(board_row.isWinState()); // false
        board_row.play(seven_clubs, 3);
        System.out.println(board_row.isWinState()); // true
        System.out.println(board_row);


        Board board_diag1 = new Board();
        Card three_diamonds = new Card(3, 4);
        Card two_hearts = new Card(2, 2);
        Card two_clubs = new Card(2, 3);
        Card three_hearts = new Card(3, 2);
        Card six_hearts = new Card(6,2);

        board_diag1.play(ace_diamonds, 0);
        board_diag1.play(ace_hearts, 1);
        board_diag1.play(ace_clubs, 2);
        board_diag1.play(three_diamonds, 3);
        board_diag1.play(two_hearts, 1);
        board_diag1.play(two_clubs,2);
        board_diag1.play(four_diamonds, 3);
        board_diag1.play(three_hearts, 2);
        board_diag1.play(six_hearts, 3);

        System.out.println(board_diag1.isWinState()); // false
        board_diag1.play(seven_hearts, 3);
        System.out.println(board_diag1.isWinState()); // true
        System.out.println(board_diag1);

        // Test diagonal2 connect-4
        Board board_diag2 = new Board();
        board_diag2.play(ace_diamonds, 3);
        board_diag2.play(ace_hearts, 2);
        board_diag2.play(ace_clubs, 1);
        board_diag2.play(three_diamonds, 0);
        board_diag2.play(two_hearts, 2);
        board_diag2.play(two_clubs,1);
        board_diag2.play(four_diamonds, 0);
        board_diag2.play(three_hearts, 1);
        board_diag2.play(six_hearts, 0);
        System.out.println(board_diag2.isWinState()); // false
        board_diag2.play(seven_hearts, 0);
        System.out.println(board_diag2.isWinState()); // true
        System.out.println(board_diag2);
    }
}
// Expected prints:
/*
null
null
null
null
(0, 0) = Ace of Spades
(1, 0) = Ten of Hearts
(0, 1) = Two of Clubs

-------------
|  |  |  |  |
-------------
|  |  |  |  |
-------------
|♣2|  |  |  |
-------------
|♠A|♥⑩|  |  |
-------------
Two of Clubs
Ten of Hearts
null
null
true
false
true
true
(0, 0) = Ace of Spades
(1, 0) = Ten of Hearts
(2, 0) = Three of Hearts
(0, 1) = Two of Clubs
(1, 1) = Ten of Spades
(0, 2) = Four of Diamonds
(1, 2) = Ten of Diamonds
(0, 3) = Six of Diamonds

-------------
|♦6|  |  |  |
-------------
|♦4|♦⑩|  |  |
-------------
|♣2|♠⑩|  |  |
-------------
|♠A|♥⑩|♥3|  |
-------------

Six of Diamonds
Ten of Diamonds
Three of Hearts
null
false
false
true
true
false
false
false
false
false
true

-------------
|♦6|  |  |  |
-------------
|♦4|♦⑩|  |  |
-------------
|♣2|♠⑩|♠9|  |
-------------
|♠A|♥⑩|♥3|♣⑩|
-------------

false
true

-------------
|  |♣K|  |  |
-------------
|  |♥K|  |  |
-------------
|  |♠Q|  |  |
-------------
|  |♠3|  |  |
-------------

false
false
true

-------------
|  |  |  |  |
-------------
|  |  |  |  |
-------------
|♦2|♦4|♦6|♣7|
-------------
|♥A|♣3|♠5|♥7|
-------------

false
true

-------------
|  |  |  |♥7|
-------------
|  |  |♥3|♥6|
-------------
|  |♥2|♣2|♦4|
-------------
|♦A|♥A|♣A|♦3|
-------------

false
true

-------------
|♥7|  |  |  |
-------------
|♥6|♥3|  |  |
-------------
|♦4|♣2|♥2|  |
-------------
|♦3|♣A|♥A|♦A|
-------------

 */
