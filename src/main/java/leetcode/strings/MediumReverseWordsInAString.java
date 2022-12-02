package leetcode.strings;

import java.util.Arrays;
import java.util.Stack;

/**
 * N151 Reverse Words in a String
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters.
 * The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words.
 * Do not include any extra spaces.
 */
public class MediumReverseWordsInAString {
    public static void main(String[] args) {
        String s = "    the sky   is   blue  ";

        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        Stack<String> wordStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (!word.equals(" ") && !word.isEmpty()) {
                wordStack.push(word);
            }
        }
        while (!wordStack.isEmpty()) {
            sb.append(wordStack.pop()).append(" ");
        }
        return sb.toString().trim();
    }

}
