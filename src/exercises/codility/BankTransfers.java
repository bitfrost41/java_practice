package exercises.codility;

import java.util.Arrays;

public class BankTransfers {
    public static void main(String[] args) {

        String R = "BAABA";
        int[] V = {2, 4, 1, 1, 2};

        //String R = "ABAB";
        //int[] V = {10, 5, 10, 15};

        int[] result = solution(R, V);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(String R, int[] V) {

        int[] minAmounts = new int[2];
        char[] recipientBanks = R.toCharArray();

        // keep track of current balances
        int balanceA = 0;
        int balanceB = 0;

        // keep track of minimum balances
        int minA = 0;
        int minB = 0;

        for (int i = 0; i < V.length; i++) {
            if (recipientBanks[i] == 'A') {

                // move funds
                balanceA = balanceA + V[i];
                balanceB = balanceB - V[i];

                // if balance of B is less than minimum of A, assign current balance of B as minimum
                if (balanceB < minA) {
                    minB = balanceB;
                }

            } else if (recipientBanks[i] == 'B') {

                // move funds
                balanceB = balanceB + V[i];
                balanceA = balanceA - V[i];

                // if balance of A is less than minimum of B, assign current balance of A as minimum
                if (balanceA < minB) {
                    minA = balanceA;
                }

            }
        }

        minAmounts[0] = Math.abs(minA);
        minAmounts[1] = Math.abs(minB);
        return minAmounts;
    }

}