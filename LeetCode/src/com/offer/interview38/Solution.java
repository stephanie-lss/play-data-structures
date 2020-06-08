package com.offer.interview38;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/6/6 11:39
 */
public class Solution {
    private Set<String> set;
    private boolean[] visited;

    public String[] permutation(String s) {
        char[] array = s.toCharArray();
        set = new HashSet<>();
        visited = new boolean[array.length];
        dfs(array, 0, new StringBuilder());
        return set.toArray(new String[0]);
    }

    private void dfs(char[] array, int i, StringBuilder sb) {
        if (i == array.length) {
            set.add(sb.toString());
            return;
        }
        for (int j = 0; j < array.length; j++) {
            if (!visited[j]) {
                visited[j] = true;
                sb.append(array[j]);
                dfs(array, i + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
                visited[j] = false;
            }
        }
    }
}
