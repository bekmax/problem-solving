package leetcode.arrayhashing;

import java.util.HashSet;
import java.util.Set;

/**
 * N575 Distribute Candies
 * Alice has n candies, where the ith candy is of type candyType[i].
 * Alice noticed that she started to gain weight, so she visited a doctor.
 * The doctor advised Alice to only eat n / 2 of the candies she has (n is always even).
 * Alice likes her candies very much,
 * and she wants to eat the maximum number of different types of candies while still following the doctor's advice.
 * Given the integer array candyType of length n,
 * return the maximum number of different types of candies she can eat if she only eats n / 2 of them.
 */
public class EasyDistributeCandies {
    public static void main(String[] args) {
        int[] candyType = {6, 6, 6, 6};
        System.out.println(distributeCandies(candyType));
    }

    public static int distributeCandies(int[] candyType) {
        Set<Integer> candy = new HashSet<>();
        for (int i = 0; i < candyType.length; i++) {
            candy.add(candyType[i]);
        }
        return Math.min(candyType.length / 2, candy.size());
    }
}
