package exercises.codility;

public class MinimumDeletions {
    public static void main(String[] args) {

        String S = "aababbab";
        int result = solution(S);
        System.out.println(result);
    }

    private static int solution(String S) {

        int N = S.length();
        int minDeletions = 0;
        int countB = 0;

        // loop through each char in S
        for (int i = 0; i < N; i++) {

            if (S.charAt(i) == 'b') {
                // increment count of b chars
                ++countB;
            } else {
                // if 'a', compute the min between deleting the current 'a' + previous minDeletions; and
                // count all 'b' seen so far
                minDeletions = Math.min(minDeletions + 1, countB);
            }

        }

        return minDeletions;
    }
}