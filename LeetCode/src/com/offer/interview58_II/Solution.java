package com.offer.interview58_II;

/**
 * @author LiSheng
 * @date 2020/5/10 18:28
 */
class Solution {
    public String reverseLeftWords(String s, int n) {
        n %= s.length();
        return s.substring(n) + s.substring(0, n);
    }
}