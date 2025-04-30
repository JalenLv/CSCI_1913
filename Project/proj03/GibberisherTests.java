import java.util.Set;
import java.util.TreeSet;

public class GibberisherTests {
    public static void main(String[] args) {
        // The purpose of this file is to do some **very** basic tests of the giberisher.

        // Test 1: is it counting segments right.
        Gibberisher gb = new Gibberisher(4);
        gb.train(new String[]{"apple", "dog", "november", "december"});
        System.out.println(gb.getSampleCount()); // 28
        // train should be callable more than once!
        gb.train(new String[]{"quest"});
        System.out.println(gb.getSampleCount()); // 34

        // Test 2: If we were to run the gibberisher right now, since it's only seen those words it should just
        // repeat them back. you have to train with A LOT of words to get useful behavior.

        Set<String> uniqueWords = new TreeSet<>();
        // we're using this  for testing -- remember -- you are not allowed the set or TreeSet classes!
        for(int i = 0; i < 200; i++) {
            uniqueWords.add(gb.generate());
        }
        System.out.println(uniqueWords); // [apple, december, dog, november, quest]


        // Test 3: If we feed very deliberate words in, we can get some very deliberate words out.
        gb = new Gibberisher(2);
        gb.train(new String[]{"abcdef", "defhijk"});
        uniqueWords = new TreeSet<>();
        for(int i = 0; i < 200; i++) {
            uniqueWords.add(gb.generate());
        }
        // because of the overlap of "def" in both words we can generate 4 options
        System.out.println(uniqueWords); //[abcdef, abcdefhijk, def, defhijk]
    }
}

/*

28
34
[apple, december, dog, november, quest]
[abcdef, abcdefhijk, def, defhijk]

 */