package practice.support;

import java.util.ArrayList;
import java.util.List;

public class Advantis {
    public static void main(String[] args) {
        char[][] board = {{'s', 'o', 's', 'o'}, {'s', 'o', 'o', 's'}, {'s', 's', 's', 's'}};
        String word = "sos";

        char[][] board1 = {{'a', 'a'}, {'a', 'a'}};
        String word1 = "aa";


        System.out.println(filterBoard(board1, word1));
    }

    public static int filterBoard(char[][] board, String word) {
        List<String> words = new ArrayList<>();
        int wordCount = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                StringBuilder horizontal = new StringBuilder();
                StringBuilder vertical = new StringBuilder();
                StringBuilder diagonal = new StringBuilder();

                for (int k = 0; k < word.length(); k++) {
                    if (j + k < board[i].length) {
                        horizontal.append(board[i][j + k]);
                    }

                    if (i + k < board.length) {
                        vertical.append(board[i + k][j]);
                    }

                    if (k + i < board.length && k + j < board[i].length) {
                        diagonal.append(board[i + k][j + k]);
                    }

                }

                words.add(horizontal.toString());
                words.add(vertical.toString());
                words.add(diagonal.toString());

            }
        }

        System.out.println(words);
        for (String s : words) {
            if (s.equals(word)) {
                wordCount++;
            }
        }
        return wordCount;
    }
}
