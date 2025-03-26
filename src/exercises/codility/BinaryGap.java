package exercises.codility;

public class BinaryGap {
    public static void main(String[] args) {

        int result = solution(9);
        System.out.println(result);
    }

    private static int solution(int N) {


        int maxGap = 0;
        if (N == 1) {
            return 0;
        }

        char[] binaryRep = Integer. toBinaryString(N).toCharArray();
        int currentGap = 0;
        for (int x = 0; x < binaryRep.length; x++) {

            if (binaryRep[x] == '0') {
                currentGap++;
            } else if (binaryRep[x] == '1') {
                if (currentGap > maxGap) {
                    maxGap = currentGap;
                }
                currentGap = 0; // reset
            }


        }

        return maxGap;
    }

}