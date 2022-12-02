package leetcode.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * N1046 Last Stone Weight
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together.
 * Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
 * If x == y, both stones are destroyed, and
 * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 * At the end of the game, there is at most one stone left.
 * Return the weight of the last remaining stone. If there are no stones left, return 0.
 */
public class EasyLastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {};

        System.out.println(lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {
        Queue<Integer> stonesQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int stone : stones) {
            stonesQueue.add(stone);
        }

        int x;
        int y;
        while (stonesQueue.size() > 1) {
            y = stonesQueue.poll();
            x = stonesQueue.poll();
            if (x != y){
                y = y - x;
                stonesQueue.add(y);
            }
        }

        if (stonesQueue.size() == 1){
            return stonesQueue.poll();
        }
        return 0;
    }
}
