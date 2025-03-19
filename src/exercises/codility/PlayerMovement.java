package exercises.codility;

import java.util.HashSet;
import java.util.Set;

public class PlayerMovement {
    public static void main(String[] args) {

        String S = "^>VV<>";

        int result = solution(S);
        System.out.println(result);
    }

    private static int solution(String S) {
        int N = S.length();
        char[] cs = S.toCharArray();

        int[] players = new int[N];
        int successfulMoves = 0;

        // Populate array with players
        for (int i = 0; i < N; i++) {
            players[i] = 1;
        }

        boolean isMoveSuccessful = false;
        for (int i = 0; i < N; i++) {
            if (cs[i] == '<') {
                if (i == 0) {
                    isMoveSuccessful = true; // automatic success on first element
                } else {
                    isMoveSuccessful = players[i - 1] == 0; // check if player left the place
                }
            } else if (cs[i] == '>') {
                if (i == N - 1) {
                    isMoveSuccessful = true; // automatic success on last element
                } else {
                    isMoveSuccessful = false; // automatic fail as there will always be a player on the right
                }
            } else if (cs[i] == '^') {
                isMoveSuccessful = true; // automatic success on move up
            } else if (cs[i] == 'V') {
                isMoveSuccessful = true; // automatic success on move down
            }

            // Add to successful move
            if (isMoveSuccessful) {
                successfulMoves++;
                players[i] = 0;
            }
        }

        return successfulMoves;
    }

}