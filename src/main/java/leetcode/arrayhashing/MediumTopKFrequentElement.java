package leetcode.arrayhashing;

import java.util.*;

/**
 * N347 Top K Frequent Element
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 */
public class MediumTopKFrequentElement {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] result = topKFrequent(nums, k);

        for (int n : result) {
            System.out.println(n);
        }

    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Map<Integer, List<Integer>> bucket = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (bucket.containsKey(entry.getValue())) {
                bucket.get(entry.getValue()).add(entry.getKey());
            } else {
                bucket.put(entry.getValue(), new ArrayList<Integer>(Collections.singletonList(entry.getKey())));
            }
        }

        int index = 0;
        for (int i = nums.length; i > 0; i--) {
            if (!bucket.containsKey(i)) continue;
            List<Integer> list = bucket.get(i);
            for (Integer n : list) {
                if (k > 0) {
                    result[index++] = n;
                    k--;
                }
            }
        }

        return result;
    }


}
