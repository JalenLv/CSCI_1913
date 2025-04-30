// Name: Qiming Lyu

import java.util.Random;

import javax.sound.sampled.ReverbType;

/**
 * The CharBag class is a custom Bag ADT that stores the counts of characters.
 */
public class CharBag {
  /**
   * The counts array stores the counts of characters
   * 'a' to 'z' from index 0 to 25 and the STOP character at index 26.
   */
  private int[] counts;
  private int size;
  private static final int nEnglishLetters = 26;
  private static final int indexCharStop = 26;

  /**
   * Constructor for CharBag to create an empty bag.
   */
  public CharBag() {
    counts = new int[27];
  }

  /**
   * Adds a character to the CharBag.
   *
   * Uppercase letters are treated equally as lowercase letters.
   * Any non-English alphabet letter counts as the STOP character.
   *
   * @param c the character to add to the CharBag
   */
  public void add(char c) {
    // Add the character
    if (isLetter(c)) {
      // If c is a letter
      c = Character.toLowerCase(c);
      counts[c - 'a']++;
    } else {
      // If c is not a letter
      counts[indexCharStop]++;
    }

    // Update size
    size++;
  }

  /**
   * Removes a character from the CharBag.
   *
   * Uppercase letters are treated equally as lowercase letters.
   * Any non-English alphabet letter counts as the STOP character.
   *
   * @param c the character to remove from the CharBag
   */
  public void remove(char c) {
    if (isLetter(c)) {
      // If c is a letter
      c = Character.toLowerCase(c);
      int index = c - 'a';
      if (counts[index] > 0) {
        counts[index]--;
        // Update size
        size--;
      }
    } else {
      // If c is not a letter
      if (counts[indexCharStop] > 0) {
        counts[indexCharStop]--;
        // Update size
        size--;
      }
    }
  }

  /**
   * Returns how many times a given character is in the CharBag.
   *
   * Uppercase letters are treated equally as lowercase letters.
   * Any non-English alphabet letter counts as the STOP character.
   *
   * @param c the character to count in the CharBag
   */
  public int getCount(char c) {
    if (isLetter(c)) {
      // If c is a letter
      c = Character.toLowerCase(c);
      int index = c - 'a';
      return counts[index];
    } else {
      // If c is not a letter
      return counts[indexCharStop];
    }
  }

  /**
   * Returns the size of the CharBag.
   *
   * @return the size of the CharBag
   */
  public int getSize() {
    return size;
  }

  /**
   * Returns the string representation of the CharBag with format like:
   * CharBag{a:3, b:0, c:0, ... , x:0, y:3, z:0, <STOP CHAR>:0}
   *
   * @return the string representation of the CharBag.
   */
  @Override
  public String toString() {
    String retVal = "";
    
    retVal += "CharBag{";
    for (int i = 0; i < nEnglishLetters; i++) {
      retVal += (char) (i + 'a');
      retVal += ':';
      retVal += counts[i];
      retVal += ", ";
    }
    retVal += LetterSample.STOP;
    retVal += ':';
    retVal += counts[indexCharStop];
    retVal += '}';

    return retVal;
  }

  /**
   * Returns a randomly chosen char from the CharBag based on frequency.
   * Returns STOP CHAR if the CharBag is empty.
   *
   * @return a randomly chosen char from the CharBag
   */
  public char getRandomChar() {
    if (getSize() == 0) {
      return LetterSample.STOP;
    }

    Random random = new Random();

    int count = random.nextInt(getSize());
    for (char c = 'a'; c < 'z'; c++) {
      count -= getCount(c);
      if (count < 0) {
        return c;
      }
    }
    return LetterSample.STOP;
  }

  /**
   * Checks if the character is an English alphabet letter (a-z or A-Z).
   *
   * @param c the character to check
   *
   * @return true if the character is a letter, false otherwise
   */
  private boolean isLetter(char c) {
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
  }
}
