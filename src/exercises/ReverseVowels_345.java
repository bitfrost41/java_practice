package exercises;

import java.util.ArrayList;
import java.util.List;

public class ReverseVowels_345 {
    public static void main(String[] args) {

        String result = reverseVowels("IceCreAm");
        System.out.println(result);
    }

    // Using java lists
    private static String reverseVowels(String s) {

        List<Integer> vowelIndexes = new ArrayList<>();
        List<Character> vowels = new ArrayList<>();

        for (int i = 0; i < s.length(); i++){

            // if vowel, record index and vowel
            if ("aeiouAEIOU".indexOf(s.charAt(i)) != -1) {
                vowelIndexes.addFirst(i); // insert as first elem
                vowels.add(s.charAt(i));
            }
        }

        StringBuilder result = new StringBuilder(s);
        for (int i = 0; i < vowelIndexes.size(); i++) {
            result.setCharAt(vowelIndexes.get(i), vowels.get(i));
        }

        return result.toString();
    }

    // Faster execution
    private static String reverseVowels2(String s) {

        // set true for each vowel in ascii map
        boolean[] vowels = new boolean[128];
        for (char c : "aeiouAEIOU".toCharArray()) {
            vowels[c] = true;
        }
        char[] cs = s.toCharArray(); // convert string to char array
        int i = 0, j = cs.length - 1; // set 2 pointers starting at both ends
        while (i < j) {
            while (i < j && !vowels[cs[i]]) {
                ++i; // traverse from left until finding a vowel
            }
            while (i < j && !vowels[cs[j]]) {
                --j; // traverse from right until finding a vowel
            }
            if (i < j) {

                // swap vowels
                char t = cs[i];
                cs[i] = cs[j];
                cs[j] = t;

                // move pointers
                ++i;
                --j;
            }
        }
        return String.valueOf(cs);
    }


}