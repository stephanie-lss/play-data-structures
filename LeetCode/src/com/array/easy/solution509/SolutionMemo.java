package com.array.easy.solution509;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/3/27 20:26
 */
public class SolutionMemo {
    public int fib(int N) {
        int[] memo = new int[N + 1];
        Arrays.fill(memo, -1);
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }

        if (memo[N] == -1) {
            memo[N] = fib(N - 1) + fib(N - 2);
        }
        return memo[N];
    }

    public static void main(String[] args) {
        System.out.println(new SolutionMemo().fib(4));
    }
}
