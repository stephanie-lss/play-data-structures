package com.array.easy.solution1018;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/3/28 16:41
 */
public class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            BigInteger sum = BigInteger.ZERO;
            for (int j = 0; j <= i; j++) {
                sum = sum.add((new BigInteger("2").pow(i - j)).multiply(new BigInteger(String.valueOf(A[j]))));
            }
            if (sum.mod(new BigInteger("5")).equals(new BigInteger("0"))) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1};
//        int[] A = {0,1,1};
        new Solution().prefixesDivBy5(A);
    }
}
