package com.math.easy.solution168;

/**
 * @author LiSheng
 * @date 2020/4/8 11:23
 */
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            int n1 = n % 26;
            n /= 26;
            if (n1 == 0) {
                n--;
                sb.append('Z');
            } else {
                sb.append((char) (n1 + 64));
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle(701));
    }
}
