package com.solution974;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/5/27 9:18
 */
class Solution2 {
    public int subarraysDivByK(int[] A, int K) {
        int res = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        int sum = 0;
        for (int a : A) {
            sum += a;
            int t = (sum % K + K) % K;
            if (preSum.containsKey(t)) {
                res += preSum.get(t);
            }
            preSum.put(t, preSum.getOrDefault(t, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {-1, 2, 9};
        int K = 2;
        System.out.println(new Solution2().subarraysDivByK(A, K));
    }
}
