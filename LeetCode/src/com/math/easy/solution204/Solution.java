package com.math.easy.solution204;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/3/25 23:56
 */
class Solution {

    public int countPrimes(int n) {
        int count = 0;
        Boolean[] flag = new Boolean[n];
        Arrays.fill(flag, true);
        for (int i = 2; i < n; i++) {
            if (isPrim(i)) {
                for (int j = i * 2; j < n; j += i) {
                    flag[j] = false;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (flag[i]) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrim(int i) {
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().countPrimes(2));
//        System.out.println(new Solution().countPrimes(3));
        System.out.println(new Solution().countPrimes(10));
    }
}