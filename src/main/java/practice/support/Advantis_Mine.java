package practice.support;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Advantis_Mine {
    public static void main(String[] args) {
        String s = "cat bored";
        String t = "robed act";

        System.out.println(check(s,t));
    }

    public static boolean check(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        String[] sArr = s.split(" ");
        String[] tArr = t.split(" ");

        List<String> sList = new ArrayList<>();
        List<String> tList = new ArrayList<>();

        for (String elem : sArr) {
            sList.add(hash(elem));
        }
        for (String elem : tArr) {
            tList.add(hash(elem));
        }

        Collections.sort(sList);
        Collections.sort(sList);

        for (int i = 0; i < sList.size(); i++) {
            if (!sList.get(i).equals(tList.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static String hash(String word) {
        char[] hash = new char[26];

        for (char c : word.toCharArray()) {
            hash[c - 'a']++;
        }
        return new String(hash);
    }
}
