package com.top100.solution76;

import java.util.HashMap;

/**
 * @author LiSheng
 * @date 2020/5/8 14:49
 */
class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (tMap.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(tMap.get(c))) {
                    valid++;
                }
            }
            while (valid == tMap.size()) {
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }
                char d = s.charAt(left);
                if (tMap.containsKey(d)) {
                    if (tMap.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        String str = "a";
        String ttr = "aa";
        System.out.println(new Solution().minWindow(str, ttr));
    }
}