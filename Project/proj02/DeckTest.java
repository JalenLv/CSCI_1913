/**
 * This class has some basic tests for the Deck class.
 */
public class DeckTest {
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println(deck.cardsRemaining()); // Should print "52"
        System.out.println(deck.isEmpty());        // Should print "false"
        Card card = deck.draw();
        System.out.println(card);                  // Should print a random card - check that it's different every time at least.
        System.out.println(deck.cardsRemaining()); // Should print "51"
        System.out.println(deck.isEmpty());        // Should print "false"

        // loop should print nothing!
        for(int i = 50; i>=0; i--) {
            if(deck.isEmpty()) {
                System.out.println("Unexpectedly empty");
            }

            Card c2 = deck.draw();

            if(card.equals(c2)) {
                System.out.println("Duplicate card?");
            }
            if(i != deck.cardsRemaining()) {
                System.out.println("Deck count seems off!");
            }
        }
        System.out.println(deck.isEmpty());         // Should print "true"
        System.out.print(deck.cardsRemaining()); // Should print "0"
        System.out.println(deck.draw());        //Should print "null"
    }
}
// Expected prints:
/*
52
false
<Random card>
51
false
true
0
null
 */