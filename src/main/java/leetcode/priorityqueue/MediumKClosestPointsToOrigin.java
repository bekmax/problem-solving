package leetcode.priorityqueue;

import java.util.*;

/**
 * N973 K Closest Points To Origin
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
 * return the k closest points to the origin (0, 0).
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 */
public class MediumKClosestPointsToOrigin {
    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};

        kClosest(points, 1);
    }

    public static int[][] kClosest(int[][] points, int k) {
        class Point {
            final int x;
            final int y;
            final double distanceFromOrigin;

            Point(int x, int y) {
                this.x = x;
                this.y = y;
                this.distanceFromOrigin = Math.sqrt(x * x + y * y);
            }
        }

        Queue<Point> priorityQueue = new PriorityQueue<>(points.length,
                (o1, o2) -> {
                    if (o1.distanceFromOrigin - o2.distanceFromOrigin > 0) {
                        return 1;
                    } else if (o1.distanceFromOrigin - o2.distanceFromOrigin < 0) {
                        return -1;
                    } else {
                        return 0;
                    }
                });

        for (int[] arr : points) {
            priorityQueue.add(new Point(arr[0], arr[1]));
        }

        int[][] result = new int[k][2];
        while (k > 0) {
            Point point = priorityQueue.poll();
            if (point == null) break;
            --k;
            result[k][0] = point.x;
            result[k][1] = point.y;
        }

        return result;
    }
}
