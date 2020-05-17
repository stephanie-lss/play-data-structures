package com.offer.interview58_II;

/**
 * @author LiSheng
 * @date 2020/5/10 18:32
 */
class Solution2 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder post = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            post.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            post.append(s.charAt(i));
        }
        return post.toString();
    }
}