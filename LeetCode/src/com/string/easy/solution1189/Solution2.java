package com.string.easy.solution1189;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/4/5 21:30
 */
public class Solution2 {
    public int maxNumberOfBalloons(String text) {
        int[] record = new int[26];
        int res = Integer.MAX_VALUE;
        Set<Character> balloon = new HashSet<>(Arrays.asList('b', 'a', 'l', 'o', 'n'));
        for (char c : text.toCharArray()) {
            record[c - 'a']++;
        }
        record[11] /= 2;
        record[14] /= 2;
        for (char c : "balon".toCharArray()) {
            if (res > record[c - 'a']) {
                res = record[c - 'a'];
            }
        }
        for (Character c : balloon) {

        }
        return res;
    }

    public static void main(String[] args) {
        String text = "ballon";
        System.out.println(new Solution2().maxNumberOfBalloons(text));
    }
}
