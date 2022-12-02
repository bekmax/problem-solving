package leetcode.bitmanipulation;

/**
 * N136 Single Number
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class EasySingleNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 3, 1, 5};

        System.out.println(singleNumber(arr));
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}
