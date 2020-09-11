package com.math.easy.solution1317;

/**
 * @author LiSheng
 * @date 2020/4/10 13:13
 */
public class Solution {
    public int[] getNoZeroIntegers(int n) {
        int left = 1;
        int right = n - 1;
        while (String.valueOf(right).indexOf('0') >= 0 || String.valueOf(left).indexOf('0') >= 0) {
            left++;
            right--;
        }
        return new int[]{left, right};
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getNoZeroIntegers(11));
    }
}
