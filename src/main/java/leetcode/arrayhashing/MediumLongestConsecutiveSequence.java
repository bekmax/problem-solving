package leetcode.arrayhashing;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * N128 The Longest Consecutive Sequence
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 */
public class MediumLongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {0, -3, 7, 2, 5, 8, 4, 6, 0, 1};

        System.out.println(longestConsecutive(arr));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> mySet = new TreeSet<>();

        for (int n : nums) {
            mySet.add(n);
        }

        int maxSequence = 1;
        int counter = 1;

        Iterator<Integer> iterator = mySet.iterator();
        int prev = iterator.next();

        while (iterator.hasNext()) {
            int current = iterator.next();
            if (current - prev == 1) {
                counter++;
                maxSequence = Math.max(maxSequence, counter);
            } else {
                counter = 1;
            }
            prev = current;
        }

        return maxSequence;
    }
}
