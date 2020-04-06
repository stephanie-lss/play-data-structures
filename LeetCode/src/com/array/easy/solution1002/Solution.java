package com.array.easy.solution1002;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/3/28 14:16
 */
class Solution {
    public List<String> commonChars(String[] A) {
        String str = A[0];
        List<String> res = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            for (int j = 1; j < A.length; j++) {
                if (!contain(A, j, c)) {
                    break;
                }
                if (j == A.length - 1) {
                    res.add(c + "");
                }
            }
        }
        return res;
    }

    private boolean contain(String[] s, int j, char c) {
        int i = s[j].indexOf(c);
        if (i < 0) {
            return false;
        }
        s[j] = s[j].substring(0, i) + s[j].substring(i + 1);
        return true;
    }

    public static void main(String[] args) {
        String[] A = {"cool","lock","cook"};
        List<String> list = new Solution().commonChars(A);
        for (String s : list) {
            System.out.print(s+" ");
        }
    }
}