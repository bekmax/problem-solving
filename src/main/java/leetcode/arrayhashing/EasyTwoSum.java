package leetcode.arrayhashing;

import java.util.HashMap;
import java.util.Map;

/**
 * N1 Two Sum
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */

public class EasyTwoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {12, 23, 43, 16, 47, 1, 3, 532};
        int target = 533;

        int[] result = solution.twoSum(arr, target);
        System.out.println(result[0] + " : " + result[1]);
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> myMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int compliment = target - nums[i];
                if (myMap.containsKey(compliment)) {
                    return new int[]{myMap.get(compliment), i};
                }
                myMap.put(nums[i], i);
            }
            throw new IllegalStateException("No solution");
        }
    }
}
