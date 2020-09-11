package com.solution242;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/2/19 12:24
 */
public class Solution2 {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        Map<Character, Integer> freq = new HashMap<>();
        //O(n)
        for (int i = 0; i < s.length(); i++) {
            if (freq.get(s.charAt(i)) == null) {
                freq.put(s.charAt(i), 1);
            } else {
                freq.put(s.charAt(i), freq.get(s.charAt(i)) + 1);
            }
        }
        //O(n)
        for (int i = 0; i < t.length(); i++) {
            if (!freq.containsKey(t.charAt(i))) {
                return false;
            } else {
                freq.put(t.charAt(i), freq.get(t.charAt(i)) - 1);
            }
        }
        //0(n)
        for (int i = 0; i < n; i++) {
            if (freq.get(s.charAt(i)) != 0) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        boolean flag = new Solution2().isAnagram("anagram", "nagaram");
        System.out.println(flag);
    }
}
