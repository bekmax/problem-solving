package leetcode.binarysearch;

/**
 * N153 Find Minimum in Rotated Sorted Array
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
 * For example, the array nums = [0,1,2,4,5,6,7] might become:
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * You must write an algorithm that runs in O(log n) time.
 */
public class MediumFindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 7, 0, 1, 2};

        System.out.println(findMin(arr));
    }

    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        return nums[findMin(nums, 0, nums.length-1)];
    }

    private static int findMin(int[] nums, int left, int right) {
        if (right < left) {
            return 0;
        }
        if (right == left) {
            return left;
        }

        int mid = left + (right - left) / 2;

        if (mid < right && nums[mid + 1] < nums[mid]) {
            return mid + 1;
        }
        if (mid > left && nums[mid] < nums[mid - 1]) {
            return mid;
        }
        if (nums[right] > nums[mid]) {
            return findMin(nums, left, mid - 1);
        } else {
            return findMin(nums, mid + 1, right);
        }
    }
}
