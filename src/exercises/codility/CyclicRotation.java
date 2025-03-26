package exercises.codility;

import java.util.Arrays;

public class CyclicRotation {
    public static void main(String[] args) {

        int[] A = { 3, 8, 9, 7, 6 };
        int K = 3;

        int[] result = solution(A, K);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(int[] A, int K) {

        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int newPosition = (i + K) % A.length; // using mod to do cyclic rotation
            result[newPosition] = A[i];
        }


        return result;
    }

}