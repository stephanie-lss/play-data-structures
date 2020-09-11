package com.solution14;

/**
 * @author LiSheng
 * @date 2020/2/22 17:12
 */
public class Solution2 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int min = strs[0].length();
        int index = 0;
        for (int i = 1; i < strs.length; i++) {
            if (min > strs[i].length()) {
                min = strs[i].length();
                index = i;
            }
        }
        String str = strs[index];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(str) != 0) {
                str = str.substring(0, str.length() - 1);
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(new Solution2().longestCommonPrefix(strs));
    }
}
