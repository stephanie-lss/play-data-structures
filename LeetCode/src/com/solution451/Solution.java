package com.solution451;


import java.util.*;

/**
 * @author LiSheng
 * @date 2020/2/19 19:14
 */
public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            list.add(entry);
        }
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Character, Integer> m : list) {
            for (int i = 0; i < m.getValue(); i++) {
                builder.append(m.getKey());
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = new Solution().frequencySort("Aabb");
        System.out.println(s);
    }
}
