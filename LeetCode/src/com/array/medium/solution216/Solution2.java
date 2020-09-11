package com.array.medium.solution216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/14 15:01
 */
public class Solution2 {
    boolean[] used = new boolean[10];
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(new LinkedList<>(), 0, 0, k, n);
        return res;
    }

    private void dfs(LinkedList<Integer> list, int index, int sum, int k, int n) {
        if (index == k && sum == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = list.isEmpty() ? 1 : list.getLast(); i < 10; i++) {
            if (!used[i]) {
                used[i] = true;
                list.add(i);
                sum += i;
                dfs(list, index + 1, sum, k, n);
                sum -= i;
                list.removeLast();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().combinationSum3(3, 9));
    }
}
