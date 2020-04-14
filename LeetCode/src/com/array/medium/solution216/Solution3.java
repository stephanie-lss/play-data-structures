package com.array.medium.solution216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/14 15:01
 */
public class Solution3 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(new LinkedList<>(), k, n, 1);
        return res;
    }

    private void dfs(LinkedList<Integer> list, int k, int n, int start) {
        System.out.println(start);
        if (n < 0 || k < 0) {
            return;
        }
        if (0 == k && 0 == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < 10; i++) {
            list.add(i);
            dfs(list, k - 1, n - i, i + 1);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().combinationSum3(3, 9));
    }
}
