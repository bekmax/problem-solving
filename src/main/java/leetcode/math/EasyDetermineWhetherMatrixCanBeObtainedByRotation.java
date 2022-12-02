package leetcode.math;

/**
 * N1886. Determine Whether Matrix Can Be Obtained By Rotation
 * Given two n x n binary matrices mat and target,
 * return true if it is possible to make mat equal to target by rotating mat in 90-degree increments,
 * or false otherwise.
 */
public class EasyDetermineWhetherMatrixCanBeObtainedByRotation {
    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] target = {{1, 1, 1}, {0, 1, 0}, {0, 0, 0}};

        System.out.println(findRotation(mat, target));
    }

    public static boolean findRotation(int[][] mat, int[][] target) {
        int[][] rotatedMatBy90 = rotateByClockwise(mat);
        int[][] rotatedMatBy180 = rotateByClockwise(rotatedMatBy90);
        int[][] rotatedMatBy270 = rotateByClockwise(rotatedMatBy180);

        return checkIfEqual(mat, target) ||
                checkIfEqual(rotatedMatBy90, target) ||
                checkIfEqual(rotatedMatBy180, target) ||
                checkIfEqual(rotatedMatBy270, target);
    }

    private static boolean checkIfEqual(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] rotateByClockwise(int[][] mat) {
        int len = mat.length - 1;

        int[][] rotatedMat = new int[len + 1][len + 1];

        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= len; j++) {
                rotatedMat[i][len - j] = mat[j][i];
            }
        }
        return rotatedMat;
    }
}
