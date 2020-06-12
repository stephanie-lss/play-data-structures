package com.offer.interview46;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/6/11 9:33
 */
class Solution4 {
    private Set<String> set;

    public int translateNum(int num) {
        this.set = new HashSet<>();
        String str = String.valueOf(num);
        dfs(str, 0, new StringBuilder());
        return set.size();
    }

    private void dfs(String str, int i, StringBuilder sb) {
        if (i >= str.length()) {
            set.add(sb.toString());
            return;
        }
        sb.append(Character.valueOf((char) (str.charAt(i) + 97)));
        dfs(str, i + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        if (i + 2 <= str.length()) {
            String tmp = str.substring(i, i + 2);
            if (tmp.compareTo("25") <= 0 && tmp.compareTo("10") >= 0) {
                sb.append(Character.valueOf((char) (Integer.valueOf(tmp) + 97)));
                dfs(str, i + 2, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution4().translateNum(506));
    }
}