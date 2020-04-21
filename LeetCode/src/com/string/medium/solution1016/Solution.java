package com.string.medium.solution1016;

/**
 * @author LiSheng
 * @date 2020/4/17 21:06
 */
public class Solution {
    public boolean queryString(String S, int N) {
        for (int i = 1; i <= N; i++) {
            String str = "";
            int num = i;
            while (num != 0) {
                str = num % 2 + str;
                num /= 2;
            }
            if (!S.contains(str)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().queryString("0110", 3));
    }
}
