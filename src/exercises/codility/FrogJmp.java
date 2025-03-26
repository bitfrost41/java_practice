package exercises.codility;

import java.util.Arrays;

public class FrogJmp {
    public static void main(String[] args) {


        int result = solution(10, 85, 30);
        System.out.println(result);
    }

    private static int solution(int X, int Y, int D) {

        int distance = Y - X;
        int jumps = distance / D;
        int remainder = distance % D;
        if (remainder != 0) {
            jumps +=1;
        }

        return jumps;
        //return (int) Math.ceil(((double) Y - (double) X) / (double) D); - single-line solution
    }

}