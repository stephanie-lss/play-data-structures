package com.solution22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/9 9:23
 */
public class Solution2 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            res.add(cur.toString());
            return;
        }

        if (open < max) {
            backtrack(res, cur.append('('), open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            backtrack(res, cur.append(')'), open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().generateParenthesis(3));
    }
}
