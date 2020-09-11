package com.math.easy.solution172;

/**
 * @author LiSheng
 * @date 2020/4/8 12:14
 */
public class Solution {
    public int trailingZeroes(int n) {
        long sum = helper(n);
        long tmp = (sum % 10);
        sum /= 10;
        int count = 0;
        if (tmp == 0) {
            count = 1;
        } else {
            return 0;
        }

        while (sum != 0) {
            tmp = (sum % 10);
            sum /= 10;
            if (tmp == 0) {
                count++;
            } else {
                return count;
            }
        }
        return count;
    }

    private long helper(int n) {
        if (n == 1) {
            return 1;
        }
        return helper(n - 1) * n;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trailingZeroes(20));
    }
}
