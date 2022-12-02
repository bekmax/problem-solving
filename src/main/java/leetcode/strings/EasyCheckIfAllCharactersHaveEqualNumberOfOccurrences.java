package leetcode.strings;

import java.util.Arrays;

/**
 * N1941 Check if All Characters Have Equal Number of Occurrences
 * Given a string s, return true if s is a good string, or false otherwise.
 * A string s is good if all the characters that appear in s have the same number of occurrences
 * (i.e., the same frequency).
 */
public class EasyCheckIfAllCharactersHaveEqualNumberOfOccurrences {
    public static void main(String[] args) {
        String s = "abcabc";

        System.out.println(areOccurrencesEqual(s));
    }

    public static boolean areOccurrencesEqual(String s) {
        int[] alphabet = new int[26];
        int n = 0;
        for (char c : s.toCharArray()) {
            alphabet[c - 'a']++;
            n = alphabet[c - 'a'];
        }

        for (int a : alphabet) {
            if (a == 0) continue;
            if (a != n) return false;
        }
        return true;
    }
}
