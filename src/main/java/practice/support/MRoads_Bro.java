package practice.support;

import java.util.Arrays;

public class MRoads_Bro {
    public static void main(String[] args) {
        String s = "ayayyya";

        System.out.println(largestSubstring(s));
    }

    public static String largestSubstring(String s) {
        int left = s.indexOf("a");
        int right = s.lastIndexOf("a");

        String result = "";

        if (left < right){
            String[] arr = s.substring(left+1, right).split("a");
            for(String str : arr){
                if (result.length() < str.length()){
                    result = str;
                }
            }
        }
        return result;
    }
















}
