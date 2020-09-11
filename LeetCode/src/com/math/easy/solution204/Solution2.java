package com.math.easy.solution204;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/4/8 13:07
 */
public class Solution2 {
    public int countPrimes(int n) {
        int res = 0;
        boolean[] flag = new boolean[n];
        Arrays.fill(flag, true);

        for (int i = 2; i * i < n; i++) {
            if (isPrime(i)) {
                for (int j = i * i; j < n; j += i) {
                    flag[j] = false;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (flag[i]) {
                res++;
            }
        }
        return res;
    }

    private boolean isPrime(int i) {
        for (int j = 2; j * j < i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().countPrimes(10));
    }
}
