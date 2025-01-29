package exercises.arrays;

public class MergeStringsAlternatively_1769 {
    public static void main(String[] args) {
        String result = mergeAlternately("test1", "test2");
        System.out.println(result);
    }


    private static String mergeAlternately(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i=0; i < word1.length() || i < word2.length(); i++) {

            if (i < word1.length()) {
                stringBuilder.append(word1.charAt(i));
            }

            if (i < word2.length()) {
                stringBuilder.append(word2.charAt(i));
            }

        }

        return stringBuilder.toString();
    }

}