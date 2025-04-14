import java.util.Scanner;
import java.util.Arrays;

public class PlayNIM {

    public static void main(String[] args) {

        int[] gameState = NIM.createGameState(5,4);
        System.out.println(Arrays.toString(gameState));
        Scanner object = new Scanner(System.in);

        while (!NIM.isOver(gameState)) {
            String row = "a";
            String takes = "a";

            while (!NIM.isValidMove(gameState, row, takes)) {
                NIM.drawGameState(gameState);

                System.out.println();
                System.out.println("Choose a row, 1 to " + gameState.length + ": ");
                row = object.nextLine();

                System.out.println("Take how many tokens, 1 to 3 (no more than available): ");
                takes = object.nextLine();

                if (!NIM.isValidMove(gameState, row, takes)) {
                    System.out.println("Invalid move");
                }
            }

            int intRow = Integer.parseInt(row) - 1;
            int intTakes = Integer.parseInt(takes);
            gameState = NIM.update(gameState, intRow, intTakes);
        }

        System.out.println("Game over, the last player lost!");

    }

}

