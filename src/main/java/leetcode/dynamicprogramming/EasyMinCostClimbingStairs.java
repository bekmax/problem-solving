package leetcode.dynamicprogramming;

/**
 * N746 Min Cost of Climbing Stairs
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 */
public class EasyMinCostClimbingStairs {
    public static void main(String[] args) {
        int[] arr = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(arr));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] db = new int[n + 1];
        db[n] = 0;
        db[n - 1] = cost[n-1];

        for (int i = n - 2; i >= 0; i--) {
            db[i] = Math.min(db[i+1], db[i+2]) + cost[i];
        }

        return Math.min(db[0], db[1]);
    }
}
