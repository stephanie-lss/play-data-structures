package com.offer.interview58_II;

/**
 * @author LiSheng
 * @date 2020/6/16 10:49
 */
public class Solution3 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
