package leetcode.strings;

import java.util.Arrays;

/**
 * N821 Shortest Distance to a Character
 * Given a string s and a character c that occurs in s, return an array of integers answer where
 * answer.length == s.length and answer[i] is the distance from index i to the closest occurrence of character c in s.
 * The distance between two indices i and j is abs(i - j), where abs is the absolute value function.
 */
public class EasyShortestDistanceToCharacter {
    public static void main(String[] args) {
        String s = "leetcode";
        char c = 'e';

        System.out.println(Arrays.toString(shortestToChar(s, c)));
    }

    public static int[] shortestToChar(String s, char c) {
        int[] answer = new int[s.length()];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < answer.length; i++) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            answer[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;

        for (int i = answer.length - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            answer[i] = Math.min(answer[i], prev - i);
        }
        return answer;
    }
}
