package leetcode.binarysearch;

/**
 * N875 Koko Eating Bananas
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 * The guards have gone and will come back in h hours.
 * Koko can decide her bananas-per-hour eating speed of k.
 * Each hour, she chooses some pile of bananas and eats k bananas from that pile.
 * If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 */
public class MediumKokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {805306368,805306368,805306368};
        int h = 1000000000;

        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 0;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int middle = (right + left) / 2;
            int hours = 0;

            for (int pile : piles) {
                hours += Math.ceil((double) pile / middle);
            }

            if (hours <= h) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return right;
    }
}
