package leetcode.arrayhashing;

import java.util.HashSet;
import java.util.Set;

public class HardFirstMissingPositive {
    public static void main(String[] args) {
        int[] arr = {7,8,9,11,12};

        System.out.println(firstMissingPositive(arr));
    }

    public static int firstMissingPositive(int[] nums) {
        int minPos = 1;
        Set<Integer> mySet = new HashSet<>();

        for (int num : nums) {
            if (num > 0) {
                mySet.add(num);
            }
        }
        while (mySet.contains(minPos)) {
            minPos++;
        }
        return minPos;
    }
}
