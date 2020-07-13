package com.solution17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/7/7 19:24
 */
public class Solution2 {
    private List<String> list;

    public int[] printNumbers(int n) {
        if (n == 0) {
            return new int[0];
        }
        this.list = new ArrayList<>();
        dfs(0, n, new StringBuilder());
        int[] res = new int[list.size()];
        for (String s : list) {
            System.out.print(s + " ");
        }
        return res;
    }

    private void dfs(int i, int n, StringBuilder sb) {
        if (i == n) {
            while (sb.length() != 0 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
            if (sb.length() != 0) {
                list.add(sb.toString());
            }
            return;
        }
        for (int j = 0; j < 10; j++) {
            sb.append(j);
            dfs(i + 1, n, sb);
            if (sb.length() != 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        new Solution2().printNumbers(6);
    }
}
