package exercises.arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf_238 {
    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4 };
        int[] answer = productExceptSelf(nums);
        System.out.println(Arrays.toString(answer));
    }

    private static int[] productExceptSelf(int[] nums) {

        int length = nums.length;

        int[] answer = new int[length];
        int[] left_products = new int[length];
        int[] right_products = new int[length];

        // calculate from left; product of all values and assign to corresponding index
        // starting from 2nd element
        // value of products from left so far * current nums value
        // assign to current index of output_array_1

        left_products[0] = 1; // left of first element is 1
        for (int i = 1; i < length; i++) {
            left_products[i] =  left_products[i - 1] * nums[i - 1];
        }

        // calculate from right; product of all values and assign to corresponding index
        // starting from 2nd to last element
        // value of products from right so far * current nums value
        // assign to current index of output_array_2

        right_products[length - 1] = 1; // right of last element is 1
        for (int i = length - 2; i >= 0; i--) {
            right_products[i] =  right_products[i + 1] * nums[i + 1];
        }

        // multiply output_array_1 and output_array_2
        for (int i = 0; i < length; i++) {
            answer[i] = left_products[i] * right_products[i];
        }

        return answer;
    }

}