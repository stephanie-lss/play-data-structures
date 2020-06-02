package com.offer.interview64;

/**
 * @author LiSheng
 * @date 2020/6/2 8:42
 */
public class Solution2 {
    public int sumNums(int n) {
        int sum = n;
        boolean flag = (n > 0) && (sum += sumNums(n - 1)) > 0;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().sumNums(3));
    }
}
