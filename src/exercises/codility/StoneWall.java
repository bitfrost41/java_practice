package exercises.codility;

import java.util.Stack;

public class StoneWall {
    public static void main(String[] args) {

        int[] H = { 8, 8, 5, 7, 9, 8, 7, 4, 8 };
        int result = solution(H);
        System.out.println(result);
    }

    private static int solution(int[] H) {

        Stack<Integer> stack = new Stack<>();
        int numBlock = 0;

        for (int i = 0; i < H.length; i++) {

            // if stack is not empty and "from high to low"
            // then remove value from stack
            while (!stack.isEmpty() && stack.peek() > H[i]) {
                stack.pop();
            }

            // if stack is empty
            // then add block and push current height
            if (stack.isEmpty()) {
                numBlock++;
                stack.push(H[i]);

            // if "from low to high"
            // then add block and push current height
            } else if (stack.peek() < H[i]) {
                numBlock++;
                stack.push(H[i]);
            }

            // if height is the same, do nothing

        }

        return numBlock;
    }

}