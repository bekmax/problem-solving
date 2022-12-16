package practice.support;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PureIntegration {
    public static void main(String[] args) {
            String[] words = {"speed", "duel", "dule", "cars"};
            String[] queries = {"spede", "deul"};

        System.out.println(getAutoCorrect(words, queries));
    }

    public static List<List<String>> getAutoCorrect(String[] words, String[] queries){
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            result.add(getAnagramsFromWord(words, queries[i]));
        }
        return result;
    }

    public static List<String> getAnagramsFromWord(String[] words, String query){
        List<String> anagrams = new ArrayList<>();

        char[] q = new char[26];
        for (int i = 0; i < query.length(); i++) {
            q[query.charAt(i) - 'a']++;
        }
        String qKey = new String(q);

        for (String word : words){
            char[] w = new char[26];
            for (int i = 0; i < word.length(); i++) {
                w[word.charAt(i) - 'a']++;
            }
            String wKey = new String(w);
            if (qKey.equals(wKey)){
                anagrams.add(word);
            }
        }
        Collections.sort(anagrams);
        return anagrams;
    }
}















