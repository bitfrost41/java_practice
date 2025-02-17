package exercises.arrays;

public class StringCompression_443 {
    public static void main(String[] args) {

        char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        // char[] chars = { 'a' };
        int result = compress(chars);
        System.out.println(result);
    }

    private static int compress(char[] chars) {

        int writeIndex = 0; // tracks where to write in the array
        int readIndex = 0; // track the point of the current pointer reading the array
        int length = chars.length; // total length of the input array

        // loop through array
        while (readIndex < length) {

            char currentChar = chars[readIndex]; // save current char
            int count = 0; // initialize counter

            // loop again until finding a new char
            while (readIndex < length && currentChar == chars[readIndex]) {
                count++;
                readIndex++;
            }

            // record
            chars[writeIndex] = currentChar;
            writeIndex++;

            // if count is more than 1, append the length
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[writeIndex] = c;
                    writeIndex++;
                }
            }

        }

        return writeIndex;
    }

}