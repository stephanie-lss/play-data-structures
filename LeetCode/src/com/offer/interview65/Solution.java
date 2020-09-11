package com.offer.interview65;

/**
 * @author LiSheng
 * @date 2020/5/17 16:27
 */
class Solution {
    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }

        return add(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().add(984, -19));
    }
}