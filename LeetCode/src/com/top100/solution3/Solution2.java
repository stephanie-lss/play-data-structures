package com.top100.solution3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/8/3 10:53
 */
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int n = 0;
        if (s == null || (n = s.length()) == 0) {
            return 0;
        }
        Map<Character, Integer> freq = new HashMap<>();
        int left = 0, right = 0, res = 0;
        while (right < n) {
            char c = s.charAt(right);
            right++;
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            while (freq.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                freq.put(d, freq.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
