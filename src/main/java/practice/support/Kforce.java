package practice.support;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Kforce {
    public static void main(String[] args) {
//        String s = "bbbaacdafe";
//        String s1 = "aabbb";
//        String s2 = "bbc";
//
//
//        System.out.println(isBeautiful(s));
//        System.out.println(isBeautiful(s1));
//        System.out.println(isBeautiful(s2));
//
//        System.out.println(digitsManipulations(1010));
//        System.out.println(digitsManipulations(123456));

        String source = "amazing";
        String pattern = "010";

        System.out.println(patternMatching(source, pattern));
    }

    public static boolean isBeautiful(String s) {
        char[] letters = new char[26];

        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }

        for (int i = 1; i < 26; i++) {
            if (letters[i - 1] < letters[i]) {
                return false;
            }
        }
        return true;
    }

    public static int digitsManipulations(int num) {
        int sumDigits = 0;
        int productDigit = 1;

        while (num > 0) {
            int n = num % 10;
            sumDigits += n;
            productDigit *= n;
            num /= 10;
        }

        return productDigit - sumDigits;
    }

    public static int patternMatching(String source, String pattern) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('u');
        vowels.add('i');
        vowels.add('o');
        vowels.add('y');
        int count = 0;

        for (int i = 0; i < source.length(); i++) {
            if (i + pattern.length() <= source.length()) {
                boolean matchFound = true;
                for (int j = 0; j < pattern.length(); j++) {
                    if (!(pattern.charAt(j) == '0' && vowels.contains(source.charAt(i + j))
                            || pattern.charAt(j) == '1' && !vowels.contains(source.charAt(i + j)))) {
                        matchFound = false;
                    }
                }
                if (matchFound) {
                    count++;
                }
            }
        }
        return count;
    }

}











