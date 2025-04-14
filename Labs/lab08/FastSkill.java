// Name: Qiming Lyu

/**
 * `FastSkill` is a child-class of the Skill class.
 * It can be used in no time at all. This is done by
 * subtracting `speedScore` from `nextTurnTime`.
 */
public class FastSkill extends Skill {
    public FastSkill(String name, int strength, int usageLimit) {
        super(name, strength, usageLimit);
    }

    public void applyChanges(CodeMonster me, CodeMonster foe) {
        foe.adjustHealth(-getStrength());
        me.setNextTurnTime(me.getNextTurnTime() - me.getSpeedScore());
    }
}
