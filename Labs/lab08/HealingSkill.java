public class HealingSkill extends Skill {
    public HealingSkill(String name, int strength, int usageLimit) {
        super(name, strength, usageLimit);
    }

    @Override
    public void applyChanges(CodeMonster me, CodeMonster foe) {
        me.adjustHealth(getStrength());
    }
}
