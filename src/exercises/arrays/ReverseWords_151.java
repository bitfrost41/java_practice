package exercises.arrays;

public class ReverseWords_151 {
    public static void main(String[] args) {

        String result = reverseWords(" hello world     test    ");
        System.out.println(result);
    }


    private static String reverseWords(String s) {

        // remove repeating, leading and trailing sapces
        s = s.trim().replaceAll(" +", " ");

        String[] sList = s.split(" ");

        int i = 0, j = sList.length - 1;

        while (i < j) {

            String t = sList[i];
            sList[i] = sList[j];
            sList[j] = t;

            ++i;
            --j;
        }

        return String.join(" ", sList);
    }


}