public class MoreSkillsTester {
    public static void main(String[] args) {
        FastSkill fast = new FastSkill("Compile", 6, 10);
        HealingSkill heal = new HealingSkill("strong type", 6, 100);
        VampiricSkill vamp = new VampiricSkill("memory leak", 3, 19);

        // this is a particularly obscure way to check if a class extends another class
        // The biggest value here is that this version will still compile if inheritance
        // is
        // setup wrong.
        System.out.println(Skill.class.isInstance(fast)); // true
        System.out.println(Skill.class.isInstance(heal)); // true
        System.out.println(Skill.class.isInstance(vamp)); // true

        CodeMonster cm1 = new CodeMonster(100, 10, "dummy1", new Skill[0]);
        CodeMonster cm2 = new CodeMonster(100, 10, "dummy2", new Skill[0]);
        // set everything up!
        cm1.prepForBattle();
        cm2.prepForBattle();
        cm1.adjustHealth(-50);
        cm2.adjustHealth(-50);

        System.out.println(cm1.getHp()); // 50
        System.out.println(cm2.getHp()); // 50
        heal.applyChanges(cm1, cm2);
        System.out.println(cm1.getHp()); // 56
        System.out.println(cm2.getHp()); // 50
        heal.applyChanges(cm1, cm2);
        System.out.println(cm1.getHp()); // 62
        System.out.println(cm2.getHp()); // 50

        // reset everything!
        cm1.prepForBattle();
        cm2.prepForBattle();
        cm1.adjustHealth(-50);
        cm2.adjustHealth(-50);

        System.out.println(cm1.getHp()); // 50
        System.out.println(cm2.getHp()); // 50
        vamp.applyChanges(cm1, cm2);
        System.out.println(cm1.getHp()); // 53
        System.out.println(cm2.getHp()); // 47
        vamp.applyChanges(cm1, cm2);
        System.out.println(cm1.getHp()); // 56
        System.out.println(cm2.getHp()); // 44

        // re everything!
        cm1.prepForBattle();
        cm2.prepForBattle();
        cm1.adjustHealth(-50);
        cm2.adjustHealth(-50);

        System.out.println(cm1.getHp()); // 50
        System.out.println(cm1.getNextTurnTime()); // 10.0
        System.out.println(cm2.getHp()); // 50
        System.out.println(cm2.getNextTurnTime()); // 10.0
        fast.applyChanges(cm1, cm2);
        System.out.println(cm1.getHp()); // 50
        System.out.println(cm1.getNextTurnTime()); // 0.0
        System.out.println(cm2.getHp()); // 44
        System.out.println(cm2.getNextTurnTime()); // 10
        fast.applyChanges(cm1, cm2);
        System.out.println(cm1.getHp()); // 50
        System.out.println(cm1.getNextTurnTime()); // -10
        System.out.println(cm2.getHp()); // 38
        System.out.println(cm2.getNextTurnTime()); // 10.0
    }

}

/*
 * 
 * true
 * true
 * true
 * 50
 * 50
 * 56
 * 50
 * 62
 * 50
 * 50
 * 50
 * 53
 * 47
 * 56
 * 44
 * 50
 * 10.0
 * 50
 * 10.0
 * 50
 * 0.0
 * 44
 * 10.0
 * 50
 * -10.0
 * 38
 * 10.0
 * 
 * 
 */
