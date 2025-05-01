// Name: Qiming Lyu

/**
 * Gibberisher is a class that generates gibberish text
 * based on a given training set.
 */
public class Gibberisher {
  private Trie<CharBag> model;
  private int k;                  // length of the segment
  private int n;                  // number of LetterSamples processed

  /**
   * Constructor.
   *
   * @param k length of the segment
   */
  public Gibberisher(int k) {
    model = new Trie<CharBag>();
    this.k = k;
    n = 0;
  }

  /**
   * Trains the model on the given training set.
   *
   * @param train the training set.
   */
  public void train(String[] train) {
    for (String s : train) {
      for (LetterSample sample : LetterSample.toSamples(s, k)) {
        String segment = sample.getSegment();
        char nextLetter = sample.getNextLetter();

        // Init CharBag if not existing
        if (model.get(segment) == null) {
          model.put(segment, new CharBag());
        }

        model.get(segment).add(nextLetter);
        n++;
      }
    }
  }

  /**
   * Returns the number of distinct LetterSamples used to train the model.
   *
   * @return the number of distinct LetterSamples used
   */
  public int getSampleCount() {
    return n;
  }

  /**
   * Generates gibberish string based on the trained model.
   *
   * @return the generated gibberish string
   */
  public String generate() {
    String retVal = "";

    char c = model.get(retVal).getRandomChar();
    while (c != LetterSample.STOP) {
      retVal += c;
      c = model.get(
        retVal.substring(Math.max(0, retVal.length() - k))
      ).getRandomChar();
    }

    return retVal;
  }
}
