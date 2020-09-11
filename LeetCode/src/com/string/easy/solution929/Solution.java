package com.string.easy.solution929;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/4/5 19:13
 */
public class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> res = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < emails[i].length(); j++) {
                char c = emails[i].charAt(j);
                if (c == '@') {
                    sb.append(emails[i].substring(j));
                    res.add(sb.toString());
                    break;
                } else if (c == '+') {
                    while (emails[i].charAt(j) != '@') {
                        j++;
                    }
                    sb.append(emails[i].substring(j));
                    res.add(sb.toString());
                } else if (c == '.') {
                    continue;
                } else {
                    sb.append(c);
                }
            }
        }
        return res.size();
    }

    public static void main(String[] args) {
        String[] em = {"testemail@leetcode.com", "testemail1@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(new Solution().numUniqueEmails(em));
    }
}
