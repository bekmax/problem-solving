package leetcode.strings;

/**
 * N520 Detect Capital
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Given a string word, return true if the usage of capitals in it is right.
 */
public class EasyDetectCapital {
    public static void main(String[] args) {
        String s = "USA";

        System.out.println(detectCapitalUse(s));
    }

    public static boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        int countCapital = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                countCapital++;
            }
        }

        if (countCapital == word.length() || countCapital == 0) {
            return true;
        }
        if (countCapital == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        }
        return false;
    }
}
