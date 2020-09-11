package com.interview.solution8_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/7/1 9:22
 */
class Solution2 {
    private List<String> list;
    private boolean[] visited;

    public String[] permutation(String S) {
        if (S.length() == 0) {
            return new String[0];
        }
        char[] array = S.toCharArray();
        Arrays.sort(array);
        S = String.valueOf(array);
        this.visited = new boolean[S.length()];
        this.list = new ArrayList<>();
        dfs(S, 0, new StringBuilder());
        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
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
            if (j > 0 && s.charAt(j) == s.charAt(j - 1) && !visited[j-1]) {
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
        String[] res = new Solution2().permutation(S);
        for (String re : res) {
            System.out.print(re + " ");
        }
    }
}