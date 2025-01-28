package exercises;

public class CanPlaceFlowers_605 {
    public static void main(String[] args) {

        int[] flowerbed = { 1, 0, 0, 0, 1 };
        boolean result = canPlaceFlowers(flowerbed, 1);
        System.out.println(result);
    }

    private static boolean canPlaceFlowers(int[] flowerbed, int n) {

        for (int i = 0; i < flowerbed.length; i++) {

            // set left to 0 if first element, else use value at index
            int left = i == 0 ? 0 : flowerbed[i - 1];

            // set right to 0 if last element, else use value at index
            int right = i == (flowerbed.length - 1) ? 0 : flowerbed[i + 1];

            // if left, right and center are empty, place flower
            if (left == 0 && right == 0 && flowerbed[i] != 1) {
                flowerbed[i] = 1;
                n--;
            }

            if (n <= 0) {
                return true;
            }

        }

        return false;
    }

}