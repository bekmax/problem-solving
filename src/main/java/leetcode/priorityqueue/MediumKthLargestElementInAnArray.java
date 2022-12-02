package leetcode.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * N215 Kth Largest Element In An Array
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * You must solve it in O(n) time complexity.
 */
public class MediumKthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};

        System.out.println(findKthLargest(nums, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();

        for (int num : nums){
            priorityQueue.add(num);

            if (priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }

        return priorityQueue.peek();
    }
}
