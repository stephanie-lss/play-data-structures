package com.dp.linear.solution120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/7/14 8:52
 */
public class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.get(0) == null || triangle.get(0).size() == 0) {
            return 0;
        }
        int len = triangle.size();
        if (len == 1) {
            return triangle.get(0).get(0);
        }
        // dp[i][j]表示到triangle.get(i - 1).get(j - 1)个元素时的最短路径
        int[][] dp = new int[len + 1][len + 2];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[1][1] = triangle.get(0).get(0);
        int minPath = Integer.MAX_VALUE;
        for (int i = 2; i <= len; i++) {
            for (int j = 1; j <= triangle.get(i - 1).size(); j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i - 1).get(j - 1);
                minPath = i == len ? Math.min(minPath, dp[i][j]) : minPath;
            }
        }
        return minPath;
    }

    public static void main(String[] args) {
        List<List<Integer>> tr = new ArrayList<>();
        List<Integer> one1 = new ArrayList<>(Arrays.asList(-1));
        List<Integer> one2 = new ArrayList<>(Arrays.asList(3, 2));
        List<Integer> one3 = new ArrayList<>(Arrays.asList(-3, 1, -1));
        tr.add(one1);
        tr.add(one2);
        tr.add(one3);
        System.out.println(new Solution2().minimumTotal(tr));
    }
}
