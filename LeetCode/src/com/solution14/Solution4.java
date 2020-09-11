package com.solution14;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author LiSheng
 * @date 2020/6/15 8:39
 */
public class Solution4 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        boolean isPre = true;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != strs[0].charAt(i)) {
                    isPre = false;
                    break;
                }
            }
            if (isPre) {
                sb.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
