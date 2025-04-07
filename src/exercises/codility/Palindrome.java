package exercises.codility;

public class Palindrome {
    public static void main(String[] args) {

        String S = "abc";
        int K = 1;
        String result = solution(S, K);
        System.out.println(result);
    }

    private static String solution(String S, int K) {

        char[] cs = S.toCharArray();
        int N = cs.length;

        // check if odd or even
        boolean isEven = (N % 2) == 0;

        int leftPointer;
        int rightPointer;

        // find starting index
        if (isEven) {
            rightPointer = N / 2;
            leftPointer = rightPointer - 1;
        } else {
            rightPointer = N / 2;
            leftPointer = rightPointer;
        }

        while (rightPointer < N) {
            char leftChar = cs[leftPointer];
            char rightChar = cs[rightPointer];

            if (leftChar == '?' && rightChar == '?') {
                // if both are question marks
                cs[rightPointer] = 'x';
                cs[leftPointer] = 'x';
            } else if (leftChar != rightChar) {

                if (leftChar == '?') {
                    // if left is ? and right has value
                    cs[leftPointer] = rightChar;
                } else if (rightChar == '?') {
                    // if right is ? and left has value
                    cs[rightPointer] = leftChar;
                } else {
                    if (K > 0) { // replace any
                        cs[leftPointer] = cs[rightPointer];
                        K--;
                    } else {
                        return "NO";
                    }
                }
            }
            --leftPointer;
            ++rightPointer;
        }
        return String.valueOf(cs);
    }
}