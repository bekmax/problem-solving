package leetcode.strings;

import java.util.Arrays;

/**
 * N1370 Increasing Decreasing String
 * You are given a string s. Reorder the string using the following algorithm:
 * Pick the smallest character from s and append it to the result.
 * Pick the smallest character from s which is greater than the last appended character to the result and append it.
 * Repeat step 2 until you cannot pick more characters.
 * Pick the largest character from s and append it to the result.
 * Pick the largest character from s which is smaller than the last appended character to the result and append it.
 * Repeat step 5 until you cannot pick more characters.
 * Repeat the steps from 1 to 6 until you pick all characters from s.
 * In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.
 * Return the result string after sorting s with this algorithm.
 */
public class EasyIncreasingDecreasingString {
    public static void main(String[] args) {
        String s = "aaaabbbbccccc";

        System.out.println(sortString(s));
    }

    public static String sortString(String s) {
        int[] counts = new int[26];
        char[] letters = new char[26];
        int maxLetterCount = 0;
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
            letters[c - 'a'] = c;
            maxLetterCount = Math.max(counts[c - 'a'], maxLetterCount);
        }

        while (maxLetterCount > 0) {
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] != 0) {
                    result.append(letters[i]);
                    counts[i]--;
                }
            }

            for (int i = counts.length - 1; i >= 0; i--) {
                if (counts[i] != 0) {
                    result.append(letters[i]);
                    counts[i]--;
                }
            }
            maxLetterCount--;
        }

        return result.toString();
    }
}
