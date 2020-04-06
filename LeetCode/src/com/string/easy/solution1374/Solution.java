package com.string.easy.solution1374;

/**
 * @author LiSheng
 * @date 2020/4/5 23:54
 */
public class Solution {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; i++) {
                sb.append("a");
            }
            sb.append("b");
        } else {
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateTheString(77));
    }
}
