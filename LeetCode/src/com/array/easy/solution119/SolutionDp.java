package com.array.easy.solution119;

import java.util.Arrays;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/3/27 21:57
 */
class SolutionDp {
    public List<Integer> getRow(int rowIndex) {
        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i < dp.length; i++) {
            for (int j = i - 1; j > 0; j--) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        List<Integer> res = Arrays.asList(dp);
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = new SolutionDp().getRow(3);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}