package exercises.codility;

import java.util.HashMap;
import java.util.Map;

public class OddOccurencesInArray {
    public static void main(String[] args) {

        int[] A = { 9, 3, 9, 3, 9, 7, 9 };
        int K = 3;

        int result = solution(A);
        System.out.println(result);
    }

    private static int solution(int[] A) {

        int N = A.length;
        Map<Integer, Integer> valueMap = new HashMap<>();

        for (int i = 0; i < N; i++) {

            if (!valueMap.containsKey(A[i])) {
                valueMap.put(A[i], 1);
            } else {
                valueMap.remove(A[i]);
            }
        }

        Map.Entry<Integer, Integer> actualValue = valueMap.entrySet()
                .stream()
                .findFirst()
                .get();
        return actualValue.getKey();
    }

}