package practice.finale;

public class Knapsack {
    // Driver code
    public static void main(String args[]) {
        int val[] = new int[]{15, 12, 9, 16, 17};
        int wt[] = new int[]{2, 5, 3, 4, 6};
        int W = 12;
        int n = val.length;
        System.out.println("Maximum value: " + knapSack(W, wt, val, n));
    }

    static int knapSack(int W, int wt[], int val[], int n) {
        int i, w;
        int K[][] = new int[n + 1][W + 1];
        int keep[][] = new int[n + 1][W + 1];

        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                    keep[i][w] = 1;
                } else {
                    K[i][w] = K[i - 1][w];
                    keep[i][w] = 0;
                }
            }
        }

        System.out.print("Selected items: [ ");
        int k = W;
        for (int j = n; j > 0; j--) {
            if (keep[j][k] == 1) {
                System.out.print(j + " ");
                k = k - wt[j - 1];
            }
        }
        System.out.println("]");
        return K[n][W];
    }

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

}

