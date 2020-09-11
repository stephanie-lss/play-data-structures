package com.string.easy.solution788;

/**
 * @author LiSheng
 * @date 2020/4/4 18:11
 */
public class Solution {
    public int rotatedDigits(int N) {
        int res = 0;
        if (N > 11) {
            res = 4;
        }
        for (int i = 12; i <= N; i++) {
            String num = String.valueOf(i);
            if (num.contains("3") || num.contains("4") || num.contains("7")) {
                continue;
            }
            if (num.contains("2") || num.contains("5") || num.contains("6") || num.contains("9")) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rotatedDigits(40));
    }
}
