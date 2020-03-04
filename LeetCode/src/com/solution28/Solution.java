package com.solution28;

/**
 * @author LiSheng
 * @date 2020/2/22 17:08
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("aaa","bba"));
    }
}
