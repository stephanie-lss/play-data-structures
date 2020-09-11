package com.interview.solution8_9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/7/1 17:09
 */
class Solution {
    private List<String> res;

    public List<String> generateParenthesis(int n) {
        int leftBracket = n, rightBracket = n;
        this.res = new ArrayList<>();
        dfs(leftBracket, rightBracket, new StringBuilder());
        return res;
    }

    private void dfs(int leftBracket, int rightBracket, StringBuilder sb) {
        if (leftBracket == 0 && rightBracket == 0) {
            res.add(sb.toString());
            return;
        }

        if (leftBracket > rightBracket) {
            return;
        }

        if (leftBracket > 0) {
            sb.append("(");
            dfs(leftBracket - 1, rightBracket, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rightBracket > 0) {
            sb.append(")");
            dfs(leftBracket, rightBracket - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> list = new Solution().generateParenthesis(3);
        for (String s : list) {
            System.out.print(s + " ");
        }
    }
}