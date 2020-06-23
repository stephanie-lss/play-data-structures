package com.interview.Solution1_4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/6/23 11:22
 */
public class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int count = 1;
        for (Integer value : freq.values()) {
            if ((value & 1) == 1) {
                count--;
            }
        }
        return count == 1 || count == 0;
    }
}
