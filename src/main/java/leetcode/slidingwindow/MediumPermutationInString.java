package leetcode.slidingwindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * N567 Permutation in String
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 */
public class MediumPermutationInString {
    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcbda";

        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        char[] charArrElement = new char[26];
        for (char c : s1.toCharArray()) {
            charArrElement[c - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
            char[] charArrSource = new char[26];
            for (int j = 0; j < s1.length(); j++) {
                charArrSource[s2.charAt(i + j) - 'a']++;
            }

            if (checkIfEquals(charArrElement, charArrSource)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkIfEquals(char[] input1, char[] input2) {
        for (int i = 0; i < input1.length; i++) {
            if (input1[i] != input2[i]) {
                return false;
            }
        }
        return true;
    }
}
