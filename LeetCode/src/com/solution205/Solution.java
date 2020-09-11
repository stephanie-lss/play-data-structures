package com.solution205;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/2/19 18:59
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        Map<Character, Character> res = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (!res.containsKey(c1)) {
                if (!res.containsValue(c2)){
                    res.put(c1, c2);
                }else {
                    return false;
                }
            } else {
                if (res.get(c1).compareTo(c2) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean flag = new Solution().isIsomorphic("aa", "ab");
        System.out.println(flag);
    }
}
