package com.solution1014;

/**
 * @author LiSheng
 * @date 2020/6/17 9:03
 */
public class Solution3 {
    public int maxScoreSightseeingPair(int[] A) {
        int res = 0, left = A[0];
        for (int i = 1; i < A.length; i++) {
            res = Math.max(res, A[i] - i + left);
            left = Math.max(left, A[i] + i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {8, 1, 5, 2, 6};
        System.out.println(new Solution3().maxScoreSightseeingPair(A));
    }
}
