package exercises.codility;

import java.util.*;

public class Tournament {
    public static void main(String[] args) {
        int[] skills1 = { 4, 2, 7, 3, 1, 8, 6, 5 };
        System.out.println(Arrays.toString(solution(skills1))); // Output: [2, 1, 3, 1, 1, 3, 2, 1]

        //int[] skills2 = {4, 2, 1, 3};
        //System.out.println(Arrays.toString(solution(skills2))); // Output: [2, 1, 1, 2]

        //int[] skills3 = {3, 4, 2, 1};
        //System.out.println(Arrays.toString(solution(skills3))); // Output: [1, 2, 2, 1]
    }

    public static int[] solution(int[] skills) {
        int n = skills.length;
        int[] lastRound = new int[n];

        // map skills and indices
        Map<Integer, Integer> skillToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skillToIndex.put(skills[i], i);
        }

        // add list of player skills
        List<Integer> players = new ArrayList<>();
        for (int skill : skills) {
            players.add(skill);
        }

        int round = 1;

        while (players.size() > 1) {
            List<Integer> nextRoundPlayers = new ArrayList<>();

            // increment by 2 because neighbors compete with each other
            for (int i = 0; i < players.size(); i += 2) {
                int skill1 = players.get(i);
                int skill2 = players.get(i + 1);
                int winner = Math.max(skill1, skill2);

                // put last round to losers
                lastRound[skillToIndex.get(Math.min(skill1, skill2))] = round;

                // fill up next round of players
                nextRoundPlayers.add(winner);
            }

            // assign next round of players and increment round
            players = nextRoundPlayers;
            round++;
        }

        // winner's last round is when there are 2 left; reduce by 1
        lastRound[skillToIndex.get(players.get(0))] = round - 1;
        return lastRound;
    }
}