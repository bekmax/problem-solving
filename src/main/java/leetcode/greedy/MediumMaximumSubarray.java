package leetcode.greedy;

/**
 * N53. Maximum Subarray
 * Given an integer array nums, find the subarray which has the largest sum and return its sum.
 */
public class MediumMaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int maxSumSoFar = 0;

        for (int n : nums) {
            maxSumSoFar += n;
            maxSum = Math.max(maxSum, maxSumSoFar);

            if (maxSumSoFar < 0) {
                maxSumSoFar = 0;
            }
        }
        return maxSum;
    }
}
