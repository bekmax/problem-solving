package leetcode.stack;

import java.util.Stack;

/**
 * N20 Valid Parenthesis
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class EasyValidParentheses {
    public static void main(String[] args) {
        String s = "({[]})";

        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> myStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                myStack.push(c);
                continue;
            }

            if (myStack.isEmpty()) return false;

            switch (c) {
                case ')' -> {
                    if (myStack.pop() != '(') {
                        return false;
                    }
                }
                case '}' -> {
                    if (myStack.pop() != '{') {
                        return false;
                    }
                }
                case ']' -> {
                    if (myStack.pop() != '[') {
                        return false;
                    }
                }
            }
        }
        return myStack.isEmpty();
    }
}
