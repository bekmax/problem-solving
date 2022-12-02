package leetcode.strings;

import java.util.Arrays;

/**
 * N1160 Find Words That Can Be Formed by Characters
 * You are given an array of strings words and a string chars.
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 * Return the sum of lengths of all good strings in words.
 */
public class EasyFindWordsThatCanBeFormedByCharacters {
    public static void main(String[] args) {
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";

        System.out.println(countCharacters(words, chars));
    }

    public static int countCharacters(String[] words, String chars) {
        int sumWordLength = 0;
        int[] charsHash = hash(chars);
        for (String s : words) {
            if (check(charsHash, hash(s))) {
                sumWordLength += s.length();
            }
        }
        return sumWordLength;
    }

    private static boolean check(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr2[i] > arr1[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] hash(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        return arr;
    }
}
