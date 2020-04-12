package com.math.easy.solution908;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/4/9 23:05
 */
public class Solution {
    public int smallestRangeI(int[] A, int K) {
        Arrays.sort(A);
        return (A[A.length - 1] - A[0] - 2 * K <= 0) ? 0 : (A[A.length - 1] - A[0] - 2 * K);
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 6};
        int K = 3;
        System.out.println(new Solution().smallestRangeI(A, K));
    }
}
