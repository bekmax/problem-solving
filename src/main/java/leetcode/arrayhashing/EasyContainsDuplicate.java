package leetcode.arrayhashing;

import java.util.HashSet;
import java.util.Set;

/**
 * N217 Contains Duplicate
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 */

public class EasyContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 1, 4, 5};
        System.out.println(solution.containsDuplicate(arr1));
        System.out.println(solution.containsDuplicate(arr2));
    }

    static class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> myUniqueSet = new HashSet<>();
            for (int n : nums) {
                if (myUniqueSet.contains(n)) {
                    return true;
                }
                myUniqueSet.add(n);
            }
            return false;
        }
    }
}
