package com.array.medium.solution216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/14 15:01
 */
public class Solution {
    boolean[] used = new boolean[10];
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(new LinkedList<>(), 0, k, n);
        return res;
    }
    private void dfs(LinkedList<Integer> list, int index, int k, int n) {
        if (index == k) {
            int sum = 0;
            for (Integer i : list) {
                sum += i;
            }
            if (sum == n) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        int i = 1;
        if (!list.isEmpty()) {
            i = list.getLast();
        }
        for (; i < 10; i++) {
            if (!used[i]) {
                used[i] = true;
                list.add(i);
                dfs(list, index + 1, k, n);
                list.removeLast();
                used[i] = false;
            }
        }
    }
}
