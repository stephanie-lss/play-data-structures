package com.math.easy.solution633;

/**
 * @author LiSheng
 * @date 2020/4/8 18:31
 */
public class Solution {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            int sub = c - (left * left + right * right);
            if (sub == 0) {
                return true;
            } else if (sub > 0) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().judgeSquareSum(0));
    }
}
