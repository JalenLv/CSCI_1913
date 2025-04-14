public class SkillTester {
    public static void main(String[] args) {
        // Test constructor and getters
        Skill sk1 = new Skill("recursion", 100, 13);
        Skill sk2 = new Skill("iteration", 10, 103);

        System.out.println(sk1.getName()); // recursion
        System.out.println(sk1.getStrength()); // 100
        System.out.println(sk1.getUsageLimit()); // 13
        System.out.println(sk1.getUsageLeft()); // 13

        System.out.println(sk2.getName()); // iteration
        System.out.println(sk2.getStrength()); // 10
        System.out.println(sk2.getUsageLimit()); // 103
        System.out.println(sk2.getUsageLeft()); // 103

        // Test toString
        System.out.println("before call"); // before call
        String sk1s = sk1.toString();
        String sk2s = sk2.toString();
        System.out.println("after call"); // after call
        System.out.println(sk1s); // recursion 13/13
        System.out.println(sk2s); // iteration 103/103

        // test applyChanges
        sk1 = new Skill("recursion", 15, 13);
        sk2 = new Skill("iteration", 10, 103);

        Skill[] ska1 = new Skill[] { sk1 };
        CodeMonster cm1 = new CodeMonster(103, 10.3, "Scheme", ska1);
        Skill[] ska2 = new Skill[] { sk2 };
        CodeMonster cm2 = new CodeMonster(140, 1, "Pearl", ska2);
        cm1.prepForBattle();
        cm2.prepForBattle();
        System.out.println(cm1.getHp()); // 103
        System.out.println(cm2.getHp()); // 140
        sk1.applyChanges(cm1, cm2);
        System.out.println(cm1.getHp()); // 103
        System.out.println(cm2.getHp()); // 125
        sk2.applyChanges(cm2, cm1);
        System.out.println(cm1.getHp()); // 93
        System.out.println(cm2.getHp()); // 125
        sk1.applyChanges(cm1, cm2);
        System.out.println(cm1.getHp()); // 93
        System.out.println(cm2.getHp()); // 110

        // test useSkill basic
        sk1 = new Skill("recursion", 15, 13);
        sk2 = new Skill("iteration", 10, 103);
        ska1 = new Skill[] { sk1 };
        cm1 = new CodeMonster(103, 10.3, "Scheme", ska1);
        ska2 = new Skill[] { sk2 };
        cm2 = new CodeMonster(140, 1, "Pearl", ska2);
        cm1.prepForBattle();
        cm2.prepForBattle();
        System.out.println(sk1.getUsageLeft()); // 13
        System.out.println(sk2.getUsageLeft()); // 103
        System.out.println(cm1.getHp()); // 103
        System.out.println(cm2.getHp()); // 140
        sk1.useSkill(cm1, cm2);
        System.out.println(sk1.getUsageLeft()); // 12
        System.out.println(sk2.getUsageLeft()); // 103
        System.out.println(cm1.getHp()); // 103
        System.out.println(cm2.getHp()); // 125
        sk2.useSkill(cm2, cm1);
        System.out.println(sk1.getUsageLeft()); // 12
        System.out.println(sk2.getUsageLeft()); // 102
        System.out.println(cm1.getHp()); // 93
        System.out.println(cm2.getHp()); // 125
        sk1.useSkill(cm1, cm2);
        System.out.println(sk1.getUsageLeft()); // 11
        System.out.println(sk2.getUsageLeft()); // 101
        System.out.println(cm1.getHp()); // 93
        System.out.println(cm2.getHp()); // 110

        // test useSkill and usageLimit and refresh
        sk1 = new Skill("recursion", 5, 3);
        sk2 = new Skill("iteration", 10, 10);
        ska1 = new Skill[] { sk1 };
        cm1 = new CodeMonster(103, 10.3, "Scheme", ska1);
        ska2 = new Skill[] { sk2 };
        cm2 = new CodeMonster(140, 1, "Pearl", ska2);
        cm1.prepForBattle();
        cm2.prepForBattle();
        System.out.println(sk1.getUsageLeft()); // 3
        System.out.println(cm2.getHp()); // 140

        sk1.useSkill(cm1, cm2);
        System.out.println(sk1.getUsageLeft()); // 2
        System.out.println(cm2.getHp()); // 135

        sk1.useSkill(cm1, cm2);
        System.out.println(sk1.getUsageLeft()); // 1
        System.out.println(cm2.getHp()); // 130

        sk1.useSkill(cm1, cm2);
        System.out.println(sk1.getUsageLeft()); // 0
        System.out.println(cm2.getHp()); // 125

        sk1.useSkill(cm1, cm2);
        System.out.println(sk1.getUsageLeft()); // 0
        System.out.println(cm2.getHp()); // 125

        sk1.useSkill(cm1, cm2);
        System.out.println(sk1.getUsageLeft()); // 0
        System.out.println(cm2.getHp()); // 125

        sk1.refresh();

        System.out.println(sk1.getUsageLeft()); // 3
        sk1.useSkill(cm1, cm2);
        System.out.println(sk1.getUsageLeft()); // 2
        System.out.println(cm2.getHp()); // 120
    }
}

/*
 * 
 * 
 * recursion
 * 100
 * 13
 * 13
 * iteration
 * 10
 * 103
 * 103
 * before call
 * after call
 * recursion 13/13
 * iteration 103/103
 * 103
 * 140
 * 103
 * 125
 * 93
 * 125
 * 93
 * 110
 * 13
 * 103
 * 103
 * 140
 * 12
 * 103
 * 103
 * 125
 * 12
 * 102
 * 93
 * 125
 * 11
 * 102
 * 93
 * 110
 * 3
 * 140
 * 2
 * 135
 * 1
 * 130
 * 0
 * 125
 * 0
 * 125
 * 0
 * 125
 * 3
 * 2
 * 120
 * 
 */
