package leetcode.math;

/**
 * N48. Rotate Image
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 */
public class MediumRotateImage {
    public static void main(String[] args) {

    }

    public static void rotate(int[][] matrix) {
        int len = matrix.length - 1;

        int[][] res = new int[len+1][len+1];
        for(int i = 0; i <= len; i++){
            for(int j = 0; j <= len; j++){
                res[i][len-j] = matrix[j][i];
            }
        }

        for(int i = 0; i <= len; i++){
            for(int j = 0; j <= len; j++){
                matrix[i][j] = res[i][j];
            }
        }
    }
}
