package exercises.codility;

/*
There are N players standing in a row, one player on a field. They are numbered from 0 to N-1 from left to right.
Players perform moves one by one from left to right, that is, in ascending order of numbers. Each player presses an arrow key in one of the four cardinal directions: left ('<), right (>), up ('*) or down (v). A key press in the given direction means that the player attempts to move onto the closest field in the direction specified. A move can be performed only if there is no other player already standing on the target field.
Moves are represented as a string S of length N, where S[K] (for K within the range O..N-1) is the direction of the K-th player's move. How many players will actually perform a move successfully?
Write a function:
class Solution f public int solution (String S); }
which, given a string S of length N representing arrow keys pressed by each of the players, returns the number of players that will perform a move successfully.
*/

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