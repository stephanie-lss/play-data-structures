package com.string.easy.solution686;

/**
 * @author LiSheng
 * @date 2020/4/4 15:30
 */
public class Solution {
    public int repeatedStringMatch(String A, String B) {
        if (A.contains(B)) {
            return 1;
        }
        if (A.length() >= B.length()) {
            if ((A + A).contains(B)) {
                return 2;
            } else {
                return -1;
            }
        } else {
            String str = A + A;
            int count = 2;
            while (str.length() < 2 * A.length() + B.length()) {
                if (str.contains(B)) {
                    return count;
                } else {
                    str += A;
                    count++;
                }
            }
            return -1;
        }
    }
}
