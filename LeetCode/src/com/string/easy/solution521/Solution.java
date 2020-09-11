package com.string.easy.solution521;

/**
 * @author LiSheng
 * @date 2020/4/3 21:48
 */
public class Solution {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return a.length()>b.length()?a.length():b.length();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findLUSlength("abc","ab"));
    }
}
