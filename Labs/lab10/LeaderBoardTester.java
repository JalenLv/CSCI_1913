public class LeaderBoardTester {

  public static void integerTests() {
    System.out.println("-------------------------------------");
    System.out.println("Test cases for INTEGER");
    System.out.println("Test 1\n");

    LeaderBoard<Integer> lb = new LeaderBoard<>(5, 1);
    for (int i = 20; i > 0; i -= 2) {
      lb.add(i);
    }
    String before = lb.toString();
    System.out.println("before adding");
    System.out.println(before);
    lb.add(lb.lowScore());
    System.out.println("after adding " + lb.lowScore());
    String after = lb.toString();
    System.out.println(after);

    System.out.println(before.equals(after));

    System.out.println("Test 2\n");

    System.out.println("before adding");
    System.out.println(before);
    int before_low = lb.lowScore();
    int val = lb.lowScore() + 1;
    lb.add(val);
    int after_low = lb.lowScore();
    System.out.println("after adding " + val);
    after = lb.toString();
    System.out.println(after);

    System.out.println(before_low < after_low);

    System.out.println("Test 3\n");

    String expected;
    String[] seg;
    String middle;
    System.out.println("before adding");
    before = lb.toString();
    System.out.println(before);
    seg = lb.toString().split("\n", 0);
    middle = seg[new Integer(seg.length / 2)];
    val = Integer.valueOf(middle.split(" ")[1]);
    lb.add(val);
    System.out.println("after adding " + val);
    after = lb.toString();
    System.out.println(after);
    expected = "1. 20\n" +
        "2. 18\n" +
        "3. 16\n" +
        "4. 16\n" +
        "5. 14\n";

    System.out.println(expected.equals(after));

    System.out.println("Test 4\n");

    System.out.println("before adding");
    before = lb.toString();
    System.out.println(before);
    val = lb.highScore() + 1;
    lb.add(val);
    System.out.println("after adding " + val);
    after = lb.toString();
    System.out.println(after);

    System.out.println(lb.highScore() == val);

    System.out.println("Test 5\n");

    System.out.println("before adding");
    before = lb.toString();
    System.out.println(before);
    val = lb.highScore() + 1;
    lb.add(val);
    System.out.println("after adding " + val);
    after = lb.toString();
    System.out.println(after);

    System.out.println(lb.highScore() == val);

    System.out.println("Test 6\n");
    lb = new LeaderBoard<>(5, 2);

    System.out.println("before flushing");
    before = lb.toString();
    System.out.println(before);

    for (int i = 30; i > 0; i -= 1) {
      lb.add(i);
    }
    System.out.println("after flushing ");
    after = lb.toString();
    System.out.println(after);

    val = 5;
    lb.add(val);
    System.out.println("after adding " + val);
    after = lb.toString();
    System.out.println(after);

    expected = "1. 30\n" +
        "2. 29\n" +
        "3. 28\n" +
        "4. 27\n" +
        "5. 26\n";

    System.out.println(after.equals(expected));

  }

  public static void doubleTests() {

    System.out.println("-------------------------------------");
    System.out.println("Test cases for DOUBLE");
    System.out.println("Test 1\n");

    LeaderBoard<Double> lbDouble = new LeaderBoard<Double>(5, 0.001);

    for (int i = 20; i > 0; i -= 2) {
      lbDouble.add(i + 0.01);
    }
    String before = lbDouble.toString();
    System.out.println("before adding");
    System.out.println(before);
    lbDouble.add(lbDouble.lowScore());
    System.out.println("after adding " + lbDouble.lowScore());
    String after = lbDouble.toString();
    System.out.println(after);

    System.out.println(before.equals(after));

    System.out.println("Test 2\n");

    System.out.println("before adding");
    System.out.println(before);
    Double beforeLowDouble = lbDouble.lowScore();
    Double valDouble = lbDouble.lowScore() + 1;
    lbDouble.add(valDouble);
    Double afterLowDouble = lbDouble.lowScore();
    System.out.println("after adding " + valDouble);
    after = lbDouble.toString();
    System.out.println(after);

    System.out.println(beforeLowDouble < afterLowDouble);

    System.out.println("Test 3\n");

    System.out.println("before adding");
    before = lbDouble.toString();
    System.out.println(before);
    String[] seg = lbDouble.toString().split("\n", 0);
    String middle = seg[new Integer(seg.length / 2)];
    valDouble = Double.valueOf(middle.split(" ")[1]);
    lbDouble.add(valDouble);
    System.out.println("after adding " + valDouble);
    after = lbDouble.toString();
    System.out.println(after);

    String expected = "1. 20.01\n" +
        "2. 18.01\n" +
        "3. 16.01\n" +
        "4. 16.01\n" +
        "5. 14.01\n";
    System.out.println(expected.equals(after));

    System.out.println("Test 4\n");

    System.out.println("before adding");
    before = lbDouble.toString();
    System.out.println(before);
    valDouble = lbDouble.highScore() + 1;
    lbDouble.add(valDouble);
    System.out.println("after adding " + valDouble);
    after = lbDouble.toString();
    System.out.println(after);

    System.out.println(lbDouble.highScore() == valDouble);

    System.out.println("Test 5\n");

    System.out.println("before adding");
    before = lbDouble.toString();
    System.out.println(before);
    valDouble = lbDouble.highScore() + 1;
    lbDouble.add(valDouble);
    System.out.println("after adding " + valDouble);
    after = lbDouble.toString();
    System.out.println(after);

    System.out.println(lbDouble.highScore() == valDouble);

    System.out.println("Test 6\n");
    lbDouble = new LeaderBoard<>(5, 0.2);

    System.out.println("before flushing");
    before = lbDouble.toString();
    System.out.println(before);

    for (int i = 30; i > 0; i -= 1) {
      lbDouble.add(i + 0.1);
    }
    System.out.println("after flushing ");
    after = lbDouble.toString();
    System.out.println(after);

    valDouble = 5 + 0.1;
    lbDouble.add(valDouble);
    System.out.println("after adding " + valDouble);
    after = lbDouble.toString();
    System.out.println(after);

    expected = "1. 30.1\n" +
        "2. 29.1\n" +
        "3. 28.1\n" +
        "4. 27.1\n" +
        "5. 26.1\n";

    System.out.println(after.equals(expected));

  }

  public static void stringTests() {
    System.out.println("-------------------------------------");
    System.out.println("Test cases for STRING");
    System.out.println("Test 1\n");

    LeaderBoard<String> lbString = new LeaderBoard<String>(5, "aaa");

    for (int i = 20; i > 0; i -= 2) {
      lbString.add(Character.toString((char) (97 + i)));
    }
    String before = lbString.toString();
    System.out.println("before adding");
    System.out.println(before);
    lbString.add(lbString.lowScore());
    System.out.println("after adding " + lbString.lowScore());
    String after = lbString.toString();
    System.out.println(after);

    System.out.println(before.equals(after));

    System.out.println("Test 2\n");

    System.out.println("before adding");
    System.out.println(before);
    String beforeLowString = lbString.lowScore();
    String valString = lbString.lowScore() + "b";
    lbString.add(valString);
    String afterLowString = lbString.lowScore();
    System.out.println("after adding " + valString);
    after = lbString.toString();
    System.out.println(after);

    System.out.println(beforeLowString.compareTo(afterLowString) < 0);

    System.out.println("Test 3\n");

    System.out.println("before adding");
    before = lbString.toString();
    System.out.println(before);
    String[] seg = lbString.toString().split("\n", 0);
    String middle = seg[new Integer(seg.length / 2)];
    valString = middle.split(" ")[1];
    lbString.add(valString);
    System.out.println("after adding " + valString);
    after = lbString.toString();
    System.out.println(after);

    String expected = "1. u\n" +
        "2. s\n" +
        "3. q\n" +
        "4. q\n" +
        "5. o\n";
    System.out.println(expected.equals(after));

    System.out.println("Test 4\n");

    System.out.println("before adding");
    before = lbString.toString();
    System.out.println(before);
    valString = lbString.highScore() + "bb";
    lbString.add(valString);
    System.out.println("after adding " + valString);
    after = lbString.toString();
    System.out.println(after);

    System.out.println(lbString.highScore().equals(valString));

    System.out.println("Test 5\n");

    System.out.println("before adding");
    before = lbString.toString();
    System.out.println(before);
    valString = lbString.highScore() + "d";
    lbString.add(valString);
    System.out.println("after adding " + valString);
    after = lbString.toString();
    System.out.println(after);

    System.out.println(lbString.highScore().equals(valString));

    System.out.println("Test 6\n");
    lbString = new LeaderBoard<String>(5, "bbb");

    System.out.println("before flushing");
    before = lbString.toString();
    System.out.println(before);

    for (int i = 25; i > 0; i -= 1) {
      lbString.add(Character.toString((char) (97 + i)));
    }
    System.out.println("after flushing ");
    after = lbString.toString();
    System.out.println(after);

    valString = "ccc";
    lbString.add(valString);
    System.out.println("after adding " + valString);
    after = lbString.toString();
    System.out.println(after);

    expected = "1. z\n" +
        "2. y\n" +
        "3. x\n" +
        "4. w\n" +
        "5. v\n";

    System.out.println(after.equals(expected));
  }

  public static void gameScoreTests() {
    System.out.println("-------------------------------------");
    System.out.println("Test cases for GAMESCORE");
    System.out.println("Test 1\n");

    LeaderBoard<GameScore> lbGameScore = new LeaderBoard<GameScore>(5, new GameScore("aaa", 1.1, true));
    for (int i = 20; i > 0; i -= 2) {
      lbGameScore.add(new GameScore("DAK", i + 0.01, true));
    }
    String before = lbGameScore.toString();
    System.out.println("before adding");
    System.out.println(before);
    lbGameScore.add(new GameScore("KEV", 12.01, true));
    System.out.println("after adding " + new GameScore("KEV", 12.01, true));
    String after = lbGameScore.toString();
    System.out.println(after);

    System.out.println(before.equals(after));

    System.out.println("Test 2\n");

    System.out.println("before adding");
    System.out.println(before);
    GameScore beforeLowGameScore = lbGameScore.lowScore();
    GameScore valGameScore = new GameScore("NEW", lbGameScore.lowScore().getScore() + 1, true);
    lbGameScore.add(valGameScore);
    GameScore afterLowGameScore = lbGameScore.lowScore();
    System.out.println("after adding " + valGameScore);
    after = lbGameScore.toString();
    System.out.println(after);

    System.out.println(beforeLowGameScore.compareTo(afterLowGameScore) < 0);

    System.out.println("Test 3\n");

    System.out.println("before adding");
    before = lbGameScore.toString();
    System.out.println(before);
    String[] seg = lbGameScore.toString().split("\n", 0);
    String middle = seg[new Integer(seg.length / 2)];
    middle = middle.split(" ")[2];
    double valDouble = Double.valueOf(middle.substring(0, middle.length() - 1));
    valGameScore = new GameScore("NEW", valDouble, true);
    lbGameScore.add(valGameScore);
    System.out.println("after adding " + valGameScore.toString());
    after = lbGameScore.toString();
    System.out.println(after);

    // NOTE the new 16.01 score should go after the old one.
    String expected = "1. DAK 20.01*\n" +
        "2. DAK 18.01*\n" +
        "3. DAK 16.01*\n" +
        "4. NEW 16.01*\n" +
        "5. DAK 14.01*\n";
    System.out.println(expected.equals(after));

    System.out.println("Test 4\n");

    System.out.println("before adding");
    before = lbGameScore.toString();
    System.out.println(before);
    valDouble = lbGameScore.highScore().getScore() + 1;
    valGameScore = new GameScore("NEW", valDouble, true);
    lbGameScore.add(valGameScore);
    System.out.println("after adding " + valGameScore.toString());
    after = lbGameScore.toString();
    System.out.println(after);

    System.out.println(lbGameScore.highScore().equals(valGameScore));

    System.out.println("Test 5\n");

    System.out.println("before adding");
    before = lbGameScore.toString();
    System.out.println(before);
    valDouble = lbGameScore.highScore().getScore() + 1;
    valGameScore = new GameScore("NEW", valDouble, true);
    lbGameScore.add(valGameScore);
    System.out.println("after adding " + valGameScore);
    after = lbGameScore.toString();
    System.out.println(after);

    System.out.println(lbGameScore.highScore() == valGameScore);

    System.out.println("Test 6\n");
    lbGameScore = new LeaderBoard<GameScore>(5, new GameScore("aaa", 0.1, false));

    System.out.println("before flushing");
    before = lbGameScore.toString();
    System.out.println(before);

    for (int i = 30; i > 0; i -= 1) {
      lbGameScore.add(new GameScore("NEW", i + 0.1, true));
    }
    System.out.println("after flushing ");
    after = lbGameScore.toString();
    System.out.println(after);

    valDouble = 5 + 0.1;
    valGameScore = new GameScore("LAST", valDouble, true);
    lbGameScore.add(valGameScore);
    System.out.println("after adding " + valGameScore.toString());
    after = lbGameScore.toString();
    System.out.println(after);

    expected = "1. NEW 30.1*\n" +
        "2. NEW 29.1*\n" +
        "3. NEW 28.1*\n" +
        "4. NEW 27.1*\n" +
        "5. NEW 26.1*\n";

    System.out.println(after.equals(expected));

  }

  public static void main(String[] args) {
    // there are a fair number of tests -- mostly split between different data
    // types, since you're building
    // something that's meant to be generic across multiple data types.
    // I recommend maybe only running one at a time at first -- then if you jsut
    // want to confirm you passed (rather
    // than use this to debug what's wrong) -- look for true at the end of each test
    // section.

    // integerTests();
    // doubleTests();
    // stringTests();
    gameScoreTests();
  }

}

