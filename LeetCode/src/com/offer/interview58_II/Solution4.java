package com.offer.interview58_II;

/**
 * @author LiSheng
 * @date 2020/7/23 9:51
 */
public class Solution4 {
    public String reverseLeftWords(String s, int n) {
        char[] sa = s.toCharArray();
        reverse(sa, 0, n-1);
        reverse(sa, n, s.length() - 1);
        reverse(sa, 0, s.length() - 1);
        return String.valueOf(sa);
    }

    public void reverse(char[] sa, int l, int r){
        while(l < r){
            char tmp = sa[l];
            sa[l++] = sa[r];
            sa[r--] = tmp;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution4().reverseLeftWords("abcdefg",2));
    }
}