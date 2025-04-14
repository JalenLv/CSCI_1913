public class CodeMonsterTester {
    public static void main(String[] args) {
        // test for basic constructor -- getter relationships
        Skill sk1 = new Skill("tarpit", 10, 3);
        Skill[] ska1 = new Skill[]{sk1};
        CodeMonster cm1 = new CodeMonster(103, 10.3, "BF", ska1);
        Skill sk2 = new Skill("for loop", 3, 10);
        Skill[] ska2 = new Skill[]{sk2};
        CodeMonster cm2 = new CodeMonster(14, 1, "C++", ska2);

        System.out.println(cm1.getMaxHp());              // 103
        System.out.println(cm1.getSpeedScore());         // 10.3
        System.out.println(cm1.getName());               // BF
        System.out.println(ska1 == cm1.getMoves());      // true

        System.out.println(cm2.getMaxHp());              // 14
        System.out.println(cm2.getSpeedScore());         // 1.0
        System.out.println(cm2.getName());               // C++
        System.out.println(ska2 == cm2.getMoves());      // true

        // test toString
        System.out.println("before call");               // before call
        String cm1s = cm1.toString();
        String cm2s = cm2.toString();
        System.out.println("after call");                // after call
        System.out.println(cm1s);                        // BF 103/103
        System.out.println(cm2s);                        // C++ 14/14

        // test prep for battle initial values...
        sk1 = new Skill("tarpit", 10, 3);
        // use the skill to get a useage out -- this should be reset later.
        sk1.useSkill(cm1, cm2);
        System.out.println(sk1.getUsageLeft());          // 2
        ska1 = new Skill[]{sk1};
        cm1 = new CodeMonster(103, 10.3, "BF", ska1);
        cm1.prepForBattle();
        System.out.println(cm1.getHp());                 // 103
        System.out.println(cm1.isAlive());               // true
        System.out.println(cm1.getNextTurnTime());       // 10.3
        System.out.println(sk1.getUsageLeft());          // 3

        // Test HP management code.
        sk1 = new Skill("tarpit", 10, 3);
        ska1 = new Skill[]{sk1};
        cm1 = new CodeMonster(103, 10.3, "BF", ska1);
        cm1.prepForBattle();
        System.out.println(cm1.getHp());                 // 103
        System.out.println(cm1.isAlive());               // true
        cm1.adjustHealth(-10);
        System.out.println(cm1.getHp());                 // 93
        System.out.println(cm1.isAlive());               // true
        cm1.adjustHealth(-10);
        System.out.println(cm1.getHp());                 // 83
        System.out.println(cm1.isAlive());               // true
        cm1.adjustHealth(-30);
        System.out.println(cm1.getHp());                 // 53
        System.out.println(cm1.isAlive());               // true
        cm1.adjustHealth(-100);
        System.out.println(cm1.getHp());                 // 0
        System.out.println(cm1.isAlive());               // false
        cm1.adjustHealth(60);
        System.out.println(cm1.getHp());                 // 60
        System.out.println(cm1.isAlive());               // true
        cm1.adjustHealth(60);
        System.out.println(cm1.getHp());                 // 103
        System.out.println(cm1.isAlive());               // true
        cm1.adjustHealth(-100);
        System.out.println(cm1.getHp());                 // 3
        System.out.println(cm1.isAlive());               // true
        cm1.prepForBattle(); // should reset health
        System.out.println(cm1.getHp());                 // 103
        System.out.println(cm1.isAlive());               // true


        // Test nextTurnTime management
        sk1 = new Skill("tarpit", 10, 3);
        ska1 = new Skill[]{sk1};
        cm1 = new CodeMonster(103, 10.3, "BF", ska1);
        cm1.prepForBattle();
        System.out.println(cm1.getNextTurnTime());       // 10.3
        cm1.setNextTurnTime(13.42);
        System.out.println(cm1.getNextTurnTime());       // 13.42
        cm1.setNextTurnTime(10.02);
        System.out.println(cm1.getNextTurnTime());       // 10.02
        cm1.setNextTurnTime(42.02);
        System.out.println(cm1.getNextTurnTime());       // 42.02

        // test takeTurn behaviors (rotate through skills, and adjust turn time)
        sk1 = new Skill("tarpit", 10, 3);
        sk2 = new Skill("esoteric", 1, 300);
        Skill sk3 = new Skill("[]", 2, 100);
        ska1 = new Skill[]{sk1, sk2, sk3};
        cm1 = new CodeMonster(103, 10.3, "BF", ska1);
        cm1.prepForBattle();
        System.out.println(cm1.getNextTurnTime());       // 10.3

        Skill ret = cm1.takeTurn();
        System.out.println(cm1.getNextTurnTime());       // 20.6
        System.out.println(ret == sk1);                  // true

        ret = cm1.takeTurn();
        System.out.println(cm1.getNextTurnTime());       // 30.9 (note -- might actually show 30.900000000000002
        System.out.println(ret == sk2);                  // true

        ret = cm1.takeTurn();
        System.out.println(cm1.getNextTurnTime());       // 41.2
        System.out.println(ret == sk3);                  // true

        ret = cm1.takeTurn();
        System.out.println(cm1.getNextTurnTime());       // 51.5
        System.out.println(ret == sk1);                  // true

        ret = cm1.takeTurn();
        System.out.println(cm1.getNextTurnTime());       // 61.8
        System.out.println(ret == sk2);                  // true
    }
}


/*


103
10.3
BF
true
14
1.0
C++
true
before call
after call
BF 103/103
C++ 14/14
2
103
true
10.3
3
103
true
93
true
83
true
53
true
0
false
60
true
103
true
3
true
103
true
10.3
13.42
10.02
42.02
10.3
20.6
true
30.9
true
41.2
true
51.5
true
61.8
true


 */