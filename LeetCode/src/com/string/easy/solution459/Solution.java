package com.string.easy.solution459;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/4/3 20:37
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1) {
            return false;
        }
        int n = s.length();
        int size = 1;
        int left = 0;
        int right = size;
        Set<String> set = new HashSet<>();
        while (size <= n / 2 && right <= n) {
            String substring = s.substring(left, right);
            set.add(substring);
            left = right;
            right = right + size;
            if (set.size() > 1) {
                set.clear();
                size++;
                left = 0;
                right = size;
            }
        }
        return left == n;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().repeatedSubstringPattern("babbabbabbabbab"));
    }
}
