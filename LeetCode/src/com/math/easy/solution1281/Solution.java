package com.math.easy.solution1281;

/**
 * @author LiSheng
 * @date 2020/4/9 13:11
 */
public class Solution {
    public int subtractProductAndSum(int n) {
        int mut = 1;
        int sum = 0;
        while (n != 0) {
            int t = n % 10;
            n /= 10;
            mut *= t;
            sum += t;
        }
        return mut - sum;
    }
}
