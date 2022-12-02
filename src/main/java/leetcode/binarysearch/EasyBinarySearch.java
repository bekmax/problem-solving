package leetcode.binarysearch;

public class EasyBinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 5, 6, 8, 9};
        int target = 6;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public static int binarySearch(int[] arr, int start, int end, int target) {
        if (start > end) return -1;
        int mid = (end - start) / 2 + start;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearch(arr, start, mid - 1, target);
        } else {
            return binarySearch(arr, mid + 1, end, target);
        }
    }
}
