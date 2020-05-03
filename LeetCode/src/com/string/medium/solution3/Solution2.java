package com.string.medium.solution3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/5/2 10:48
 */
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        int len = array.length;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int head = 0, tail = 0; tail < len; tail++) {
            if (map.containsKey(array[tail])) {
                head = Math.max(map.get(array[tail]) + 1, head);
            }
            map.put(array[tail], tail);
            max = Math.max(max, tail - head + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "litgiguofiyfouhufserihlifpujkufthttihig";
        System.out.println(new Solution2().lengthOfLongestSubstring(str));
    }
}
