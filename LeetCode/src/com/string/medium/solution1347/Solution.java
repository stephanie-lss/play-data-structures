package com.string.medium.solution1347;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/4/13 12:09
 */
public class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        char[] sC = s.toCharArray();
        char[] tC = t.toCharArray();
        for (int i = 0; i < sC.length; i++) {
            sMap.put(sC[i], sMap.getOrDefault(sC[i], 0) + 1);
        }

        for (int i = 0; i < tC.length; i++) {
            if (sMap.containsKey(tC[i]) && sMap.get(tC[i]) != 0) {
                sMap.put(tC[i], sMap.get(tC[i]) - 1);
            }
        }
        int res = 0;
        for (Integer value : sMap.values()) {
            res += value;
        }
        return res;
    }
}
