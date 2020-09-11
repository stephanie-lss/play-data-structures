package com.dp.linear.solution10;

/**
 * @author LiSheng
 * @date 2020/4/22 20:52
 */
class Solution2 {
    int n, m;

    public boolean isMatch(String s, String p) {
        n = s.length();
        m = p.length();
        return helper(s, 0, p, 0);
    }

    private boolean helper(String s, int ls, String p, int lp) {
        if (lp == m) {
            return ls == n;
        }
        if (lp < m - 1 && p.charAt(lp + 1) == '*') {
            if (ls < n && (p.charAt(lp) == '.' || p.charAt(lp) == s.charAt(ls))) {
                return helper(s, ls + 1, p, lp) || helper(s, ls, p, lp + 2);
            }
            return helper(s, ls, p, lp + 2);
        }
        if (ls < n && (p.charAt(lp) == '.' || p.charAt(lp) == s.charAt(ls))) {
            return helper(s, ls + 1, p, lp + 1);
        }
        return false;
    }
}
