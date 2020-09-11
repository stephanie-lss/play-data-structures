package com.solution1014;

/**
 * @author LiSheng
 * @date 2020/6/17 8:39
 * NOT AC
 */
public class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                max = Math.max(max, A[j] + A[i] + i - j);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {8, 1, 5, 2, 6};
        System.out.println(new Solution().maxScoreSightseeingPair(A));
    }
}
