package com.solution38;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/2/23 10:33
 */
public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            Map<Character, Integer> freq = new LinkedHashMap<>();
            for (int j = 0; j < s.length(); j++) {
                if (!freq.containsKey(s.charAt(j))) {
                    for (Character k : freq.keySet()) {
                        sb.append(freq.get(k)).append(k);
                        freq.remove(k);
                    }
                    freq.put(s.charAt(j), 1);
                } else {
                    freq.put(s.charAt(j), freq.get(s.charAt(j)) + 1);
                }
            }
            for (Character k : freq.keySet()) {
                sb.append(freq.get(k)).append(k);
            }
            s = sb.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(5));
    }
}
