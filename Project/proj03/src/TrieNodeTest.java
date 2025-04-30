public class TrieNodeTest {
    public static void main(String[] args) {
        TrieNode<Double> tn = new TrieNode<>();
        System.out.println(tn.getData() == null); // true

        tn.setData(4.5);
        System.out.println(tn.getData() == 4.5); // true


        tn.setData(4.54e5);
        System.out.println(tn.getData() == 4.54e5); // true

        System.out.println(tn.getTreeSize()); // 1
        // (until we call getChild treeSize should stay at 1 (itself)).

        TrieNode<Double> an = tn.getChild('a');
        System.out.println(tn.getTreeSize()); // 2
        // calling getChild should add a child for a

        TrieNode<Double> bn = tn.getChild('b');
        System.out.println(tn.getTreeSize()); // 3

        System.out.println(tn.getChild('a') == an); // true
        System.out.println(tn.getChild('b') == bn); // true
        System.out.println(tn.getChild('a') == bn); // false
        System.out.println(tn.getChild('b') == an); // false
        System.out.println(tn.getTreeSize()); // 3

        an.getChild('b');
        // this should add 1 to the tree as an sees it
        // as well as 1 to the tree as the root node (tn) sees it.
        System.out.println(an.getTreeSize()); // 2
        System.out.println(bn.getTreeSize()); // 1
        System.out.println(tn.getTreeSize()); // 4
    }
}
/*
true
true
true
1
2
3
true
true
false
false
3
2
1
4
 */