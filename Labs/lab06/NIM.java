/*
 * CSCI 1913
 * Lab 06
 * Author: Qiming Lyu
 * */

public class NIM {

    /**
     * create a game state array
     * 
     * @param size     -- the number of rows
     * @param stickMax -- the largest value
     * @return an array representing a token array. The array in the first position
     *         will be one, each following will be
     *         one larger up to the max.
     */
    public static int[] createGameState(int size, int stickMax) {
        int[] gameState = new int[size];
        for (int i = 0; i < size; i++) {
            gameState[i] = Math.min(i + 1, stickMax);
        }
        return gameState; // you will want to delete this line.
    }

    /**
     * This provided function operators similarly to the python isDigit method. You
     * give it a string and it will tell
     * you if the string contains only digits. Give it a read -- the actual design
     * isn't hard, basically a linear search.
     * 
     * @param str any string
     * @return true if all letters in the string are digits.
     */
    private static boolean isDigit(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a given move (as represented by two input strings) is valid. This
     * should check if the inputs are numbers
     * if those numbers are in the valid range.
     * 
     * @param gameState an array representing the number of tokens in each row.
     * @param row       a string representing which row the user wants to take from.
     *                  1-indexed.
     * @param takes     a string representing how many tokens the user wants to
     *                  take.
     * @return true if and only if the move would be valid
     */
    public static boolean isValidMove(int[] gameState, String row, String takes) {
        // check if the input is a digit
        if (!isDigit(row) || !isDigit(takes)) {
            return false;
        }

        int rowInt = Integer.parseInt(row);
        int takesInt = Integer.parseInt(takes);

        // check if `row` is in the valid range
        if (rowInt < 1 || rowInt > gameState.length) {
            return false;
        }

        // check if `takes` is between 1 and 3
        int MIN_TAKES = 1;
        int MAX_TAKES = 3;
        if (takesInt < MIN_TAKES || takesInt > MAX_TAKES) {
            return false;
        }

        // check if the row has enough tokens
        if (gameState[rowInt - 1] < takesInt) {
            return false;
        }

        return true;
    }

    /**
     * User System.out.println to represent a token grid to the program user.
     * 
     * @param gameState an array representing the number of tokens in each row.
     */
    public static void drawGameState(int[] gameState) {
        System.out.println("====================");

        for (int i = 0; i < gameState.length; i++) {
            System.out.print(String.format("%d ", i + 1));
            for (int j = 0; j < gameState[i]; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

        System.out.println("====================");
    }

    /**
     * Create an updated version of the game state. You can assume the row and takes
     * are valid for the gameState array provided.
     * 
     * @param gameState an array representing the number of tokens in each row.
     * @param row       the row the user wants to take from (0-indexed)
     * @param takes     the number of tokens the user wants to take
     * @return a new array representing the state number of tokens in each row after
     *         the given numbers were removed.
     */
    public static int[] update(int[] gameState, int row, int takes) {
        int[] newGameState = new int[gameState.length];
        for (int i = 0; i < gameState.length; i++) {
            newGameState[i] = gameState[i];
        }
        newGameState[row] -= takes;
        return newGameState;
    }

    /**
     *
     * @param gameState an array representing the number of tokens in each row.
     * @return true if and only if every element of gameState is false.
     */
    public static boolean isOver(int[] gameState) {
        for (int i = 0; i < gameState.length; i++) {
            if (gameState[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
