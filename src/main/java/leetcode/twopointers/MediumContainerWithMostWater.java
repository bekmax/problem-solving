package leetcode.twopointers;

/**
 * N11 Container With Most Water
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 */
public class MediumContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxAmount = 0;

        while (left < right) {
            int amount = Math.min(height[left], height[right]) * (right - left);
            if (amount > maxAmount) {
                maxAmount = amount;
            }
            if (height[left] == Math.min(height[left], height[right])) {
                int shortHeight = height[left];
                while (left < right && height[left] <= shortHeight) {
                    left++;
                }
            } else {
                int shortHeight = height[right];
                while (left < right && height[right] <= shortHeight) {
                    right--;
                }
            }
        }
        return maxAmount;
    }
}
