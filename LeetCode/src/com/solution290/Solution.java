package com.solution290;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/2/19 13:09
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] s = str.split(" ");
        if (s.length != pattern.length()) {
            return false;
        }
        Map<Character, String> res = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            char c = pattern.charAt(i);
            if (!res.containsKey(c)) {
                if (!res.containsValue(s[i])) {
                    res.put(c, s[i]);
                } else {
                    return false;
                }
            } else {
                if (res.get(c).compareTo(s[i]) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean flag = new Solution().wordPattern("abba", "dog cat cat fish");
        System.out.println(flag);
    }
}
