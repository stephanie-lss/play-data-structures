package com.string.easy.solution1370;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public String sortString(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> mapper = new TreeMap<>();
        for (char aChar : chars) {
            mapper.put(aChar, mapper.getOrDefault(aChar, 0) + 1);
        }
        StringBuilder res = new StringBuilder();
        int flag = 0;
        while (true) {
            boolean flag2 = false;
            StringBuilder tmp = new StringBuilder();
            for (Character key : mapper.keySet()) {
                if (mapper.get(key) > 0) {
                    tmp.append(key);
                    mapper.put(key, mapper.get(key) - 1);
                    flag2 = true;
                }
            }
            if (!flag2) {
                break;
            }
            if (flag % 2 == 0) {
                res.append(tmp);
            } else {
                res.append(tmp.reverse());
            }
            flag++;
        }
        return res.toString();
    }
}
