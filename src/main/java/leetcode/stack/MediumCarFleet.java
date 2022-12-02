package leetcode.stack;

import java.util.*;

/**
 * N853. Car Fleet
 * There are n cars going to the same destination along a one-lane road. The destination is target miles away.
 * You are given two integer array position and speed, both of length n,
 * where position[i] is the position of the ith car and speed[i] is the speed of the ith car (in miles per hour).
 * A car can never pass another car ahead of it, but it can catch up to it and drive bumper to bumper at the same speed.
 * The faster car will slow down to match the slower car's speed.
 * The distance between these two cars is ignored (i.e., they are assumed to have the same position).
 * A car fleet is some non-empty set of cars driving at the same position and same speed.
 * Note that a single car is also a car fleet.
 * If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.
 * Return the number of car fleets that will arrive at the destination.
 */
public class MediumCarFleet {
    public static void main(String[] args) {
        int[] positions = {0};
        int[] speed = {10};
        int target = 0;

        System.out.println(carFleet(target, positions, speed));
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        if (target == 0 || position.length == 1) {
            return position.length;
        }

        int totalFleets = position.length;
        int[] positionAndSpeed = new int[target];

        for (int i = 0; i < position.length; i++) {
            positionAndSpeed[position[i]] = speed[i];
        }

        double laggingCarTime = -1;
        for (int i = target - 1; i >= 0; i--) {
            if (positionAndSpeed[i] == 0) {
                continue;
            }

            double time = (double) (target - i) / positionAndSpeed[i];
            if (time > laggingCarTime) {
                laggingCarTime = time;
            } else {
                totalFleets--;
            }
        }
        return totalFleets;
    }
}
