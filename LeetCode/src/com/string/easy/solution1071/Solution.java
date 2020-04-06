package com.string.easy.solution1071;

/**
 * @author LiSheng
 * @date 2020/4/5 20:41
 */
public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int idx = Math.min(str1.length(),str2.length());
        while (idx > 0) {
            if ("".equals(str2.replace(str1.substring(0, idx), "")) && "".equals(str1.replace(str1.substring(0, idx), ""))) {
                break;
            } else {
                idx--;
            }
        }
        return str2.substring(0, idx);
    }

    public static void main(String[] args) {
        String str1 = "TAUXXTAUXXTAUXXTAUXXTAUXX";
        String str2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        System.out.println(new Solution().gcdOfStrings(str1, str2));
    }
}
