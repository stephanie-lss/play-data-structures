package com.string.easy.solution819;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/4/4 19:12
 */
public class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";
        Set<String> banner = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> freq = new HashMap<>();
        int max = Integer.MIN_VALUE;
        String maxString = "";
        StringBuilder word = new StringBuilder();
        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String string = word.toString();
                word = new StringBuilder();
                freq.put(string, freq.getOrDefault(string, 0) + 1);
                if (freq.get(string) > max) {
                    if (!banner.contains(string)) {
                        max = freq.get(string);
                        maxString = string;
                    }
                }
            }
        }
        return maxString;
    }

    public static void main(String[] args) {
        String pa = "Bob";
        String[] banned = {};
        System.out.println(new Solution().mostCommonWord(pa, banned));
    }
}
