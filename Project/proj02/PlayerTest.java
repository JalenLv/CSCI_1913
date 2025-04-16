/**
 * This class has some basic tests for the Player classes.
 */
public class PlayerTest {
    public static void main(String[] args) {

        // define one of each to make sure it exists.
        // we can't really test human and random beyond this.
        // and assign to a Player to make sure inheritance works.
        Player human = new HumanPlayer();
        Player random = new RandomPlayer();
        Player basic = new BasicPlayer();
        Player rank = new RankRunner();
        Player suit = new SuitStacker();

        Board board = new Board();
        Card c;

        c = new Card(1,1);
        System.out.println(basic.nextMove(c,board)); // 0
        assertBoardIsEmpty(board);
        System.out.println(rank.nextMove(c,board)); // 0
        assertBoardIsEmpty(board);
        System.out.println(suit.nextMove(c,board)); // 0
        assertBoardIsEmpty(board);

        c = new Card(1, 2);
        System.out.println(c); // Ace of Hearts
        System.out.println(basic.nextMove(c, board)); // 0
        assertBoardIsEmpty(board);
        System.out.println(rank.nextMove(c, board)); // 0
        assertBoardIsEmpty(board);
        System.out.println(suit.nextMove(c, board)); // 1
        assertBoardIsEmpty(board);

        c = new Card(2, 3);
        System.out.println(c); // Two of Clubs
        System.out.println(basic.nextMove(c, board)); // 0
        assertBoardIsEmpty(board);
        System.out.println(rank.nextMove(c, board)); // 1
        assertBoardIsEmpty(board);
        System.out.println(suit.nextMove(c, board)); // 2
        assertBoardIsEmpty(board);

        c = new Card(12, 4);
        System.out.println(c); // Queen of Diamonds
        System.out.println(basic.nextMove(c, board)); // 0
        assertBoardIsEmpty(board);
        System.out.println(rank.nextMove(c, board)); // 3
        assertBoardIsEmpty(board);
        System.out.println(suit.nextMove(c, board)); // 3
        assertBoardIsEmpty(board);

        board.play(new Card(3, 3), 0);
        board.play(new Card(7, 2), 0);
        board.play(new Card(8, 2), 0);
        board.play(new Card(11, 1), 0);
        board.play(new Card(9, 3), 1);
        board.play(new Card(4, 2), 2);
        board.play(new Card(6, 3), 2);
        board.play(new Card(7, 1), 3);
        board.play(new Card(10, 2), 3);
        board.play(new Card(11, 3), 3);

        System.out.println(board);
        /*
        -------------
        |♠J|  |  |  |
        -------------
        |♥8|  |  |♣J|
        -------------
        |♥7|  |♣6|♥⑩|
        -------------
        |♣3|♣9|♥4|♠7|
        -------------
        */
        c = new Card(13, 3);
        System.out.println(c); // King of Clubs
        System.out.println(basic.nextMove(c, board)); // 1
        System.out.println(rank.nextMove(c, board)); // 0
        System.out.println(suit.nextMove(c, board)); // 2

        c = new Card(3, 4);
        System.out.println(c); // Three of Diamonds
        System.out.println(rank.nextMove(c, board)); // 2
        System.out.println(suit.nextMove(c, board)); // 3

        c = new Card(2, 2);
        System.out.println(c); // Queen of Hearts
        System.out.println(rank.nextMove(c,board)); // 1
        System.out.println(suit.nextMove(c,board)); // 1
    }

    private static void assertBoardIsEmpty(Board board) {
        for(int col = 0; col < 4; col++) {
            for(int row = 0; row < 4; row++) {
                 if (board.getCard(col, row)!= null) {
                    System.out.println("Error -- board should be null!");
                 }
            }
        }
    }

}
// Expected prints:
/*

0
0
0
Ace of Hearts
0
0
1
Two of Clubs
0
1
2
Queen of Diamonds
0
3
3

-------------
|♠J|  |  |  |
-------------
|♥8|  |  |♣J|
-------------
|♥7|  |♣6|♥⑩|
-------------
|♣3|♣9|♥4|♠7|
-------------

King of Clubs
1
0
2
Three of Diamonds
2
3
Two of Hearts
1
1

 */