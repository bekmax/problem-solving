package leetcode.math;

/**
 * N7. Reverse Integer
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 */
public class MediumReverseInteger {
    public static void main(String[] args) {
        Integer num = Integer.MIN_VALUE;

        System.out.println(reverse(num));
        System.out.println(reverse(-123));
    }

    public static int reverse(int x) {
        int reversed = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int sign = x > 0 ? 1 : -1;
        x = Math.abs(x);
        while (x > 0) {
            int digit = x % 10;
            x /= 10;
            if (reversed > max / 10 || (reversed == max / 10 && digit > 7)) {
                return 0;
            }
            if (reversed < min / 10 || (reversed == min / 10 && digit < -8)) {
                return 0;
            }
            reversed = reversed * 10 + digit;
        }
        return reversed * sign;
    }
}
