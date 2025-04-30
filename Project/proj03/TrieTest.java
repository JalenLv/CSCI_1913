public class TrieTest {
    public static void main(String[] args) {
        // This class is a bit harder to test. There's a lot of how it behaves _internally_
        // that we care about, but which is hard to really expose for testing. I don't think
        // I have an easy way to help you test that unfortunately.

        Trie<Integer> numbers = new Trie<>();
        System.out.println(numbers.get("one") == null); // true

        numbers.put("one", 1);
        System.out.println(numbers.get("one")); // 1
        // (remember the root represents "", then it should have "o" as a child, then "on" etc.)

        System.out.println(numbers.get("two") == null); // true

        numbers.put("two", 2);
        System.out.println(numbers.get("two")); // 2

        System.out.println(numbers.get("ten") == null); // true

        numbers.put("ten", 10);
        System.out.println(numbers.get("ten")); // 10
    }
}
/*

true
1
true
2
true
10

 */