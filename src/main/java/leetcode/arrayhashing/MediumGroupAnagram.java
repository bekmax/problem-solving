package leetcode.arrayhashing;

import java.util.*;

/**
 * N49 Group Anagram
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class MediumGroupAnagram {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> result = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String hash = hashedString(strs[i]);

            if (!result.containsKey(hash)) {
                result.put(hash, new ArrayList<>(Collections.singletonList(strs[i])));
            } else {
                result.get(hash).add(strs[i]);
            }
        }

        return new ArrayList<>(result.values());
    }

    public static String hashedString(String s) {
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        return Arrays.toString(arr);
    }
}
