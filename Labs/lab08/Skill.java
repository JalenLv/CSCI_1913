// Name: Qiming Lyu

/**
 * The `Skill` class represents one action a `CodeMonster` can take in battle.
 *
 * A `Skill` object has 4 private attributes:
 * - a name,
 * - a strength that represents how much damage it will do.
 * - a pair of ints, where one represents the number
 * of times the skill can be used in a battle,
 * and the other represents the number of times
 * the skill can still be used in the battle.
 */
public class Skill {
    private String name;
    private int strength;
    private int usageLimit;
    private int usageLeft;

    /**
     * Constructs a new `Skill` object with the given name, strength, and usage
     * limit.
     *
     * @param name       the name of the skill
     * @param strength   the strength of the skill
     * @param usageLimit the number of times the skill can be used in a battle
     */
    public Skill(String name, int strength, int usageLimit) {
        this.name = name;
        this.strength = strength;
        this.usageLimit = usageLimit;
        this.usageLeft = usageLimit;
    }

    /**
     * Returns the name of the skill.
     */
    public String getName() {
        return name;
    }

    /**
     * Resets the number of times the skill can be used in a battle to the
     * usageLimit.
     */
    public void refresh() {
        usageLeft = usageLimit;
    }

    /**
     * Returns the strength of the skill.
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Returns the number of times the skill can be used in a battle.
     */
    public int getUsageLimit() {
        return usageLimit;
    }

    /**
     * Returns the number of times the skill can still be used in the battle.
     */
    public int getUsageLeft() {
        return usageLeft;
    }

    /**
     * Uses the skill on the given `CodeMonster` objects.
     *
     * If the skill can still be used, the skill will be used on the `foe`.
     * The number of times the skill can be used will be decremented by 1.
     * The `applyChanges` method will be called to apply the changes to the `foe`.
     * If the skill cannot be used, nothing will happen.
     *
     * @param me  the `CodeMonster` using the skill
     * @param foe the `CodeMonster` the skill is being used on
     */
    public void useSkill(CodeMonster me, CodeMonster foe) {
        if (usageLeft > 0) {
            applyChanges(me, foe);
            usageLeft--;
        }
    }

    public void applyChanges(CodeMonster me, CodeMonster foe) {
        foe.adjustHealth(-strength);
    }

    /**
     * Returns a string representation of the skill in the format:
     * "{name} {usageLeft}/{usageLimit}".
     */
    public String toString() {
        return String.format("%s %d/%d", name, usageLeft, usageLimit);
    }
}
