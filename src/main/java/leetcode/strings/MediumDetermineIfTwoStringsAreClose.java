package leetcode.strings;

import java.util.*;

/**
 * N1657. Determine if Two Strings Are Close
 * Two strings are considered close if you can attain one from the other using the following operations:
 * Operation 1: Swap any two existing characters.
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 */
public class MediumDetermineIfTwoStringsAreClose {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bca";

        System.out.println(closeStrings(s1, s2));
    }

    public static boolean closeStrings(String word1, String word2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        int[] arr3 = new int[26];
        int[] arr4 = new int[26];

        for (char c : word1.toCharArray()) {
            arr1[c - 'a']++;
            arr3[c - 'a'] = 1;
        }

        for (char c : word2.toCharArray()) {
            arr2[c - 'a']++;
            arr4[c - 'a'] = 1;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.toString(arr1).equals(Arrays.toString(arr2))
                && Arrays.toString(arr3).equals(Arrays.toString(arr4));
    }
}
