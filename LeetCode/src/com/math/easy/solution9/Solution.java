package com.math.easy.solution9;

/**
 * @author LiSheng
 * @date 2020/2/22 16:01
 */
public class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }else {
                return false;
            }
        }
        return true;
    }
}
