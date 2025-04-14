// Name: Qiming Lyu

/**
 * The Battle class represents a single battle between two code monsters.
 */
public class Battle {
    /**
     * Handles exactly one turn of battle.
     * It will determine which code monster goes first based on their next turn
     * time. If the next turn time is the same, then codeMonster `one` should go.
     * After deciding who goes first, the function will call the `takeTurn` method,
     * and the skill will be used on the other code monster.
     * Finally, a message will be printed.
     *
     * @param one the first code monster
     * @param two the second code monster
     */
    public static void doOneTurn(CodeMonster one, CodeMonster two) {
        // determine who goes first
        CodeMonster first = one;
        CodeMonster second = two;
        if (one.getNextTurnTime() > two.getNextTurnTime()) {
            first = two;
            second = one;
        }

        // decide which skill to use
        Skill used = first.takeTurn();

        // print the message
        System.out.println(first.toString() + " uses " + used.toString() + " on " + second.toString());

        // use the skill
        used.useSkill(first, second);
    }

    /**
     * Carrys out the entire battle.
     *
     * @param one the first code monster
     * @param two the second code monster
     */
    public static CodeMonster battle(CodeMonster one, CodeMonster two) {
        // prepare each condeMonster
        one.prepForBattle();
        two.prepForBattle();

        // print a starting message
        System.out.println(one.toString() + " vs. " + two.toString());

        // take turns until one codeMonster is not alive.
        while (one.isAlive() && two.isAlive()) {
            Battle.doOneTurn(one, two);
        }

        // declare the winner
        CodeMonster winner = one.isAlive() ? one : two;
        System.out.println(winner.toString() + " wins!");
        return winner;
    }
}
