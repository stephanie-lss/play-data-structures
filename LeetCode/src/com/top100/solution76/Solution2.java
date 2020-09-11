package com.top100.solution76;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/5/23 11:47
 */
class Solution2 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> mapper = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        String res = s + t;
        int left = 0, right = 0, count = 0;
        boolean valid = false;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (target.containsKey(c)) {
                mapper.put(c, mapper.getOrDefault(c, 0) + 1);
                if (mapper.get(c).equals(target.get(c))) {
                    count++;
                    if (count == target.size()) {
                        valid = true;
                    }
                }
            }
            while (valid) {
                char d = s.charAt(left);
                left++;

                if (mapper.containsKey(d)) {
                    mapper.put(d, mapper.get(d) - 1);
                    if (mapper.get(d) < target.get(d)) {
                        if (right - left < res.length()) {
                            res = s.substring(left - 1, right);
                        }
                        count--;
                        valid = false;
                    }
                }
            }
        }
        return res.equals(s + t) ? "" : res;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaabbbbbcdd";
        String t = "abcdd";
        System.out.println(new Solution2().minWindow(s, t));
    }
}