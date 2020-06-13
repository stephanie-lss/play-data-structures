package com.offer.interview50;

/**
 * @author LiSheng
 * @date 2020/6/13 10:17
 */
public class Solution4 {
    public char firstUniqChar(String s) {
        char res = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            res ^= s.charAt(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution4().firstUniqChar("abaccdeff"));
    }
}
