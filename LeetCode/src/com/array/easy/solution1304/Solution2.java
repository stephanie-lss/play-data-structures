package com.array.easy.solution1304;

/**
 * @author LiSheng
 * @date 2020/3/31 21:23
 */
public class Solution2 {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n - 1; i++) {
            res[i] = i;
        }
        res[n - 1] = -(n - 2) * (n - 1) / 2;
        return res;
    }

    public static void main(String[] args) {
        new Solution2().sumZero(6);
    }
}
