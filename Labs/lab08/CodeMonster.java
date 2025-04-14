// Name: Qiming Lyu

/**
 * The CodeMonster class represents a single code monster in our game.
 *
 * A `CodeMonster` object has 7 private attributes:
 * - the name,
 * - current and maximum HP,
 * - a `Skill` array `moves` the CodeMonster can use,
 * - an integer `moveIndex` tracking which moves the monster used recently,
 * - a pair of double values (`speedScore` and `nextTurnTime`) that track how
 * fast the monster is, and when it will take it's next turn.
 */
public class CodeMonster {
    private String name;
    private int maxHp, currentHp;
    private Skill[] moves;
    private int moveIndex;
    private double speedScore, nextTurnTime;

    /**
     * Constructs a new `CodeMonster` object with the given max HP, speed score,
     * name, and moves.
     * current HP is set to max HP, and next turn time is set to speed score.
     */
    public CodeMonster(int maxHp, double speedScore, String name, Skill[] moves) {
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.speedScore = speedScore;
        this.nextTurnTime = speedScore;
        this.name = name;
        this.moves = moves;
    }

    /**
     * This function will be called before a new battle.
     * It should reset private variables for a new battle.
     */
    public void prepForBattle() {
        currentHp = maxHp;
        nextTurnTime = speedScore;
        moveIndex = 0;
        for (Skill move : moves) {
            move.refresh();
        }
    }

    /**
     * This function will be called be the battle code when it's this codeMonster's
     * turn to use a skill.
     *
     * This function performs two tasks:
     * - updating the `nextTurnTime`,
     * - choosing which skill to use.
     */
    public Skill takeTurn() {
        // update the next turn time
        nextTurnTime += speedScore;

        // choose which skill to use
        Skill skill = moves[moveIndex];
        moveIndex = (moveIndex + 1) % moves.length;
        return skill;
    }

    /**
     * Returns true if the monster's current HP is greater than 0, false otherwise.
     */
    public boolean isAlive() {
        return currentHp > 0;
    }

    /**
     * Adjusts the monster's health by the given amount.
     * If the health goes above the max HP, it is set to the max HP.
     * If the health goes below 0, it is set to 0.
     *
     * @param amount the amount to adjust the health by
     */
    public void adjustHealth(int amount) {
        currentHp += amount;

        if (currentHp > maxHp) {
            currentHp = maxHp;
        } else if (currentHp < 0) {
            currentHp = 0;
        }
    }

    /**
     * Updates the next turn time to the given value.
     */
    public void setNextTurnTime(double nextTurnTime) {
        this.nextTurnTime = nextTurnTime;
    }

    /**
     * Returns the next turn time.
     */
    public double getNextTurnTime() {
        return nextTurnTime;
    }

    /**
     * Returns the current HP of the monster.
     */
    public int getHp() {
        return currentHp;
    }

    /**
     * Returns the maximum HP of the monster.
     */
    public int getMaxHp() {
        return maxHp;
    }

    /**
     * Returns the `Skill` array of the monster's moves.
     */
    public Skill[] getMoves() {
        return moves;
    }

    /**
     * Returns the name of the monster.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the speed score of the monster.
     */
    public double getSpeedScore() {
        return speedScore;
    }

    /**
     * Returns a string representation of the monster in the format:
     * "{name} {currentHp}/{maxHp}"
     */
    public String toString() {
        return String.format("%s %d/%d", name, currentHp, maxHp);
    }
}
