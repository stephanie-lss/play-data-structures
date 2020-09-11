package com.solution22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/9 9:23
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(new char[2 * n], 0, res);
        return res;
    }

    private void helper(char[] cur, int p, List<String> res) {
        if (p == cur.length) {
            if (valid(cur)) {
                res.add(new String(cur));
            }
        } else {
            cur[p] = '(';
            helper(cur, p + 1, res);
            cur[p] = ')';
            helper(cur, p + 1, res);
        }
    }
    private boolean valid(char[] cur) {
        int flag = 0;
        for (char c : cur) {
            if (c == '(') {
                flag++;
            } else {
                flag--;
            }
            if (flag < 0) {
                return false;
            }
        }
        return flag == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}
