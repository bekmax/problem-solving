package leetcode.arrayhashing;

/**
 * N242 Valid Anagram
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */

public class EasyValidAnagram {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "anagram";
        String t = "gramana";
        System.out.println(solution.isAnagram(s, t));
    }

    static class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;

            int[] alphabet = new int[26];

            for (int i = 0; i < s.length(); i++) {
                alphabet[s.charAt(i) - 'a']++;
                alphabet[t.charAt(i) - 'a']--;
            }

            for (int n : alphabet) {
                if (n != 0) return false;
            }
            return true;
        }
    }
}
