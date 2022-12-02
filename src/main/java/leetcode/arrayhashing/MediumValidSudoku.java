package leetcode.arrayhashing;

import java.util.HashSet;
import java.util.Set;

/**
 * N36 Valid Sudoku
 * Determine if a 9 x 9 Sudoku board is valid.
 * Only the filled cells need to be validated according to the following rules:
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */

public class MediumValidSudoku {
    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet = new HashSet<>();
        Set<Character> colSet = new HashSet<>();

        // check for rows and cols
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!rowSet.add(board[i][j])) return false;
                }
                if (board[j][i] != '.') {
                    if (!colSet.add(board[j][i])) return false;
                }
            }
            rowSet.clear();
            colSet.clear();
        }

        // check for block
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!checkForBlock(board, i, j)) return false;
            }
        }

        return true;
    }

    private static boolean checkForBlock(char[][] board, int a, int b) {
        Set<Character> blockSet = new HashSet<>();

        for (int i = a; i < a + 3; i++) {
            for (int j = b; j < b + 3; j++) {
                if (board[i][j] != '.') {
                    if (!blockSet.add(board[i][j])) return false;
                }
            }
        }
        return true;
    }
}
