package leetcode.arrayhashing;

import java.util.Arrays;

/**
 * N238 Product of Array Except Self
 * Given an integer array nums,
 * return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */
public class MediumProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {5,2,3,4};

        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] leftArr = new int[nums.length];
        int[] rightArr = new int[nums.length];
        int left = 1;
        int right = 1;

        for (int i = 0, j = nums.length - 1; i < nums.length && j >= 0; i++, j--) {
            leftArr[i] = left;
            left *= nums[i];

            rightArr[j] = right;
            right *= nums[j];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = leftArr[i] * rightArr[i];
        }

        System.out.println(Arrays.toString(leftArr));
        System.out.println(Arrays.toString(rightArr));
        return nums;
    }
}
