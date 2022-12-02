package leetcode.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * N38 Count and Say
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
 * To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit.
 * Then for each substring, say the number of digits, then say the digit.
 * Finally, concatenate every said digit.
 */

public class MediumCountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(10));
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String number = countAndSay(n - 1);
        return say(count(number));
    }

    private static int[][] count(String num) {
        if (num == null || num.length() == 0) {
            return new int[0][0];
        }
        char[] arr = num.toCharArray();
        char digit = '0';
        int count = 0;
        List<Integer> digits = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                digit = arr[i];
                count++;
            } else {
                digit = arr[i];
                count++;
                digits.add(digit - '0');
                counts.add(count);
                count = 0;
            }
        }
        if (arr[arr.length - 1] == digit) {
            count++;
            digits.add(digit - '0');
            counts.add(count);
        } else {
            digits.add(arr[arr.length - 1] - '0');
            counts.add(1);
        }

        int[][] result = new int[digits.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = digits.get(i);
            result[i][1] = counts.get(i);
        }
        return result;
    }

    private static String say(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            sb.append(matrix[i][1]).append(matrix[i][0]);
        }
        return sb.toString();
    }
}
