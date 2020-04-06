package com.string.easy.solution1189;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/4/5 21:30
 */
public class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] record = new int[15];
        int res = 0;
        Set<Character> balloon = new HashSet<>(Arrays.asList('b', 'a', 'l', 'o', 'n'));
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (balloon.contains(c)) {
                record[c - 'a']++;
                if (record[0] >= 1 && record[1] >= 1 && record[11] >= 2 && record[13] >= 1 && record[14] >= 2) {
                    res++;
                    record[0]--;
                    record[1]--;
                    record[11] -= 2;
                    record[13]--;
                    record[14] -= 2;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String text = "ballon";
        System.out.println(new Solution().maxNumberOfBalloons(text));
    }
}
