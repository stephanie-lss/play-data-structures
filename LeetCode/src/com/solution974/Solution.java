package com.solution974;

/**
 * @author LiSheng
 * @date 2020/5/27 8:49
 */
class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int[] preSum = new int[A.length + 1];
        int res = 0;
        for (int i = 1; i <= A.length; i++) {
            preSum[i] = preSum[i - 1] + A[i - 1];
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j <= A.length; j++) {
                if ((preSum[j] - preSum[i]) % K == 0) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {4, 5, 0, -2, -3, 1};
        int K = 5;
        System.out.println(new Solution().subarraysDivByK(A, K));
    }
}
