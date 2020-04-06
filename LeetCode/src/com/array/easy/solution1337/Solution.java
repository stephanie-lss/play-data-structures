package com.array.easy.solution1337;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/3/31 21:56
 */
public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> bat = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            bat.put(i, 0);
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    bat.put(i, ++count);
                }
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        list.addAll(bat.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        int[] res = new int[k];
        int idx = 0;
        for (Iterator<Map.Entry<Integer, Integer>> it = list.iterator(); it.hasNext(); ) {
            res[idx++] = it.next().getKey();
            if (idx == k) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 0}, {0, 0}, {1, 0}};
        int k = 2;
        new Solution().kWeakestRows(mat, k);
    }
}
