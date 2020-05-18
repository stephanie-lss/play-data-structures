package com.offer.intervire38;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/5/18 21:30
 */
class Solution {

    private Set<String> res;
    private boolean[] visited;

    public String[] permutation(String s) {
        res = new HashSet<>();
        visited = new boolean[s.length()];
        permute(s, 0, new StringBuilder());
        return res.toArray(new String[0]);
    }

    private void permute(String s, int index, StringBuilder sb) {
        if (index == s.length()) {
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(s.charAt(i));
                permute(s, index + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String str = "aab";
        String[] strings = new Solution().permutation(str);
        for (String string : strings) {
            System.out.print(string + " ");
        }
    }
}