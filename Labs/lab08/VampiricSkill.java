// Name: Qiming Lyu

/**
 * The `VampiricSkill` is a child-class of `Skill`.
 * It hurts the opponent while healing the user.
 */
public class VampiricSkill extends Skill {
    public VampiricSkill(String name, int strength, int usageLimit) {
        super(name, strength, usageLimit);
    }

    public void applyChanges(CodeMonster me, CodeMonster foe) {
        foe.adjustHealth(-getStrength());
        me.adjustHealth(getStrength());
    }
}
