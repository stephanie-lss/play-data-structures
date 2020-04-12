package com.math.easy.solution168;

/**
 * @author LiSheng
 * @date 2020/4/8 11:23
 */
public class Solution2 {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            n--;
            sb.append((char) ('A' + n % 26));
            n /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().convertToTitle(701));
    }
}
