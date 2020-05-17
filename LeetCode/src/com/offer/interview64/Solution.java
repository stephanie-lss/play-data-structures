package com.offer.interview64;

/**
 * @author LiSheng
 * @date 2020/5/10 18:39
 */
class Solution {
    public int sumNums(int n) {
        int sum = n;
        boolean flag = (n > 0) && (sum += sumNums(n - 1)) > 0;
        return sum;
    }
}
