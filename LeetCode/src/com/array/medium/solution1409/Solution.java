package com.array.medium.solution1409;

import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/4/12 18:34
 */
public class Solution {
    public int[] processQueries(int[] queries, int m) {
        int[] res = new int[queries.length];
        LinkedList<Integer> M = new LinkedList<>();
        for (int i = 1; i <= m; i++) {
            M.add(i);
        }
        for (int i = 0; i < queries.length; i++) {
            int index = M.indexOf(queries[i]);
            res[i] = index;
            M.remove(index);
            M.addFirst(queries[i]);
        }
        return res;
    }
}
