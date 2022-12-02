package leetcode.arrayhashing;

import java.util.Arrays;

/**
 * N75. Sort Colors
 * Given an array nums with n objects colored red, white, or blue,
 * sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 */
public class MediumSortColors {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 0, 2, 1, 0, 0, 0};

        sortColors(arr);
    }

    public static void sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int n : nums) {
            counts[n]++;
        }

        int indexCounts = 0;
        int indexNums = 0;
        while (indexCounts < counts.length) {
            while (counts[indexCounts] != 0) {
                nums[indexNums++] = indexCounts;
                counts[indexCounts]--;
            }
            indexCounts++;
        }

        System.out.println(Arrays.toString(nums));
    }
}
