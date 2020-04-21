package com.dp.linear.solution300;

/**
 * @author LiSheng
 * @date 2020/4/20 11:38
 */
public class solution3 {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;

        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int m = i + (j - i) / 2;
                if (tails[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = num;
            if (res == j) {
                res++;
            }
        }
        return res;
    }
}
