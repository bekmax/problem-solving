package leetcode.arrayhashing;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * N4 Median of Two Sorted Arrays
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */
public class HardMedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }
        int[] combined = new int[nums1.length + nums2.length];
        int index1 = 0;
        int index2 = 0;
        int counter = 0;
        double result = 0.0;

        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                combined[counter++] = nums1[index1++];
            } else if (nums1[index1] > nums2[index2]) {
                combined[counter++] = nums2[index2++];
            } else {
                combined[counter++] = nums1[index1++];
                combined[counter++] = nums2[index2++];
            }
        }

        while (index1 < nums1.length) {
            combined[counter++] = nums1[index1++];
        }

        while (index2 < nums2.length) {
            combined[counter++] = nums2[index2++];
        }

        int index = 0;
        if (combined.length % 2 != 0) {
            index = (combined.length / 2);
            result = combined[index];
        } else {
            index = (combined.length / 2);
            result = (double) (combined[index] + combined[index - 1]) / 2;
        }

        return result;
    }
}
