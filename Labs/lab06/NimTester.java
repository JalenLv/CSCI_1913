import java.util.Arrays;

public class NimTester {
    public static void main(String[] args) {
        int[] state;
        int[] result;

        System.out.println("createGameStates");
        state = NIM.createGameState(0, 0);
        System.out.println(Arrays.toString(state)); // []
        state = NIM.createGameState(5, 5);
        System.out.println(Arrays.toString(state)); // [1, 2, 3, 4, 5]
        state = NIM.createGameState(4, 3);
        System.out.println(Arrays.toString(state)); // [1, 2, 3, 3]
        state = NIM.createGameState(7, 9);
        System.out.println(Arrays.toString(state)); // [1, 2, 3, 4, 5, 6, 7]
        state = NIM.createGameState(1, 1);
        System.out.println(Arrays.toString(state)); // [1]
        state = NIM.createGameState(1, 3);
        System.out.println(Arrays.toString(state)); // [1]
        state = NIM.createGameState(5, 5);
        System.out.println(Arrays.toString(state)); // [1, 2, 3, 4, 5]
        state = NIM.createGameState(8, 4);
        System.out.println(Arrays.toString(state)); // [1, 2, 3, 4, 4, 4, 4, 4]
        state = NIM.createGameState(6, 1);
        System.out.println(Arrays.toString(state)); // [1, 1, 1, 1, 1, 1]
        state = NIM.createGameState(13, 9);
        System.out.println(Arrays.toString(state)); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9, 9]

        System.out.println("isValidMove");
        state = new int[] { 5, 4, 3, 2 };
        System.out.println(NIM.isValidMove(state, "1", "2")); // true
        state = new int[] { 8, 7, 6, 5, 4 };
        System.out.println(NIM.isValidMove(state, "5", "2")); // true
        state = new int[] { 4, 3 };
        System.out.println(NIM.isValidMove(state, "1", "1")); // true
        state = new int[] { 4, 3 };
        System.out.println(NIM.isValidMove(state, "3", "4")); // false
        state = new int[] { 5, 4, 3, 2 };
        System.out.println(NIM.isValidMove(state, "5", "4")); // false
        state = new int[] { 5, 4, 3, 2 };
        System.out.println(NIM.isValidMove(state, "a", "a")); // false
        state = new int[] { 5, 4, 3, 2 };
        System.out.println(NIM.isValidMove(state, "a", "2")); // false
        state = new int[] { 5, 4, 3, 2 };
        System.out.println(NIM.isValidMove(state, "1", "a")); // false
        state = new int[] { 5, 4, 3, 2 };
        System.out.println(NIM.isValidMove(state, "0", "1")); // false
        state = new int[] { 5, 4, 3, 2 };
        System.out.println(NIM.isValidMove(state, "4", "3")); // false
        state = new int[] { 5, 4, 3, 2 };
        System.out.println(NIM.isValidMove(state, "1", "4")); // false
        state = new int[] { 5, 4, 3, 2 };
        System.out.println(NIM.isValidMove(state, "3", "3")); // true

