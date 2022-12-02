package leetcode.matrix;

/**
 * N289. Game of Life
 * According to Wikipedia's article: "The Game of Life, also known simply as Life,
 * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
 * Given the current state of the m x n grid board, return the next state.
 */
public class MediumGameOfLife {
    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        int[][] board2 = {{1,0},{1,1}};

        gameOfLife(board2);
    }

    public static void gameOfLife(int[][] board) {
        int[][] result = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int aliveCount = checkNeighbors(board, i, j);
                if (board[i][j] == 0) {
                    if (aliveCount == 3) {
                        result[i][j] = 1;
                    } else {
                        result[i][j] = 0;
                    }
                }
                if (board[i][j] == 1) {
                    if (aliveCount == 2 || aliveCount == 3) {
                        result[i][j] = 1;
                    } else {
                        result[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                board[i][j] = result[i][j];
            }
        }

        print(board);
    }

    public static int checkNeighbors(int[][] board, int i, int j) {
        int aliveCount = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k == i && l == j) continue;
                if (k >= 0 && k < board.length) {
                    if (l >= 0 && l < board[0].length) {
                        if (board[k][l] == 1) {
                            aliveCount++;
                        }
                    }
                }
            }
        }
        return aliveCount;
    }

    public static void print(int[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
