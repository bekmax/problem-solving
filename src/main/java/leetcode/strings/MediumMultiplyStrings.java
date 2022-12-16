package leetcode.strings;

/**
 * N43. Multiply Strings
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class MediumMultiplyStrings {
    public static void main(String[] args) {
        System.out.println(multiply("123456789", "987654321"));

    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        if (num2.equals("1")) {
            return num1;
        }

        String counter = "1";
        String result = num1;
        while (!counter.equals(num2)) {
            System.out.println(result);
            result = addItself(result, num1);
            counter = addItself(counter, "1");
        }
        return result;
    }

    private static String addItself(String sum, String num) {
        StringBuilder sumStr = new StringBuilder(sum).reverse();
        StringBuilder numStr = new StringBuilder(num).reverse();
        StringBuilder result = new StringBuilder();
        int len = numStr.length();
        int carry = 0;
        for (int i = 0; i < len; i++) {
            int n = sumStr.charAt(i) - '0' + numStr.charAt(i) - '0' + carry;
            result.append(n % 10);
            carry = n / 10;
        }

        for (int i = len; i < sumStr.length(); i++) {
            int n = sumStr.charAt(i) - '0' + carry;
            result.append(n % 10);
            carry = n / 10;
        }

        if (carry > 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }
}
