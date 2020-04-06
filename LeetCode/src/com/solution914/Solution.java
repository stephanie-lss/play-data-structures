package com.solution914;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/3/27 14:35
 */
public class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] freq = new int[10000];
        Arrays.fill(freq, 0);
        for (int num : deck) {
            freq[num]++;
        }
        int x = 0;
        for (int n : freq) {
            if (n > 0) {
                x = gcd(x, n);
                if (x == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private int gcd(int a, int b) {
//        return b == 0? a: gcd(b, a % b);
        while (b != 0) {
            int i = a % b;
            a = b;
            b = i;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] deck = {1, 2, 3, 4, 4, 3, 2, 1};
        int[] deck2 = {1, 1, 1, 2, 2, 2, 3, 3};
        int[] deck3 = {1};
        int[] deck4 = {1, 1};
        int[] deck5 = {1, 1, 2, 2, 2, 2};
        System.out.println(new Solution().hasGroupsSizeX(deck));
        System.out.println(new Solution().hasGroupsSizeX(deck2));
        System.out.println(new Solution().hasGroupsSizeX(deck3));
        System.out.println(new Solution().hasGroupsSizeX(deck4));
        System.out.println(new Solution().hasGroupsSizeX(deck5));
        System.out.println(new Solution().gcd(0,2));
        System.out.println(new Solution().gcd(2,0));
    }
}
