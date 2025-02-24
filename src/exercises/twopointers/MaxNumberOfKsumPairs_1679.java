package exercises.twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKsumPairs_1679 {
    public static void main(String[] args) {

        int[] nums = { 3, 1, 3, 4, 3 };
        int result = maxOperations(nums, 6);
        System.out.println(result);
    }

    // Two-pointer solution
    private static int maxOperations(int[] nums, int k) {

        // Sort to ascending order
        Arrays.sort(nums);

        // initialize pointers
        int left = 0;
        int right = nums.length - 1;

        // operation count to return
        int count = 0;

        while (left < right) {

            if (nums[left] + nums[right] < k) {
                // move left pointer to increase possible sum
                left++;
            } else if (nums[left] + nums[right] > k) {
                // move right pointer to decrease possible sum
                right--;
            } else {
                // found target
                count++;

                // move both pointers
                left++;
                right--;
            }
        }

        return count;
    }

    // HashMap solution
    /*private static int maxOperations(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int target = k - nums[i]; // complementing value to satisfy x = k - nums[i]
            if (map.containsKey(target)) {
                // if map contains the complementary value
                count++; // add counter

                if (map.get(target) == 1) {
                    // if frequency is 1, remove from map
                    map.remove(target);
                } else {
                    // decrease frequency
                    map.put(target, map.get(target) - 1);
                }

            } else {
                // add to map where: key = num in index; value = current frequency or default to zero, then add 1
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }

        }

        return count;
    }*/

}