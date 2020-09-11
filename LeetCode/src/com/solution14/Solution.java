package com.solution14;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/2/22 17:12
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int min = strs[0].length();
        int index = 0;
        for (int i = 1; i < strs.length; i++) {
            if (min > strs[i].length()) {
                min = strs[i].length();
                index = i;
            }
        }

        for (int i = 0; i < min; i++) {
            List<Character> list = new ArrayList<>();
            list.add(strs[index].charAt(i));
            for (int j = 0; j < strs.length; j++) {
                if (!list.contains(strs[j].charAt(i))) {
                    return sb.toString();
                }
            }
            sb.append(list.remove(0));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {};
        System.out.println(new Solution().longestCommonPrefix(strs));
    }
}
