package leetcode.binarysearch;

/**
 * N33 Search In Rotated Sorted Array
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot
 * index k (1 <= k < nums.length) such that the resulting array is
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class MediumSearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {7, 8, 1, 2, 3, 4, 5, 6};

        System.out.println(search(arr, 2));
    }

    public static int search(int[] nums, int target) {
        int minNumberIndex = binarySearch(nums, 0, nums.length - 1);
        int result1 = binarySearch(nums, 0, minNumberIndex, target);
        int result2 = binarySearch(nums, minNumberIndex, nums.length - 1, target);
        if (result1 != -1) return result1;
        else return result2;
    }

    private static int binarySearch(int[] nums, int left, int right) {
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
            return binarySearch(nums, left, mid - 1);
        } else {
            return binarySearch(nums, mid + 1, right);
        }
    }

    private static int binarySearch(int[] nums, int left, int right, int target) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                return binarySearch(nums, left, mid - 1, target);
            } else {
                return binarySearch(nums, mid + 1, right, target);
            }
        }
        return -1;
    }
}
