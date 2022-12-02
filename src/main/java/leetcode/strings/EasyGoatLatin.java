package leetcode.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * N824 Goat Latin
 * You are given a string sentence that consist of words separated by spaces.
 * Each word consists of lowercase and uppercase letters only.
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 * The rules of Goat Latin are as follows:
 * If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append "ma" to the end of the word.
 * For example, the word "apple" becomes "applema".
 * If a word begins with a consonant (i.e., not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end, and so on.
 * Return the final sentence representing the conversion from sentence to Goat Latin.
 */
public class EasyGoatLatin {
    public static void main(String[] args) {
        String s = "I speak Goat Latin";

        System.out.println(toGoatLatin(s));
    }

    public static String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        StringBuilder a = new StringBuilder();
        Set<Character> vowels = new HashSet<>(Arrays.asList('A', 'O', 'I', 'U', 'E', 'a', 'o', 'i', 'u', 'e'));
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            if (vowels.contains(sb.charAt(0))) {
                sb.append("ma");
            } else {
                char initial = sb.charAt(0);
                sb.deleteCharAt(0).append(initial).append("ma");
            }
            a.append("a");
            sb.append(a);
            result.append(sb.toString()).append(" ");
        }

        return result.toString().trim();
    }
}
