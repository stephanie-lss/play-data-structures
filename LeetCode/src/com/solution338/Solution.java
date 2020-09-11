package com.solution338;

/**
 * @author LiSheng
 * @date 2020/4/28 10:57
 */
class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            int n = i;
            while (n != 0) {
                if ((n & 1) == 1) {
                    res[i]++;
                }
                n >>= 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countBits(2));
    }
}
