// Name: Qiming Lyu

/**
 * This class is used to compare the performance of different AI players.
 */
public class PlayerComparison {

  static final int NUM_GAMES = 10000;
  static final int NUM_PLAYERS = 4;

  public static void main(String[] args) {
    int[] scores = new int[NUM_PLAYERS];
    double[] averScores = new double[NUM_PLAYERS];
    String[] playerNames = { "random", "basic", "suits", "ranks" };

    for (int i = 0; i < NUM_GAMES; i++) {
      for (int j = 0; j < NUM_PLAYERS; j++) {
        Player player = null;
        switch (j) {
          case 0:
            player = new RandomPlayer();
            break;
          case 1:
            player = new BasicPlayer();
            break;
          case 2:
            player = new SuitStacker();
            break;
          case 3:
            player = new RankRunner();
            break;
        }
        scores[j] += ConnectFwar.play(player);
      }
    }

    for (int i = 0; i < NUM_PLAYERS; i++) {
      averScores[i] = (double) scores[i] / NUM_GAMES;
    }

    for (int i = 0; i < NUM_PLAYERS; i++) {
      System.out.println(playerNames[i] + "\t" + averScores[i]);
    }
  }
}
