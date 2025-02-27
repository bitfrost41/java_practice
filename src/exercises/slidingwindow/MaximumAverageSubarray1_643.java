package exercises.slidingwindow;

public class MaximumAverageSubarray1_643 {
    public static void main(String[] args) {

        //int[] nums = { 1, 12, -5, -6, 50, 3 };
        int[] nums = { -1 };
        double result = findMaxAverage(nums, 1);
        System.out.println(result);
    }

    private static double findMaxAverage(int[] nums, int k) {

        // get sum of first k elements
        int currentSum = 0;
        for (int i = 0; i < k; ++i) {
            currentSum += nums[i];
        }

        // Initialize as first maxSum
        int maxSum = currentSum;

        for (int i = k; i < nums.length; ++i) {
            // update current sum by adding next element and subtracting first element of previous window
            currentSum = currentSum + nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        // convert to double and return average
        return maxSum * 1.0 / k;
    }

}