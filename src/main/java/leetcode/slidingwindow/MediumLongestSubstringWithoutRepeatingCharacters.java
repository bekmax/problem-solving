package leetcode.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * N3 The Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class MediumLongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "aaa";

        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int pointer = 0;
        int max = 0;
        Set<Character> characterSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            while (characterSet.contains(s.charAt(i))) {
                characterSet.remove(s.charAt(pointer));
                pointer++;
            }
            characterSet.add(s.charAt(i));
            max = Math.max(max, i - pointer + 1);
        }

        return max;
    }
}
