/**
 * A class that tests the cards class.
 * After implementing the cards class this file should behave as described
 */
public class CardTest {
  public static void printCatd(Card c) {
    System.out.println(c + " " + c.toFancyString() + " " + c.toVeryFancyString());
  }

  public static void main(String[] args) {

    Card as = new Card(1, 1);
    System.out.println(as); // should print "Ace of Spades"
    System.out.println(as.getRankName()); // should print "Ace"
    System.out.println(as.getRankNum()); // should print 1
    System.out.println(as.getSuitName()); // should print "Spades"
    System.out.println(as.getSuitNum()); // should print 1

    // System.out.println(new Card(2, 2)); // should print "Two of Hearts"
    // System.out.println(new Card(3, 3)); // should print "Three of Clubs"
    // System.out.println(new Card(4, 4)); // should print "Four of Diamonds"
    //
    // System.out.println(new Card(10, 4)); // should print "Ten of Diamonds"
    // System.out.println(new Card(12, 2)); // should print "Queen of Hearts"

    printCatd(new Card(2, 2)); // should print "Two of Hearts"
    printCatd(new Card(3, 3)); // should print "Three of Clubs"
    printCatd(new Card(4, 4)); // should print "Four of Diamonds"

    printCatd(new Card(10, 4)); // should print "Ten of Diamonds"
    printCatd(new Card(12, 2)); // should print "Queen of Hearts"

    Card js = new Card(11, 1);
    Card jc = new Card(11, 3);
    Card other = new Card(11, 3);

    System.out.println(as.equals(js)); // should print "false"
    System.out.println(js.equals(as)); // should print "false"
    System.out.println(as.equals(jc)); // should print "false"
    System.out.println(jc.equals(other)); // should print "true"

    Card err = new Card(-4, 4); // should print "Invalid Card"
    System.out.println(err); // should print "Ace of Spades"
    err = new Card(3, 11); // should print "Invalid Card"
    System.out.println(err); // should print "Ace of Spades"
    err = new Card(33, 2); // should print "Invalid Card"
    System.out.println(err); // should print "Ace of Spades"

    // You may find it useful to make other Card methods. Please do.
    // If you do make other methods I recommend designing some tests and putting
    // them in this file
    // This will help you avoid bugs, or at the least catch bugs before they become
    // an issue.
  }
}
// Expected prints:
/*
 * Ace of Spades
 * Ace
 * 1
 * Spades
 * 1
 * Two of Hearts
 * Three of Clubs
 * Four of Diamonds
 * Ten of Diamonds
 * Queen of Hearts
 * false
 * false
 * false
 * true
 * Invalid Card
 * Ace of Spades
 * Invalid Card
 * Ace of Spades
 * Invalid Card
 * Ace of Spades
 */
