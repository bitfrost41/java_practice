package exercises.twopointers;

public class MoveZeroes_283 {
    public static void main(String[] args) {

        int[] chars = { 0, 1, 0, 3, 12 };
        moveZeroes(chars);

    }

    private static void moveZeroes(int[] nums) {

        int length = nums.length;
        int writePointer = 0; // write pointer to place non-zero element

        // loop through array
        for (int i = 0; i < length; i++) {

            // look for next non-zero element
            if (nums[i] != 0) {

                // check if pointer 1 has moved
                if (i != writePointer) {

                    // swap non-zero found to write pointer
                    int temp = nums[i];
                    nums[i] = nums[writePointer];
                    nums[writePointer] = temp;
                }

                writePointer++;

            }

        }

    }

}