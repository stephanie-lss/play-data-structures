package com.offer.interview46;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/5/19 10:02
 */
class Solution {
    private Set<String> set;

    public int translateNum(int num) {
        set = new HashSet<>();
        dfs(String.valueOf(num), 0, new StringBuilder());
        return set.size();
    }

    private void dfs(String s, int i, StringBuilder sb) {
        if (i >= s.length()) {
            set.add(sb.toString());
            return;
        }

        for (int j = 1; j <= 2; j++) {
            String str = (i + j) >= s.length() ? s.substring(i) : s.substring(i, i + j);
            if (str.compareTo("0") >= 0 && str.compareTo("25") <= 0) {
                System.out.println(str);
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

    public static void main(String[] args) {
        System.out.println(new Solution().translateNum(12258));
    }
}