// Name: Qiming Lyu

public class GameScore implements Comparable<GameScore> {
  private double score;
  private String name;
  private boolean hardMode;

  /**
   * Constructor for GameScore.
   *
   * @param name     -- the name for this record
   * @param score    -- the score
   * @param hardMode -- whether the game was played in hard mode
   */
  public GameScore(String name, double score, boolean hardMode) {
    this.name = name;
    this.score = score;
    this.hardMode = hardMode;
  }

  /**
   * Getter for the name.
   */
  public String getName() {
    return name;
  }

  /**
   * Getter for the score.
   */
  public double getScore() {
    return score;
  }

  /**
   * Getter for the hardMode.
   */
  public boolean isHardMode() {
    return hardMode;
  }

  /**
   * Overrides toString to return a string representation of the GameScore.
   */
  @Override
  public String toString() {
    String retVal = name + " " + score;
    retVal += hardMode ? "*" : "";
    return retVal;
  }

  /**
   * Implements equals to test for equality of GameScore objects.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof GameScore))
      return false;
    GameScore that = (GameScore) o;
    return name.equals(that.name) &&
        score == that.score &&
        hardMode == that.hardMode;
  }

  /**
   * Implements compareTo to compare GameScore objects.
   *
   * @param other -- the other GameScore to compare to
   */
  @Override
  public int compareTo(GameScore other) {
    if ((this.isHardMode() && !other.isHardMode())) {
      return 1;
    } else if (!this.isHardMode() && other.isHardMode()) {
      return -1;
    } else if (this.getScore() > other.getScore()) {
      return 1;
    } else if (this.getScore() < other.getScore()) {
      return -1;
    } else {
      return 0;
    }
  }
}