/*
 * 
 * -------------------------------------
 * Test cases for INTEGER
 * Test 1
 * 
 * before adding
 * 1. 20
 * 2. 18
 * 3. 16
 * 4. 14
 * 5. 12
 * 
 * after adding 12
 * 1. 20
 * 2. 18
 * 3. 16
 * 4. 14
 * 5. 12
 * 
 * true
 * Test 2
 * 
 * before adding
 * 1. 20
 * 2. 18
 * 3. 16
 * 4. 14
 * 5. 12
 * 
 * after adding 13
 * 1. 20
 * 2. 18
 * 3. 16
 * 4. 14
 * 5. 13
 * 
 * true
 * Test 3
 * 
 * before adding
 * 1. 20
 * 2. 18
 * 3. 16
 * 4. 14
 * 5. 13
 * 
 * after adding 16
 * 1. 20
 * 2. 18
 * 3. 16
 * 4. 16
 * 5. 14
 * 
 * true
 * Test 4
 * 
 * before adding
 * 1. 20
 * 2. 18
 * 3. 16
 * 4. 16
 * 5. 14
 * 
 * after adding 21
 * 1. 21
 * 2. 20
 * 3. 18
 * 4. 16
 * 5. 16
 * 
 * true
 * Test 5
 * 
 * before adding
 * 1. 21
 * 2. 20
 * 3. 18
 * 4. 16
 * 5. 16
 * 
 * after adding 22
 * 1. 22
 * 2. 21
 * 3. 20
 * 4. 18
 * 5. 16
 * 
 * true
 * Test 6
 * 
 * before flushing
 * 1. 2
 * 2. 2
 * 3. 2
 * 4. 2
 * 5. 2
 * 
 * after flushing
 * 1. 30
 * 2. 29
 * 3. 28
 * 4. 27
 * 5. 26
 * 
 * after adding 5
 * 1. 30
 * 2. 29
 * 3. 28
 * 4. 27
 * 5. 26
 * 
 * true
 * -------------------------------------
 * Test cases for DOUBLE
 * Test 1
 * 
 * before adding
 * 1. 20.01
 * 2. 18.01
 * 3. 16.01
 * 4. 14.01
 * 5. 12.01
 * 
 * after adding 12.01
 * 1. 20.01
 * 2. 18.01
 * 3. 16.01
 * 4. 14.01
 * 5. 12.01
 * 
 * true
 * Test 2
 * 
 * before adding
 * 1. 20.01
 * 2. 18.01
 * 3. 16.01
 * 4. 14.01
 * 5. 12.01
 * 
 * after adding 13.01
 * 1. 20.01
 * 2. 18.01
 * 3. 16.01
 * 4. 14.01
 * 5. 13.01
 * 
 * true
 * Test 3
 * 
 * before adding
 * 1. 20.01
 * 2. 18.01
 * 3. 16.01
 * 4. 14.01
 * 5. 13.01
 * 
 * after adding 16.01
 * 1. 20.01
 * 2. 18.01
 * 3. 16.01
 * 4. 16.01
 * 5. 14.01
 * 
 * true
 * Test 4
 * 
 * before adding
 * 1. 20.01
 * 2. 18.01
 * 3. 16.01
 * 4. 16.01
 * 5. 14.01
 * 
 * after adding 21.01
 * 1. 21.01
 * 2. 20.01
 * 3. 18.01
 * 4. 16.01
 * 5. 16.01
 * 
 * true
 * Test 5
 * 
 * before adding
 * 1. 21.01
 * 2. 20.01
 * 3. 18.01
 * 4. 16.01
 * 5. 16.01
 * 
 * after adding 22.01
 * 1. 22.01
 * 2. 21.01
 * 3. 20.01
 * 4. 18.01
 * 5. 16.01
 * 
 * true
 * Test 6
 * 
 * before flushing
 * 1. 0.2
 * 2. 0.2
 * 3. 0.2
 * 4. 0.2
 * 5. 0.2
 * 
 * after flushing
 * 1. 30.1
 * 2. 29.1
 * 3. 28.1
 * 4. 27.1
 * 5. 26.1
 * 
 * after adding 5.1
 * 1. 30.1
 * 2. 29.1
 * 3. 28.1
 * 4. 27.1
 * 5. 26.1
 * 
 * true
 * -------------------------------------
 * Test cases for STRING
 * Test 1
 * 
 * before adding
 * 1. u
 * 2. s
 * 3. q
 * 4. o
 * 5. m
 * 
 * after adding m
 * 1. u
 * 2. s
 * 3. q
 * 4. o
 * 5. m
 * 
 * true
 * Test 2
 * 
 * before adding
 * 1. u
 * 2. s
 * 3. q
 * 4. o
 * 5. m
 * 
 * after adding mb
 * 1. u
 * 2. s
 * 3. q
 * 4. o
 * 5. mb
 * 
 * true
 * Test 3
 * 
 * before adding
 * 1. u
 * 2. s
 * 3. q
 * 4. o
 * 5. mb
 * 
 * after adding q
 * 1. u
 * 2. s
 * 3. q
 * 4. q
 * 5. o
 * 
 * true
 * Test 4
 * 
 * before adding
 * 1. u
 * 2. s
 * 3. q
 * 4. q
 * 5. o
 * 
 * after adding ubb
 * 1. ubb
 * 2. u
 * 3. s
 * 4. q
 * 5. q
 * 
 * true
 * Test 5
 * 
 * before adding
 * 1. ubb
 * 2. u
 * 3. s
 * 4. q
 * 5. q
 * 
 * after adding ubbd
 * 1. ubbd
 * 2. ubb
 * 3. u
 * 4. s
 * 5. q
 * 
 * true
 * Test 6
 * 
 * before flushing
 * 1. bbb
 * 2. bbb
 * 3. bbb
 * 4. bbb
 * 5. bbb
 * 
 * after flushing
 * 1. z
 * 2. y
 * 3. x
 * 4. w
 * 5. v
 * 
 * after adding ccc
 * 1. z
 * 2. y
 * 3. x
 * 4. w
 * 5. v
 * 
 * true
 * -------------------------------------
 * Test cases for GAMESCORE
 * Test 1
 * 
 * before adding
 * 1. DAK 20.01*
 * 2. DAK 18.01*
 * 3. DAK 16.01*
 * 4. DAK 14.01*
 * 5. DAK 12.01*
 * 
 * after adding KEV 12.01*
 * 1. DAK 20.01*
 * 2. DAK 18.01*
 * 3. DAK 16.01*
 * 4. DAK 14.01*
 * 5. DAK 12.01*
 * 
 * true
 * Test 2
 * 
 * before adding
 * 1. DAK 20.01*
 * 2. DAK 18.01*
 * 3. DAK 16.01*
 * 4. DAK 14.01*
 * 5. DAK 12.01*
 * 
 * after adding NEW 13.01*
 * 1. DAK 20.01*
 * 2. DAK 18.01*
 * 3. DAK 16.01*
 * 4. DAK 14.01*
 * 5. NEW 13.01*
 * 
 * true
 * Test 3
 * 
 * before adding
 * 1. DAK 20.01*
 * 2. DAK 18.01*
 * 3. DAK 16.01*
 * 4. DAK 14.01*
 * 5. NEW 13.01*
 * 
 * after adding NEW 16.01*
 * 1. DAK 20.01*
 * 2. DAK 18.01*
 * 3. DAK 16.01*
 * 4. NEW 16.01*
 * 5. DAK 14.01*
 * 
 * true
 * Test 4
 * 
 * before adding
 * 1. DAK 20.01*
 * 2. DAK 18.01*
 * 3. DAK 16.01*
 * 4. NEW 16.01*
 * 5. DAK 14.01*
 * 
 * after adding NEW 21.01*
 * 1. NEW 21.01*
 * 2. DAK 20.01*
 * 3. DAK 18.01*
 * 4. DAK 16.01*
 * 5. NEW 16.01*
 * 
 * true
 * Test 5
 * 
 * before adding
 * 1. NEW 21.01*
 * 2. DAK 20.01*
 * 3. DAK 18.01*
 * 4. DAK 16.01*
 * 5. NEW 16.01*
 * 
 * after adding NEW 22.01*
 * 1. NEW 22.01*
 * 2. NEW 21.01*
 * 3. DAK 20.01*
 * 4. DAK 18.01*
 * 5. DAK 16.01*
 * 
 * true
 * Test 6
 * 
 * before flushing
 * 1. aaa 0.1
 * 2. aaa 0.1
 * 3. aaa 0.1
 * 4. aaa 0.1
 * 5. aaa 0.1
 * 
 * after flushing
 * 1. NEW 30.1*
 * 2. NEW 29.1*
 * 3. NEW 28.1*
 * 4. NEW 27.1*
 * 5. NEW 26.1*
 * 
 * after adding LAST 5.1*
 * 1. NEW 30.1*
 * 2. NEW 29.1*
 * 3. NEW 28.1*
 * 4. NEW 27.1*
 * 5. NEW 26.1*
 * 
 * true
 * 
 */
