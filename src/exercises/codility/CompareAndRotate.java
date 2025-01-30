package exercises.codility;

public class CompareAndRotate {
    public static void main(String[] args) {

        int result = timesOfEqualFirstAndLastChars("abbaa");
        System.out.println(result);
    }

    // counter-clockwise rotation
    // abbaa ( 0 vs 4 ) - 1 < init value
    // bbaaa ( 1 vs 0 )     < loop start
    // abbaa ( 2 vs 1 ) - 2
    // aabba ( 3 vs 2 ) - 3
    // aaabb ( 4 vs 3 )
    private static int timesOfEqualFirstAndLastChars(String s) {

        int ctr = 0;

        char[] cs = s.toCharArray();
        int n = cs.length;

        // compare first iteration
        if (cs[0] == cs[n - 1]) {
            ctr++;
        }

        // iterate succeeding rotations
        int i = 0;
        while (i < n - 1) {
            if (cs[i] == cs[i + 1]) {
                ctr++;
            }
            ++i;
        }
        return ctr;
    }

}