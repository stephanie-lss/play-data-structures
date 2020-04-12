package com.math.easy.solution1175;

/**
 * @author LiSheng
 * @date 2020/4/12 11:07
 */
public class Solution {
    public int numPrimeArrangements(int n) {
        int count = numberOfPrime(n);
        System.out.println(helper(count));
        System.out.println(helper(n - count));
        System.out.println((helper(count) * helper(n - count)) % (1000000007));
        return (int) (helper(count) * helper(n - count) % (1000000007));
    }

    private long helper(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return (n * helper(n - 1)) % (1000000007);
    }

    private int numberOfPrime(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                res++;
            }
        }
        return res;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numPrimeArrangements(20));
    }
}
