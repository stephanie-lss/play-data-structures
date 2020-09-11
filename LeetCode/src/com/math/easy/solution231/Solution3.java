package com.math.easy.solution231;

/**
 * @author LiSheng
 * @date 2020/4/8 14:29
 */
public class Solution3 {
    public boolean isPowerOfTwo(int n) {
        return (n & n - 1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().isPowerOfTwo(1));
    }
}
