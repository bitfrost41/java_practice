package exercises.twopointers;

public class ContainerWithMostWater_11 {
    public static void main(String[] args) {

        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int result = maxArea(height);
        System.out.println(result);
    }

    private static int maxArea(int[] height) {

        int maxArea = 0; // highest area found so far
        int left = 0; // left index
        int right = height.length - 1; // right index

        while (left < right) {

            int width = right - left; // get width
            int area;

            if (height[left] <= height[right]) {
                // include scenario where left = right
                area = height[left] * width; // get area
                left++; // move left counter to 1 step to right
            } else {
                area = height[right] * width; // get area
                right--;  // move right counter 1 step to left
            }

            // check for highest value found so far
            if (area > maxArea) {
                maxArea = area;
            }

        }

        return maxArea;
    }

}