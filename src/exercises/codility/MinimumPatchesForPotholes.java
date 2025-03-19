package exercises.codility;

/*
There is a road consisting of N segments, numbered from 0 to N-1, represented by a string S. Segment S[K) of the road may contain a pothole, denoted by a single uppercase "X" character, or may be a good segment without any potholes, denoted by a single dot, ".".
For example, string" .X..X means that there are two potholes in total in the road: one is located in segment S[1] and one in segment S[4]. All other segments are good.
The road fixing machine can patch over three consecutive segments at once with asphalt and repair all the potholes located within each of these segments. Good or already repaired segments remain good after patching them.
Your task is to compute the minimum number of patches required to repair all the potholes in the road.
Write a function:
class Solution { public int solution (String S); }
• that, given a string S of length N, returns the minimum number of patches required to repair all the potholes.
*/
public class MinimumPatchesForPotholes {
    public static void main(String[] args) {

        String S = "....X.X....X";

        int result = solution(S);
        System.out.println(result);
    }

    private static int solution(String S) {
        int n = S.length();
        int patches = 0;
        int i = 0;

        while (i < n) {
            if (S.charAt(i) == 'X') {
                // Apply a patch covering S[i], S[i+1], and S[i+2]
                patches++;
                i += 3; // Move past the patched section
            } else {
                i++; // Move to the next segment
            }
        }

        return patches;
    }

}