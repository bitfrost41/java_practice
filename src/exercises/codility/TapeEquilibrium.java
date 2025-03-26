package exercises.codility;

public class TapeEquilibrium {
    public static void main(String[] args) {

        int[] A = { 3, 1, 2, 4, 3 };
        int result = solution(A);
        System.out.println(result);
    }

    private static int solution(int[] A) {

        int N = A. length;
        int[] leftSum = new int[N];
        int[] rightSum = new int[N];
        int maxSum = Integer. MAX_VALUE;

        leftSum[0] = A[0];
        for (int i = 1; i < N; i++) {
            leftSum[i] = leftSum[i - 1] + A[i];
        }

        rightSum[N - 1] = A[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + A[i];
        }

        for (int i = 0; i < N - 1; i++) {

            int currentSum = Math.abs(leftSum[i] - rightSum[i + 1]);

            if (currentSum < maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }

}