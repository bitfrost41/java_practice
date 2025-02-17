package exercises.twopointers;

public class IsSubsequence_392 {
    public static void main(String[] args) {

        boolean result = isSubsequence("bd", "ahbgdc");
        System.out.println(result);
    }

    private static boolean isSubsequence(String s, String t) {

        // blank defaults to true
        if (s.length() == 0) {
            return true;
        }

        int sIndex = 0;
        int tIndex = 0;

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        int N = tChar.length;

        // loop until t runs out
        while (tIndex < N) {

            // evaluate sChar
            if (sChar[sIndex] == tChar[tIndex]) {
                // if equal, s char is in t string. then move s index
                sIndex++;

                // if it reached the end of s before terminating in t, then subsequence is found
                if (sIndex == sChar.length) {
                    return true;
                }
            }

            tIndex++;

        }

        return false;
    }

}