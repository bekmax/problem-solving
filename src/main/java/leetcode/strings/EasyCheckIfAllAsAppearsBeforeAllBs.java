package leetcode.strings;

/**
 * N2124 Check if All A's Appears Before All B's
 * Given a string s consisting of only the characters 'a' and 'b',
 * return true if every 'a' appears before every 'b' in the string. Otherwise, return false.
 */
public class EasyCheckIfAllAsAppearsBeforeAllBs {
    public static void main(String[] args) {
        String s = "aaabbb";

        System.out.println(checkString(s));
    }

    public static boolean checkString(String s) {
        boolean bFound = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' && bFound) {
                return false;
            }
            if (s.charAt(i) == 'b') {
                bFound = true;
            }
        }
        return true;
    }
}
