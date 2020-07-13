package com.solution16_11;

/**
 * @author LiSheng
 * @date 2020/7/8 18:54
 */
class Solution {

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }

        if (shorter == longer) {
            return new int[]{shorter * k};
        }

        int[] res = new int[k + 1];
        for (int i = k; i >= 0; i--) {
            res[k - i] = shorter * i + longer * (k - i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new Solution().divingBoard(1, 2, 3);
        for (int re : res) {
            System.out.println(re);
        }
    }
}