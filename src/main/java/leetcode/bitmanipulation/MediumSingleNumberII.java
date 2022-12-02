package leetcode.bitmanipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * N137 Single Number II
 * Given an integer array nums where every element appears three times except for one, which appears exactly once.
 * Find the single element and return it.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class MediumSingleNumberII {
    public static void main(String[] args) {
        int[] arr = {0,1,0,1,0,1,99};

        System.out.println(singleNumber(arr));
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() == 1) return entry.getKey();
        }
        return -1;
    }
}
