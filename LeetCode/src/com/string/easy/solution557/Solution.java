package com.string.easy.solution557;

/**
 * @author LiSheng
 * @date 2020/4/4 11:36
 */
public class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] strings = s.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (i == strings.length - 1) {
                res.append(new StringBuilder().append(strings[i]).reverse());
            } else {
                res.append(new StringBuilder().append(strings[i]).reverse()).append(" ");
            }
        }
        return res.toString();
    }
}