        System.out.println("update");
        state = new int[] { 3, 2, 1 };
        result = NIM.update(state, 2, 1);
        System.out.println(Arrays.toString(state) + " " + Arrays.toString(result));
        state = new int[] { 4, 3, 2, 1, 0 }; // [3, 2, 1] [3, 2, 0]
        result = NIM.update(state, 3, 1);
        System.out.println(Arrays.toString(state) + " " + Arrays.toString(result));
        state = new int[] { 9, 8, 7, 6, 5, 4, 3 }; // [4, 3, 2, 1, 0] [4, 3, 2, 0, 0]
        result = NIM.update(state, 6, 2);
        System.out.println(Arrays.toString(state) + " " + Arrays.toString(result));
        state = new int[] { 8, 7, 6, 5 }; // [9, 8, 7, 6, 5, 4, 3] [9, 8, 7, 6, 5, 4, 1]
        result = NIM.update(state, 0, 3);
        System.out.println(Arrays.toString(state) + " " + Arrays.toString(result));
        state = new int[] { 5, 4, 3, 2, 1 }; // [8, 7, 6, 5] [5, 7, 6, 5]
        result = NIM.update(state, 1, 1);
        System.out.println(Arrays.toString(state) + " " + Arrays.toString(result));
        state = new int[] { 4, 3, 2, 1 }; // [5, 4, 3, 2, 1] [5, 3, 3, 2, 1]
        result = NIM.update(state, 1, 2);
        System.out.println(Arrays.toString(state) + " " + Arrays.toString(result));
        // [4, 3, 2, 1] [4, 1, 2, 1]
        System.out.println("drawGameState");
        state = new int[] { 5, 4, 3, 2, 1 };
        System.out.println("before call");
        NIM.drawGameState(state);
        System.out.println("after call");
        // before call
        // ====================
        // 1 #####
        // 2 ####
        // 3 ###
        // 4 ##
        // 5 #
        // ====================
        // after call

        state = new int[] { 5, 4, 3, 4, 1, 0, 0, 9, 1 };
        System.out.println("before call");
        NIM.drawGameState(state);
        System.out.println("after call");
        // before call
        // ====================
        // 1 #####
        // 2 ####
        // 3 ###
        // 4 ####
        // 5 #
        // 6
        // 7
        // 8 #########
        // 9 #
        // ====================
        // after call

        state = new int[] { 1 };
        System.out.println("before call");
        NIM.drawGameState(state);
        System.out.println("after call");
        // before call
        // ====================
        // 1 #
        // ====================
        // after call

        System.out.println("isOver");
        System.out.println(NIM.isOver(new int[] { 0 })); // true
        System.out.println(NIM.isOver(new int[] { 1, 4, 1, 3, 1, 0 })); // false
        System.out.println(NIM.isOver(new int[] { 0, 1, 2, 3, 2 })); // false
        System.out.println(NIM.isOver(new int[] { 1, 2, 3, 4, 0 })); // false
        System.out.println(NIM.isOver(new int[] { 0, 0, 0, 0, 0, 0, 0, 0 })); // true
        System.out.println(NIM.isOver(new int[] { 1, 2, 0, 2, 1, 3 })); // false

    }
}

/*
 * 
 * total expected output
 * 
 * createGameStates
 * []
 * [1, 2, 3, 4, 5]
 * [1, 2, 3, 3]
 * [1, 2, 3, 4, 5, 6, 7]
 * [1]
 * [1]
 * [1, 2, 3, 4, 5]
 * [1, 2, 3, 4, 4, 4, 4, 4]
 * [1, 1, 1, 1, 1, 1]
 * [1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9, 9]
 * isValidMove
 * true
 * true
 * true
 * false
 * false
 * false
 * false
 * false
 * false
 * false
 * false
 * true
 * update
 * [3, 2, 1] [3, 2, 0]
 * [4, 3, 2, 1, 0] [4, 3, 2, 0, 0]
 * [9, 8, 7, 6, 5, 4, 3] [9, 8, 7, 6, 5, 4, 1]
 * [8, 7, 6, 5] [5, 7, 6, 5]
 * [5, 4, 3, 2, 1] [5, 3, 3, 2, 1]
 * [4, 3, 2, 1] [4, 1, 2, 1]
 * drawGameState
 * before call
 * ====================
 * 1 #####
 * 2 ####
 * 3 ###
 * 4 ##
 * 5 #
 * ====================
 * after call
 * before call
 * ====================
 * 1 #####
 * 2 ####
 * 3 ###
 * 4 ####
 * 5 #
 * 6
 * 7
 * 8 #########
 * 9 #
 * ====================
 * after call
 * before call
 * ====================
 * 1 #
 * ====================
 * after call
 * isOver
 * true
 * false
 * false
 * false
 * true
 * false
 * 
 * 
 */
