package exercises.arrays;

public class IncreasingTripletSubsequence_334 {
    public static void main(String[] args) {

        int[] nums = { 2, 1, 5, 0, 4, 6 };
        boolean result = increasingTriplet(nums);
        System.out.println(result);
    }


    private static boolean increasingTriplet(int[] nums) {

        int first = Integer.MAX_VALUE; // first value
        int middle = Integer.MAX_VALUE; // middle value

        for (int num : nums) {

            if (num <= first) {
                first = num; // smallest number found; number is smaller than previous first
            } else if (num <= middle) {
                middle = num; // middle number found; number is bigger than first, but smaller than previous middle
            } else {
                // last number found; number is bigger than middle, completing the triplet
                return true;
            }

        }

        // array traversal ended. no triplet found.
        return false;

    }


}