package exercises.codility;

import java.util.HashMap;
import java.util.Map;

public class ShortestUniqueString {
    public static void main(String[] args) {

        System.out.println(solution("abaaba")); // Output: 2
        //System.out.println(solution("zyzyzyz")); // Output: 5
        //System.out.println(solution("aabbbabaaa")); // Output: 3
    }

    private static int solution(String S) {

        int N = S.length();

        for (int len = 1; len <= N; len++) { // Try all substring lengths from 1 to N
            Map<String, Integer> substringCount = new HashMap<>();

            for (int i = 0; i <= N - len; i++) {
                String sub = S.substring(i, i + len);
                substringCount.put(sub, substringCount.getOrDefault(sub, 0) + 1);
            }

            for (Map.Entry<String, Integer> entry : substringCount.entrySet()) {
                if (entry.getValue() == 1) {
                    return len; // Return the length of the shortest unique substring
                }
            }
        }

        return -1; // If no unique substring is found
    }

}