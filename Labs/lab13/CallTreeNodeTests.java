public class CallTreeNodeTests {
    public static void main(String[] args) {
        CallTreeNode ctn1 = new CallTreeNode("Coffee", null, null);
        CallTreeNode ctn2 = new CallTreeNode("Flute", null, null);
        CallTreeNode ctn3 = new CallTreeNode("Ready", null, null);
        CallTreeNode ctn4 = new CallTreeNode("Magic", ctn1, ctn2);
        CallTreeNode ctn5 = new CallTreeNode("Cookies", ctn3, null);
        CallTreeNode ctn6 = new CallTreeNode("Roast", null, null);

        System.out.println("Coffee".equals(ctn1.getName())); // true
        System.out.println("Cookies".equals(ctn5.getName())); // true

        System.out.println(null == ctn2.getFirst()); // true
        System.out.println(null == ctn3.getSecond()); // true
        System.out.println(ctn3 == ctn5.getFirst()); // true
        System.out.println(ctn2 == ctn4.getSecond()); // true

        System.out.println(ctn1.isCaller()); // false
        System.out.println(ctn6.isCaller()); // false

        System.out.println(ctn4.isCaller()); // true
        System.out.println(ctn5.isCaller()); // true

        System.out.println(null == ctn6.getFirst()); // true
        System.out.println(null == ctn6.getSecond()); // true
        ctn6.setFirst(ctn4);
        ctn6.setSecond(ctn5);

        System.out.println(ctn6.isCaller()); // true

        System.out.println(ctn4 == ctn6.getFirst()); // true
        System.out.println(ctn5 == ctn6.getSecond()); // true

    }
}
/*

true
true
true
true
true
true
false
false
true
true
true
true
true
true
true

 */
