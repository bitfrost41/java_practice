package exercises.codility;

// https://leetcode.com/discuss/interview-question/4991700/Microsoft-or-OA/


import java.util.Arrays;

public class MonitorOrdersByDistance {
    public static void main(String[] args) {

        /*int[] D = { 5, 11, 1, 3 }; // distance
        int[] C = { 6, 1, 3, 2 }; // order
        int P = 7; // supply*/

        /*int[] D = { 11, 18, 1 }; // distance
        int[] C = { 9, 18, 8 }; // order
        int P = 7; // supply*/

        int[] D = { 1, 4, 2, 5 }; // distance
        int[] C = { 4, 9, 2, 3 }; // order
        int P = 19; // supply

        int result = solution(D, C, P);
        System.out.println(result);
    }

    private static int solution(int[] D, int[] C, int P) {

        int N = D.length; // number of distances/orders; length should always be equal

        // pair each order with distance; create some sort of map using multidimensional array
        int[][] orders = new int[N][2];
        for (int i = 0; i < N; i++) {
            orders[i][0] = D[i]; // distance
            orders[i][1] = C[i]; // monitors required
        }

        // sort 2D array using first index
        Arrays.sort(orders, (a, b) -> Integer.compare(a[0], b[0]));

        // process in ascending order
        int fulfilledOrders = 0;
        for (int i = 0; i < N; i++) {
            if (P >= orders[i][1]) { // check if order can be fulfilled
                P = P - orders[i][1]; // subtract from total supply
                fulfilledOrders++; // add count to fulfilled orders
            } else {
                break; // end if order cannot be fulfilled in this distance
            }
        }

        return fulfilledOrders;
    }

}