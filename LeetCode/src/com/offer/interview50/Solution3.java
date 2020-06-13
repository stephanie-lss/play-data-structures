package com.offer.interview50;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/6/13 10:01
 */
class Solution3 {
    public char firstUniqChar(String s) {
        Set<Character> one = new LinkedHashSet<>();
        Set<Character> dup = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!dup.contains(c)) {
                one.add(c);
            } else if (one.contains(c)) {
                one.remove(c);
            }
            dup.add(c);
        }
        return one.isEmpty() ? ' ' : one.iterator().next();
    }
}