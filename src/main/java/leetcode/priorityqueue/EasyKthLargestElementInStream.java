package leetcode.priorityqueue;

import java.util.*;

/**
 * N703 Kth largest element in a Stream
 * Design a class to find the kth largest element in a stream.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Implement KthLargest class:
 * KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
 * int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
 */
public class EasyKthLargestElementInStream {
    public static void main(String[] args) {
        int[] nums = {4,5,8,2};
        KthLargest kthLargest = new KthLargest(3, nums);

        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }

    static class KthLargest {
        private int k;
        private Queue<Integer> minHeap = new PriorityQueue<>();

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int num : nums){
                add(num);
            }
        }

        public int add(int val) {
            minHeap.add(val);
            if (minHeap.size() > k){
                minHeap.poll();
            }
            return minHeap.peek();
        }
    }

}
