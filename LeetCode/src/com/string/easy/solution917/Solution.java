package com.string.easy.solution917;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/4/5 13:12
 */
public class Solution {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        Map<Integer, Character> record = new LinkedHashMap<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                res.append(chars[i]);
            } else {
                record.put(i, chars[i]);
            }
        }
        res = res.reverse();
        for (Map.Entry<Integer, Character> entry : record.entrySet()) {
            res.insert((int) entry.getKey(), entry.getValue());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
