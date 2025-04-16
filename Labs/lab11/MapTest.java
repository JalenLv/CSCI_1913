
//  Tests for CSci 1913
//  Original version: James Moen
//  With Edits by Daniel Kluver and Mark Nie
//

public class MapTest {

//  MAIN. Make an instance of MAP and test it.

    public static void main(String[] args) {
        Map<String, String> hogwarts;
        hogwarts = new Map<String, String>(5);

        System.out.println(hogwarts.size());                    //  0             2 point

        hogwarts.put("Harry", "Ginny");
        hogwarts.put("Ron", "Lavender");
        hogwarts.put("Voldemort", null);
        hogwarts.put(null, "Wormtail");
        System.out.println(hogwarts.size());                    //  4             2 point

        System.out.println(hogwarts.containsKey("Harry"));      //  true          1 points.
        System.out.println(hogwarts.containsKey("Ginny"));      //  false         1 points.
        System.out.println(hogwarts.containsKey("Ron"));        //  true          1 points.
        System.out.println(hogwarts.containsKey("Voldemort"));  //  true          1 points.
        System.out.println(hogwarts.containsKey(null));         //  true          1 points.
        System.out.println(hogwarts.containsKey("Joanne"));     //  false         1 points.

        System.out.println(hogwarts.get("Harry"));              //  Ginny         2 points.
        System.out.println(hogwarts.get("Ron"));                //  Lavender      2 points.
        System.out.println(hogwarts.get("Voldemort"));          //  null          2 points.
        System.out.println(hogwarts.get(null));                 //  Wormtail      2 points.
        System.out.println(hogwarts.get("Joanne"));             //  null          2 points.

        hogwarts.put("Ron", "Hermione");
        hogwarts.put("Albus", "Gellert");
        hogwarts.put(null, null);
        System.out.println(hogwarts.size());                     //  5            2 point


        System.out.println(hogwarts.containsKey(null));         //  true          1 points.
        System.out.println(hogwarts.containsKey("Albus"));      //  true          1 points.
        System.out.println(hogwarts.containsKey("Hermione"));   //  false         1 points.

        System.out.println(hogwarts.get("Albus"));              //  Gellert       1 points.
        System.out.println(hogwarts.get("Harry"));              //  Ginny         1 points.
        System.out.println(hogwarts.get("Ron"));                //  Hermione      1 points.
        System.out.println(hogwarts.get("Voldemort"));          //  null          1 points.
        System.out.println(hogwarts.get(null));                 //  null          1 points.


        // Testing generics support and array doubling
        // Weasley's Wizard Wheezes Candy List With Prices
        Map<String, Integer> weasleys = new Map<>(0);
        weasleys.put("Love Potion", 10);
        System.out.println(weasleys.size());                    //  1            2 point
        weasleys.put("U-No-Poo", 7);
        System.out.println(weasleys.size());                    //  2            2 point
        weasleys.put("Fever Fudge", 6);
        weasleys.put("Nosebleed Nougat", 8);
        weasleys.put("Skiving Snackboxes", 40);
        System.out.println(weasleys.size());                    //  5            2 point

        // A map whose key is a customized class
        Map<Point, Integer> pointMap = new Map<>(1);
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 1);
        Point p2_dup = new Point(2, 1);
        Point p3 = new Point(4, 5);

        pointMap.put(p1, 2);
        pointMap.put(p2, 7);
        pointMap.put(p2_dup, 10);
        System.out.println(pointMap.get(p1));                   //  2            2 point
        System.out.println(pointMap.get(p2));                   //  10           2 point
        System.out.println(pointMap.containsKey(p1));           //  true         2 points.
        System.out.println(pointMap.containsKey(p3));           //  false        2 points.
        System.out.println(pointMap.size());                    //  2            2 points.
        pointMap.put(p3, 9);
        pointMap.put(null, 11);
        System.out.println(pointMap.get(null));                 //  11           2 points.


    }

}

/*
0
4
true
false
true
true
true
false
Ginny
Lavender
null
Wormtail
null
5
true
true
false
Gellert
Ginny
Hermione
null
null
1
2
5
2
10
true
false
2
11
 */