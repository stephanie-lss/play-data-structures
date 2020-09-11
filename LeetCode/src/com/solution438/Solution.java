package com.solution438;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author LiSheng
 * @date 2020/2/19 10:47
 * 超出时间限制
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map1 = getFreq(p);
        int l = 0, r = p.length() - 1;
        while (r < s.length()) {
            Map<Character, Integer> map2 = getFreq(s.substring(l, r + 1));
            if (isSame(map1, map2)) {
                res.add(l);
            }
            l++;
            r++;
        }
        return res;
    }

    private boolean isSame(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Character c1 : map1.keySet()) {
            if (map2.containsKey(c1)) {
                if (map1.get(c1).compareTo(map2.get(c1)) != 0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> getFreq(String p) {
        Map<Character, Integer> freq = new TreeMap<>();
        for (int i = 0; i < p.length(); i++) {
            if (freq.get(p.charAt(i)) == null) {
                freq.put(p.charAt(i), 1);
            } else {
                freq.put(p.charAt(i), freq.get(p.charAt(i)) + 1);
            }
        }
        return freq;
    }

    public static void main(String[] args) {
        List<Integer> list = new Solution().findAnagrams("abab", "ab");
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
