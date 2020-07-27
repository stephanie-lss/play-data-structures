package com.offer.interview60;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/7/23 10:47
 */
public class Solution5 {
    private double[][] memo;

    public double[] twoSum(int n) {
        if (n <= 0) {
            return new double[0];
        }
        this.memo = new double[6 * n + 1][n + 1];
        for (double[] m : memo) {
            Arrays.fill(m, -1.0);
        }
        double[] res = new double[5 * n + 1];
        int totalCount = (int) Math.pow(6, n);
        int target = n;
        for (int i = 0; i < res.length; i++) {
            res[i] = helper(target++, n) / totalCount;
        }
        return res;
    }

    private double helper(int target, int n) {
        if (n == 0 && target == 0) {
            return 1;
        }
        if (n < 0 || target < 0) {
            return 0;
        }
        if (memo[target][n] != -1) {
            return memo[target][n];
        }
        int sum = 0;
        for (int i = 1; i <= 6; i++) {
            sum += helper(target - i, n - 1);
        }
        memo[target][n] = sum;
        return sum;
    }

    public static void main(String[] args) {
        double[] res = new Solution5().twoSum(11);
        for (double re : res) {
            System.out.println(re);
        }
    }
}
