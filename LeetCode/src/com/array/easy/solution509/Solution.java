package com.array.easy.solution509;

/**
 * @author LiSheng
 * @date 2020/3/27 20:26
 */
public class Solution {
    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1){
            return 1;
        }

        return fib(N - 1) + fib(N - 2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fib(4));
    }
}
