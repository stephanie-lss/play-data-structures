package com.string.medium.solution1016;

/**
 * @author LiSheng
 * @date 2020/4/17 21:06
 */
public class Solution2 {
    public boolean queryString(String S, int N) {
        for (int i = 1; i <= N; i++) {
            if (!S.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().queryString("0110", 3));
    }
}
