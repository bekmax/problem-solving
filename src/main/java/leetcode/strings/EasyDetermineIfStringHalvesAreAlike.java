package leetcode.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * N1704. Determine if String Halves Are Alike
 * You are given a string s of even length.
 * Split this string into two halves of equal lengths, and let a be the first half and b be the second half.
 * Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').
 * Notice that s contains uppercase and lowercase letters.
 * Return true if a and b are alike. Otherwise, return false.
 */
public class EasyDetermineIfStringHalvesAreAlike {
    public static void main(String[] args) {
        String work = "book";

        System.out.println(halvesAreAlike(work));
    }

    public static boolean halvesAreAlike(String s) {
        Set<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        vowelSet.add('A');
        vowelSet.add('E');
        vowelSet.add('I');
        vowelSet.add('O');
        vowelSet.add('U');

        int firstCount = 0;
        int secondCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (vowelSet.contains(s.charAt(i))){
                if (i < s.length() / 2){
                    firstCount++;
                } else{
                    secondCount++;
                }
            }
        }

        return firstCount == secondCount;
    }

}
