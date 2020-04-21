package com.array.hard.solution466;

/**
 * @author LiSheng
 * @date 2020/4/19 9:23
 */
public class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] sC1 = s1.toCharArray();
        char[] sC2 = s2.toCharArray();
        int cur = 0, t1 = 0, t2 = 0;
        while (t1 < n1) {
            for (int i = 0; i < sC1.length; i++) {
                if (sC1[i] == sC2[cur]) {
                    if (cur == sC2.length - 1) {
                        cur = 0;
                        t2++;
                    } else {
                        cur++;
                    }
                }
            }
            t1++;
        }
        return t2 / n2;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getMaxRepetitions("niconiconi", 99981, "nicon", 81));
    }
}