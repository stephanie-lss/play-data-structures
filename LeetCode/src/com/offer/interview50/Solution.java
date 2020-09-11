package com.offer.interview50;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/5/15 21:19
 */
class Solution {
    public char firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> freq = new LinkedHashMap<>();
        Set<Character> bad = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (freq.containsKey(c)) {
                bad.add(c);
                freq.remove(c);
            } else if (!bad.contains(c)) {
                freq.put(c, 1);
            }
        }
        return freq.isEmpty() ? ' ' : freq.entrySet().iterator().next().getKey();
    }
}
