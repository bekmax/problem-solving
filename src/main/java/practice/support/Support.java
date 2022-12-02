package practice.support;

import java.util.HashMap;
import java.util.Map;

public class Support {
    public static void main(String[] args) {
        longestSameCharacterSetInString("abbssddd");
    }

    public static void longestSameCharacterSetInString(String s){
        int maxStartingIndex = 0;
        int maxCount = -1;
        int count = 1;
        char current = s.charAt(0);
        char maxChar = current;

        for (int i = 1; i < s.length(); i++) {
            char newChar = s.charAt(i);
            if (current == newChar){
                count++;
                if(count > maxCount){
                    maxCount = count;
                    maxChar = current;
                    maxStartingIndex = i - count + 1;
                }
            }
            else {
                current = newChar;
                count = 1;
            }
        }


        System.out.println(maxChar);
        System.out.println(maxCount);
        System.out.println(maxStartingIndex);
    }

}
