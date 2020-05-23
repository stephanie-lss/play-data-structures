package com.top100.solution76;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/5/23 11:47
 */
class Solution3 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> mapper = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        int[] res = new int[2];
        res[1] = (s + t).length();
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
                        if (right - left < (res[1] - res[0])) {
                            res[0] = left - 1;
                            res[1] = right;
                        }
                        count--;
                        valid = false;
                    }
                }
            }
        }
        return res[1] - res[0] == (s + t).length() ? "" : s.substring(res[0], res[1]);
    }

    public static void main(String[] args) {
        String s = "a";
        String t = "aa";
        System.out.println(new Solution3().minWindow(s, t));
    }
}