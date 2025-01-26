package exercises;

public class GcdOfStrings_1071 {
    public static void main(String[] args) {
        String result = gcdOfStrings("ABABABABABAB", "ABAB");
        System.out.println(result);
    }

    private static String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            // Assume str2 is always shorter than str1, else iterate
            return gcdOfStrings(str2, str1);
        } else if (!str1.startsWith(str2)) {
            // no gcd
            return "";
        } else if (str1.equals(str2)) {
            // both strings are now equal
            return str1;
        } else {
            return gcdOfStrings(str1.substring(str2.length()), str2);
        }
    }

}