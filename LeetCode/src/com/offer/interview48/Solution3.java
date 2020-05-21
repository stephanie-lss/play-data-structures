package com.offer.interview48;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/5/21 10:16
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, max = 0;
        Map<Character, Integer> mapper = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            mapper.put(c, mapper.getOrDefault(c, 0) + 1);
            while (mapper.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                mapper.put(d, mapper.get(d) - 1);
            }
            max = Math.max(max,right - left);
        }
        return max;
    }

    public static void main(String[] args) {
        String str="abcabcbb";
        System.out.println(new Solution3().lengthOfLongestSubstring(str));
    }
}
