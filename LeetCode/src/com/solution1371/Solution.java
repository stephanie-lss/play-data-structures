package com.solution1371;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/5/20 8:28
 * not understand
 */
class Solution {
    private static final String VOWELS = "aeiou";

    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        int size = s.length();
        int state = 0, maxSize = 0;
        map.putIfAbsent(0, -1);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < VOWELS.length(); j++) {
                if (s.charAt(i) == VOWELS.charAt(j)) {
                    state ^= (1 << (VOWELS.length() - j - 1));
                    break;
                }
            }
            if (map.containsKey(state)) {
                maxSize = Math.max(maxSize, i - map.get(state));
            }
            map.putIfAbsent(state, i);
        }
        return maxSize;
    }

    public static void main(String[] args) {
        String str = "leetcodeisgreat";
        System.out.println(new Solution().findTheLongestSubstring(str));
    }
}