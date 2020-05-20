package com.offer.intervirew46;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/5/19 10:02
 */
class Solution {
    private int res = 0;
    private Set<String> set;

    public int translateNum(int num) {
        set = new HashSet<>();
        String s = String.valueOf(num);
        dfs(s, 0, new StringBuilder());
        return res;
    }

    private void dfs(String s, int i, StringBuilder sb) {
        if (i >= s.length()) {
            if (!set.contains(sb.toString())) {
                res++;
                set.add(sb.toString());
            }
            return;
        }

        for (int j = 1; j <= 2; j++) {
            String str = (i + j) >= s.length() ? s.substring(i) : s.substring(i, i + j);
            if (Integer.valueOf(str) >= 0 && Integer.valueOf(str) <= 25) {
                if (str.length() == 2 && str.charAt(0) == '0') {
                    return;
                }
                sb.append(Character.valueOf((char) (Integer.valueOf(str) + 97)));
                dfs(s, i + j, sb);
                sb.deleteCharAt(sb.length() - 1);
            } else {
                return;
            }
        }
    }
}