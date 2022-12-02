package leetcode.strings;

import java.util.Stack;

/**
 * N921 Minimum Add to Make Parentheses Valid
 * A parentheses string is valid if and only if:
 * It is the empty string,
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
 * For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
 * Return the minimum number of moves required to make s valid.
 */
public class MediumMinimumAddToMakeParenthesesValid {
    public static void main(String[] args) {
        String parenthesis = "(((";

        System.out.println(minAddToMakeValid(parenthesis));
    }

    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    count++;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.size() + count;
    }
}
