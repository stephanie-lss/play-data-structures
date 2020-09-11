package com.zhousai.two;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author LiSheng
 * @date 2020/4/18 15:06
 */
class Solution {
    int count = 0;
    int N;

    public int numWays(int n, int[][] relation, int k) {
        int row = relation.length;
        N = n;
        Arrays.sort(relation, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] - o2[0] > 0) {
                    return 1;
                } else if (o1[0] - o2[0] < 0) {
                    return -1;
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        for (int i = 0; i < row; i++) {
            if (relation[i][0] == 0) {
                helper(relation[i][1], relation, k-1);
            }
        }
        return count;
    }

    private void helper(int next, int[][] relation, int k) {
        if (k == 0) {
            if (next == N - 1) {
                count++;
            }
            return;
        }

        for (int i = 0; i < relation.length; i++) {
            if (relation[i][0] == next) {
                helper(relation[i][1], relation, k-1);
            }
        }
    }

    public static void main(String[] args) {
//        int[][] rel = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        int[][] rel = {{0, 2}, {2, 1}};
        System.out.println(new Solution().numWays(3, rel, 2));
    }
}