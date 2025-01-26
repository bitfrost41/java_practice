package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithGreatestNumberOfCandies_1431 {
    public static void main(String[] args) {

        int[] candies = {1, 5, 4};
        List<Boolean> result = kidsWithCandies(candies, 2);
        System.out.println(result);
    }

    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int highestCount = 0;
        for (int i = 0; i < candies.length; i++) {
            if (highestCount <= candies[i]) {
                highestCount = candies[i];
            }
        }

        List<Boolean> resultList = new ArrayList<>();
        for (int i=0; i < candies.length; i++) {
            int finalCount = candies[i] + extraCandies;

            if (finalCount >= highestCount) {
                resultList.add(true);
            } else {
                resultList.add(false);
            }
        }

        return resultList;
    }

}