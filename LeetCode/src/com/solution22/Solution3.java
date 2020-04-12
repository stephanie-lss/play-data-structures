package com.solution22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/9 9:23
 */
public class Solution3 {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    private void dfs(int l, int r, String str) {
        if (l == 0 && r == 0) {
            res.add(str);
            return;
        }
        if (l > 0) {
            dfs(l - 1, r, str + "(");
        }
        if (r > 0 && r > l) {
            dfs(l, r - 1, str + ")");
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().generateParenthesis(3));
    }
}
