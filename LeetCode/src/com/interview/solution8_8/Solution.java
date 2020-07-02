package com.interview.solution8_8;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/7/1 11:10
 */
class Solution {
    private Set<String> list;
    private boolean[] visited;

    public String[] permutation(String S) {
        if (S.length() == 0) {
            return new String[0];
        }
        this.visited = new boolean[S.length()];
        this.list = new HashSet<>();
        dfs(S, 0, new StringBuilder());
        String[] res = new String[list.size()];
        int idx = 0;
        for (String s : list) {
            res[idx++] = s;
        }
        return res;
    }

    private void dfs(String s, int i, StringBuilder sb) {
        if (i == s.length()) {
            list.add(sb.toString());
            return;
        }

        for (int j = 0; j < s.length(); j++) {
            if (visited[j]) {
                continue;
            }
            visited[j] = true;
            sb.append(s.charAt(j));
            dfs(s, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
            visited[j] = false;
        }
    }

    public static void main(String[] args) {
        String S = "qqe";
        String[] res = new com.interview.solution8_8.Solution().permutation(S);
        for (String re : res) {
            System.out.print(re + " ");
        }
    }
}