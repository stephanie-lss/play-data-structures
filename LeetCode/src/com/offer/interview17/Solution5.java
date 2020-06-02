package com.offer.interview17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/6/2 9:51
 */
public class Solution5 {

    private List<Integer> list;

    public int[] printNumbers(int n) {
        list = new ArrayList<>();
        dfs(n, 0, new StringBuilder());
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(int n, int i, StringBuilder sb) {
        if (i == n) {
            while (sb.length() != 0 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
            if (sb.length() != 0) {
                list.add(Integer.valueOf(sb.toString()));
            }
            return;
        }
        for (int j = 0; j < 10; j++) {
            sb.append(j);
            dfs(n, i + 1, sb);
            if (sb.length() != 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution5().printNumbers(3));
    }
}
