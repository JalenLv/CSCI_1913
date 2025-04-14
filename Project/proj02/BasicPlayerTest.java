/**
 * This class has some basic tests for the BasicPlayer class.
 */
public class BasicPlayerTest {
    public static void main(String[] args) {
        Card[] cards = new Card[20];
        int counter = 0;
        for (int rank = 1; rank <=5; rank++) {
            for (int suit = 1; suit <=4; suit++){
                cards[counter] = new Card(rank, suit);
                counter += 1;
            }
        }

        Board board1 = new Board();
        BasicPlayer player = new BasicPlayer();
        board1.play(cards[0], player.nextMove(cards[0], board1));
        board1.play(cards[1], player.nextMove(cards[1], board1));
        board1.play(cards[2], player.nextMove(cards[2], board1));
        board1.play(cards[3], player.nextMove(cards[3], board1));
        board1.play(cards[4], player.nextMove(cards[4], board1));
        board1.play(cards[5], player.nextMove(cards[5], board1));
        board1.play(cards[6], player.nextMove(cards[6], board1));
        board1.play(cards[7], player.nextMove(cards[7], board1));
        board1.play(cards[8], player.nextMove(cards[8], board1));
        board1.play(cards[9], player.nextMove(cards[9], board1));
        board1.play(cards[10], player.nextMove(cards[10], board1));
        board1.play(cards[11], player.nextMove(cards[11], board1));
        board1.play(cards[12], player.nextMove(cards[12], board1));
        board1.play(cards[13], player.nextMove(cards[13], board1));
        board1.play(cards[14], player.nextMove(cards[14], board1));
        board1.play(cards[15], player.nextMove(cards[15], board1));
        System.out.println(player.nextMove(cards[16], board1)); // Should print something of 0-3
        System.out.println(board1); // Should print expected board representation

        Board board2 = new Board();
        board2.play(cards[16], player.nextMove(cards[16], board2));
        board2.play(cards[15], player.nextMove(cards[15], board2));
        board2.play(cards[14], player.nextMove(cards[14], board2));
        board2.play(cards[13], player.nextMove(cards[13], board2));
        board2.play(cards[12], player.nextMove(cards[12], board2));
        board2.play(cards[11], player.nextMove(cards[11], board2));
        board2.play(cards[10], player.nextMove(cards[10], board2));
        board2.play(cards[9], player.nextMove(cards[9], board2));
        board2.play(cards[8], player.nextMove(cards[8], board2));
        board2.play(cards[7], player.nextMove(cards[7], board2));
        board2.play(cards[6], player.nextMove(cards[6], board2));
        board2.play(cards[5], player.nextMove(cards[5], board2));
        board2.play(cards[4], player.nextMove(cards[4], board2));
        System.out.println(player.nextMove(cards[3], board2)); // Should print something of 0-3
        System.out.println(board2); // Should print expected board representation
    }
}
// Expected prints:
/*
<number out of index>

-------------
|♦A|♦2|♦3|♦4|
-------------
|♣A|♣2|♣3|♣4|
-------------
|♥A|♥2|♥3|♥4|
-------------
|♠A|♠2|♠3|♠4|
-------------

<number out of index>

-------------
|  |♠4|♠3|♠2|
-------------
|  |♥4|♥3|♥2|
-------------
|  |♣4|♣3|♣2|
-------------
|♠5|♦4|♦3|♦2|
-------------
 */