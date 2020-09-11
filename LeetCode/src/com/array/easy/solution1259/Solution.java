package com.array.easy.solution1259;

/**
 * @author LiSheng
 * @date 2020/3/31 21:15
 */
public class Solution {
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int count = 0;
            while (num != 0) {
                num = num / 10;
                count++;
            }
            if (count % 2 == 0) {
                res++;
            }
        }
        return res;
    }
}
