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
            if (recipientBanks[i] == 'B') { // bank B receives money

                // move money around
                balanceB = balanceB + V[i];
                balanceA = balanceA - V[i];

                // check for minimum
                if (balanceA < minA) {
                    minA = balanceA;
                }
            } else if (recipientBanks[i] == 'A') { // bank A receives money

                // move money around
                balanceA = balanceA + V[i];
                balanceB = balanceB - V[i];

                // check for minimum
                if (balanceB < minB) {
                    minB = balanceB;
                }
            }

            minAmounts[0] = Math.abs(minA);
            minAmounts[1] = Math.abs(minB);
        }


        return minAmounts;
    }

}