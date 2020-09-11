package com.string.easy.solution929;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/4/5 19:13
 */
public class Solution2 {
    public int numUniqueEmails(String[] emails) {
        Set<String> res = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            StringBuilder sb = new StringBuilder();
            String[] strings = emails[i].split("@");
            for (int j = 0; j < strings[0].length(); j++) {
                char c = emails[i].charAt(j);
                if (c == '+') {
                    break;
                } else if (c == '.') {
                    continue;
                } else {
                    sb.append(c);
                }
            }
            res.add(sb.append('@').append(strings[1]).toString());
        }
        return res.size();
    }

    public static void main(String[] args) {
        String[] em = {"test.email+alex@leetcode.com", "test.email.leet+alex@code.com"};
        System.out.println(new Solution2().numUniqueEmails(em));
    }
}
