package exercises.codility;

public class CountNumberOfDeletions {
    public static void main(String[] args) {

        // expected result AABBBBB -> deleted chars: AAB[A]BB[AAAA]B[A]B
        int result = countNumberOfTimes("AABABBAAAABAB");
        System.out.println(result);
    }

    // Delete any number of character so that all A are before B
    private static int countNumberOfTimes(String s) {

        int ctr = 0;
        char[] cs = s.toCharArray();
        int n = cs.length;

        // find first instance of B
        int i = 0;
        while (i < n) {

            if (cs[i] == 'B') {
                // start comparing from next char
                int j = i + 1;
                while (j < n && cs[j] != 'B') {
                    ++ctr;
                    ++j;
                }
                i = j; // move, and start to where j left off
            } else {
                i++; // move
            }

        }
        return ctr;
    }

}