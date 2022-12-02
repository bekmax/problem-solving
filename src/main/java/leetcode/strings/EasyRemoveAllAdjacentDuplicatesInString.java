package leetcode.strings;

import java.util.Stack;

/**
 * N1047. Remove All Adjacent Duplicates In String
 * You are given a string s consisting of lowercase English letters.
 * A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 * We repeatedly make duplicate removals on s until we no longer can.
 * Return the final string after all such duplicate removals have been made.
 * It can be proven that the answer is unique.
 */
public class EasyRemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        String s = "abbaca";

        System.out.println(removeDuplicates(s));
    }

    public static String removeDuplicates(String s) {
        if (s == null || s.length() == 0) return "";
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }

        char[] result = new char[stack.size()];

        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return new String(result);
    }
}
