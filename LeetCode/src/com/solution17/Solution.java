package com.solution17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/2/26 17:51
 */
public class Solution {
    static String[] phone = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return res;
        }

        findCombination(digits, 0, "");
        return res;
    }

    private void findCombination(String digits, int index, String s) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        char c = digits.charAt(index);
        String letters = phone[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index + 1, s + letters.charAt(i));
        }

    }

}
