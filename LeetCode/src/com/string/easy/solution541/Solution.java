package com.string.easy.solution541;

/**
 * @author LiSheng
 * @date 2020/4/3 21:55
 */
public class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder resBuilder = new StringBuilder();
        while (s.length() >= 2 * k) {
            StringBuilder sb = new StringBuilder();
            String s1 = s.substring(0, k);
            String s2 = s.substring(k, 2 * k);
            s = s.substring(2 * k);
            sb.append(s1).reverse().append(s2);
            resBuilder.append(sb);
        }
        if (s.length() < k) {
            resBuilder.append(new StringBuilder().append(s).reverse());
        } else {
            String s1 = s.substring(0, k);
            resBuilder.append(new StringBuilder().append(s1).reverse().append(s.substring(k)));
        }
        return resBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseStr("abcdefghijklm", 3));
    }
}
