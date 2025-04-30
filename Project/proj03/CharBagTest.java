public class CharBagTest {
    public static void main(String[] args) {
        //////////////////////////
        // test initial conditions
        //////////////////////////
        CharBag cb = new CharBag();
        for (char c = 'a'; c <= 'z'; c++) {
            if (cb.getCount(c) != 0) {
                System.out.println("Test failed -- empty CharBag has something in it!");
            }
        }
        if (cb.getCount(LetterSample.STOP) != 0) {
            System.out.println("Test failed -- empty CharBag has something in it!");
        }
        System.out.println(cb.getSize()); // 0
        for (int i = 0; i < 100; i++) {
            if (cb.getRandomChar() != LetterSample.STOP) {
                System.out.println("Test failed -- an empty charBag should only randomly generate '.'");
            }
        }

        //////////////////////
        // one letter added in
        //////////////////////
        cb.add('a');
        System.out.println(cb.getCount('a')); // 1
        System.out.println(cb.getSize()); // 1
        for (char c = 'b'; c <= 'z'; c++) {
            if (cb.getCount(c) != 0) {
                System.out.println("Test failed -- CharBag should only have 'a' in it!");
            }
        }
        for (int i = 0; i < 100; i++) {
            if (cb.getRandomChar() != 'a') {
                System.out.println("Test failed -- charBag should only randomly generate 'a'");
            }
        }

        //////////////////
        // empty it again.
        //////////////////
        cb.remove('a');
        for (char c = 'a'; c <= 'z'; c++) {
            if (cb.getCount(c) != 0) {
                System.out.println("Test failed -- empty CharBag has something in it!");
            }
        }
        if (cb.getCount(LetterSample.STOP) != 0) {
            System.out.println("Test failed -- empty CharBag has something in it!");
        }
        System.out.println(cb.getSize()); // 0
        for (int i = 0; i < 100; i++) {
            if (cb.getRandomChar() != LetterSample.STOP) {
                System.out.println("Test failed -- an empty charBag should only randomly generate '.'");
            }
        }

        ////////////////////////////////////////////////////////////////////
        // now lets get serious. add a bunch in with no particular order
        // (I literally just mashed the keyboard, hand counting that sucked)
        ////////////////////////////////////////////////////////////////////
        String toAdd = "qawsedfrtghyujloqawsedfrtghyujkolqawsedfrtguyhjlop";
        for (int i = 0; i < toAdd.length(); i++) {
            cb.add(toAdd.charAt(i));
        }

        /////////////////////////////////
        // start testing toString as well
        /////////////////////////////////

        System.out.println(cb);
        // CharBag{a:3, b:0, c:0, d:3, e:3, f:3, g:3, h:3, i:0, j:3, k:1, l:3, m:0, n:0, o:3, p:1, q:3, r:3, s:3, t:3, u:3, v:0, w:3, x:0, y:3, z:0, .:0}
        System.out.println(cb.getSize()); //50

        /////////////////////////////////////////////////////////////
        // test remove, note I'm also removing things not in the bag.
        /////////////////////////////////////////////////////////////
        for (char c = 'a'; c <= 'z'; c++) {
            cb.remove(c);
        }
        System.out.println(cb);
        // CharBag{a:2, b:0, c:0, d:2, e:2, f:2, g:2, h:2, i:0, j:2, k:0, l:2, m:0, n:0, o:2, p:0, q:2, r:2, s:2, t:2, u:2, v:0, w:2, x:0, y:2, z:0, .:0}
        System.out.println(cb.getSize()); //32

        ///////////////
        // empty it out
        ///////////////
        for (char c = 'a'; c <= 'z'; c++) {
            cb.remove(c);
            cb.remove(c);
        }
        System.out.println(cb.getSize()); // 0

        ///////////////////////////////////////////
        // test that invalid letters all map to '.'
        ///////////////////////////////////////////
        toAdd = "`1234567890-=~!@#$%^&*()_+[]{}\\|;:'\".,/<>? \t\n";
        for (int i = 0; i < toAdd.length(); i++) {
            cb.add(toAdd.charAt(i));
        }
        System.out.println(cb.getSize()); // 45
        System.out.println(cb.getCount(LetterSample.STOP)); // 45
        System.out.println(cb.getCount('@')); // 45

        /////////////////////
        // empty it out again
        /////////////////////
        for (int i = 0; i < 50; i++) {
            cb.remove('$');
        }
        System.out.println(cb.getSize()); // 0

        ////////////
        // test caps
        ////////////
        cb.add('A');
        cb.add('B');
        System.out.println(cb);
        // CharBag{a:1, b:1, c:0, d:0, e:0, f:0, g:0, h:0, i:0, j:0, k:0, l:0, m:0, n:0, o:0, p:0, q:0, r:0, s:0, t:0, u:0, v:0, w:0, x:0, y:0, z:0, .:0}


        ////////////////////////////////
        // test random letter generation
        ////////////////////////////////
        int a = 0;
        int b = 0;
        for (int i = 0; i < 10000; i++) {
            char c = cb.getRandomChar();
            if (c == 'a') {
                a++;
            } else if (c == 'b') {
                b++;
            } else {
                System.out.println("Test failed, a CharBag with only a and b generated a not a/b value");
            }
        }
        System.out.println(a + ", " + b);
        // random, being the way it is, means that we can't predict the exact values here. But, they should be close to each other.
        // however, if I did my math right then 95% of the time a and b should be between 5098 and 4902 (inclusive)
        // run this a few times, if your mostly in these bounds you're fine.

        // shift the proportions
        cb.add('a');
        cb.add('a');
        cb.add('b');

        a = 0;
        b = 0;
        for (int i = 0; i < 10000; i++) {
            char c = cb.getRandomChar();
            if (c == 'a') {
                a++;
            } else if (c == 'b') {
                b++;
            } else {
                System.out.println("Test failed, a CharBag with only a and b generated a not a/b value");
            }
        }
        System.out.println(a + ", " + b);
        // random, being the way it is, means that we can't predict the exact values here. But, they should be close to each other.
        // however, if I did my math right then 95% of the time a should be between 6096 and 5904 (inclusive) and
        // b should be between 3904 and 4096
        // run this a few times, if your mostly in these bounds you're fine.
    }
}

/* Your results on the last two may vary.
0
1
1
0
CharBag{a:3, b:0, c:0, d:3, e:3, f:3, g:3, h:3, i:0, j:3, k:1, l:3, m:0, n:0, o:3, p:1, q:3, r:3, s:3, t:3, u:3, v:0, w:3, x:0, y:3, z:0, .:0}
50
CharBag{a:2, b:0, c:0, d:2, e:2, f:2, g:2, h:2, i:0, j:2, k:0, l:2, m:0, n:0, o:2, p:0, q:2, r:2, s:2, t:2, u:2, v:0, w:2, x:0, y:2, z:0, .:0}
32
0
45
45
45
0
CharBag{a:1, b:1, c:0, d:0, e:0, f:0, g:0, h:0, i:0, j:0, k:0, l:0, m:0, n:0, o:0, p:0, q:0, r:0, s:0, t:0, u:0, v:0, w:0, x:0, y:0, z:0, .:0}
4936, 5064 <this number shouldn't match exactly>
5869, 4131 <this number shouldn't match exactly>

 */