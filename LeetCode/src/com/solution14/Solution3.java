package com.solution14;

/**
 * @author LiSheng
 * @date 2020/2/22 17:12
 */
public class Solution3 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(str) != 0) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.isEmpty()) {
                return "";
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String[] strs = {"ca", "baaa", "dd"};
        System.out.println(new Solution3().longestCommonPrefix(strs));
    }
}
