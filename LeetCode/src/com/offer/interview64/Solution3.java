package com.offer.interview64;

/**
 * @author LiSheng
 * @date 2020/6/19 10:14
 */
public class Solution3 {
    public int sumNums(int n) {

        int sum = n;
        boolean flag = (n > 0) && (sum += sumNums(n - 1)) > 0;
        return sum;
    }
}
