package exercises.codility;

// https://leetcode.com/discuss/interview-question/2058599/a-group-of-friends-is-going-on-holiday-together-codility-problem
/*A group of friends is going on holiday together. They have come to a meeting point
        (the start of the journey) using N cars. There are P[K] people and S[K] seats in the K-th
car for K in range [O..N-1). Some of the seats in the cars may be free, so it is possible
for some of the friends to change the car they are in. The friends have decided that,
in order to be ecological, they will leave some cars parked at the meeting point and
travel with as few cars as possible.*/

import java.util.Arrays;
import java.util.Collections;

public class GroupOfFriendsCar {
    public static void main(String[] args) {

        int[] P = { 4, 4, 2, 4 };
        int[] S = { 5, 5, 2, 5 };

        //int[] P = { 1, 4, 1 };
        //int[] S = { 1, 5, 1 };

        //int[] P = { 2, 3, 4, 2 };
        //int[] S = { 2, 5, 7, 2 };

        int result = solution(P, S);
        System.out.println(result);
    }

    private static int solution(int[] P, int[] S) {

        int totalPassengers = 0;
        // Add all passengers P
        for (int i = 0; i < P.length; i++) {
            totalPassengers += P[i];
        }

        // sort cars from the largest
        Integer[] seats = Arrays.stream(Arrays.stream(S).toArray()).boxed().toArray(Integer[]::new); // convert from primitive
        Arrays.sort(seats, Collections.reverseOrder());

        int carsUsed = 0; // cars used has the same value as the index after check
        while (totalPassengers > 0) {
            totalPassengers = totalPassengers - seats[carsUsed];
            ++carsUsed;
        }

        return carsUsed;
    }

}