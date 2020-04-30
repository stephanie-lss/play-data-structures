package com.solution461;

/**
 * @author LiSheng
 * @date 2020/4/28 10:44
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int res = 0;
        while (n != 0) {
            if (n % 2 == 1) {
                res++;
            }
            n /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(3 & 1);
        System.out.println(4 & 1);
    }
}
